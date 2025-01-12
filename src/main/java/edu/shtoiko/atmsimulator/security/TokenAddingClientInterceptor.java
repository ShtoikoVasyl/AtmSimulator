package edu.shtoiko.atmsimulator.security;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

public class TokenAddingClientInterceptor implements ClientInterceptor {

    private final String tokenKey = "Authorization";
    private String token;

    public TokenAddingClientInterceptor(String initialToken) {
        this.token = initialToken;
    }

    public void setToken(String newToken) {
        this.token = newToken;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                if (token != null) {
                    Metadata.Key<String> tokenKeyMetadata = Metadata.Key.of(tokenKey, Metadata.ASCII_STRING_MARSHALLER);
                    headers.put(tokenKeyMetadata, "Bearer " + token);
                }
                super.start(responseListener, headers);
            }
        };
    }

    public String getTokenKey() {
        return tokenKey;
    }
}
