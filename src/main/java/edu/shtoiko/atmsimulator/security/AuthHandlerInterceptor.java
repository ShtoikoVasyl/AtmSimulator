package edu.shtoiko.atmsimulator.security;

import edu.shtoiko.grpc.auth.AuthServiceGrpc;
import edu.shtoiko.grpc.auth.AuthServiceProto;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

import java.util.concurrent.atomic.AtomicReference;

public class AuthHandlerInterceptor implements ClientInterceptor {
    private final AtomicReference<String> token = new AtomicReference<>();

    private ManagedChannel channel;
    private final Long username;
    private final String password;

    public AuthHandlerInterceptor(long username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                // Додаємо токен до заголовків
                Metadata.Key<String> tokenKeyMetadata =
                    Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
                headers.put(tokenKeyMetadata, "Bearer " + token.get());

                super.start(
                    new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                        @Override
                        public void onClose(Status status, Metadata trailers) {
                            if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                                token.set(fetchNewToken());
                                ClientCall<ReqT, RespT> retryCall = next.newCall(method, callOptions);
                                Metadata newHeaders = new Metadata();
                                newHeaders.put(tokenKeyMetadata, "Bearer " + token.get());

                                retryCall.start(responseListener, newHeaders);
                            } else {
                                super.onClose(status, trailers);
                            }
                        }
                    }, headers);
            }
        };
    }

    private String fetchNewToken() {
        AuthServiceProto.AuthRequest authRequest = AuthServiceProto.AuthRequest.newBuilder()
            .setUsername(username)
            .setPassword(password)
            .build();
        AuthServiceGrpc.AuthServiceBlockingStub authServiceStub = AuthServiceGrpc.newBlockingStub(channel);
        AuthServiceProto.AuthResponse authResponse = authServiceStub.authenticate(authRequest);
        System.out.println(authResponse.getToken());
        return authResponse.getToken();
    }

    public void setChannel(ManagedChannel channel) {
        this.channel = channel;
    }
}