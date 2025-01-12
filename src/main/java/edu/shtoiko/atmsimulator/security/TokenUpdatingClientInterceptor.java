package edu.shtoiko.atmsimulator.security;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

public class TokenUpdatingClientInterceptor implements ClientInterceptor {
    private final String tokenKey;
    private final TokenAddingClientInterceptor tokenAddingClientInterceptor;

    public TokenUpdatingClientInterceptor(TokenAddingClientInterceptor tokenAddingClientInterceptor) {
        this.tokenAddingClientInterceptor = tokenAddingClientInterceptor;
        this.tokenKey = tokenAddingClientInterceptor.getTokenKey();
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                super.start(
                    new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                        @Override
                        public void onClose(Status status, Metadata trailers) {
                            super.onClose(status, trailers);
                            Metadata.Key<String> tokenKeyMetadata =
                                Metadata.Key.of(tokenKey, Metadata.ASCII_STRING_MARSHALLER);
                            String newToken = trailers.get(tokenKeyMetadata);
                            if (newToken != null && newToken.startsWith("Bearer ")) {
                                tokenAddingClientInterceptor.setToken(newToken.substring(7));
                            } else {
                                tokenAddingClientInterceptor.setToken(newToken);
                            }
                        }
                    }, headers);
            }
        };
    }
}
