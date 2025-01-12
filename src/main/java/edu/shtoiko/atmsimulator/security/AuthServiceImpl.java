package edu.shtoiko.atmsimulator.security;

import edu.shtoiko.grpc.auth.AuthServiceGrpc;
import edu.shtoiko.grpc.auth.AuthServiceProto;
import io.grpc.ManagedChannel;

public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private ManagedChannel channel;
    private String token;
    private String password;
    private Long username;
    private AuthServiceGrpc.AuthServiceBlockingStub authStub;

    public AuthServiceImpl(ManagedChannel channel, String token) {
        this.channel = channel;
        this.token = token;
    }

    public void authenticate(long username, String password) {
        this.username = username;
        this.password = password;
        authStub = AuthServiceGrpc.newBlockingStub(channel);
        AuthServiceProto.AuthRequest request = AuthServiceProto.AuthRequest.newBuilder()
            .setUsername(username)
            .setPassword(password)
            .build();

        AuthServiceProto.AuthResponse response = authStub.authenticate(request);
    }

    public AuthServiceGrpc.AuthServiceBlockingStub getAuthStub() {
        return authStub;
    }
}
