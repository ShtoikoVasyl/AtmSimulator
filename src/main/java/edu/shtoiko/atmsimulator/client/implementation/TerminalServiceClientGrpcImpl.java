package edu.shtoiko.atmsimulator.client.implementation;

import edu.shtoiko.atmsimulator.model.Terminal;
import edu.shtoiko.atmsimulator.security.AuthServiceImpl;
import edu.shtoiko.atmsimulator.security.TokenAddingClientInterceptor;
import edu.shtoiko.atmsimulator.security.TokenUpdatingClientInterceptor;
import edu.shtoiko.atmsimulator.client.AbstractTerminalServiceClient;
import edu.shtoiko.atmsimulator.exception.WithdrawException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import edu.shtoiko.grpc.*;

public class TerminalServiceClientGrpcImpl extends AbstractTerminalServiceClient {

    private TerminalServiceGrpc.TerminalServiceBlockingStub blockingStub;
    private TerminalServiceGrpc.TerminalServiceStub asyncStub;

    private AuthServiceImpl authService;
    private final Terminal terminal;

    private ManagedChannel channel;

    private String token;

    private TokenAddingClientInterceptor tokenAddingClientInterceptor;
    private TokenUpdatingClientInterceptor tokenUpdatingClientInterceptor;

    public TerminalServiceClientGrpcImpl(Terminal terminal, int port, String host) {
        this.terminal = terminal;
        this.token = null;
        this.tokenAddingClientInterceptor = new TokenAddingClientInterceptor(token);
        this.tokenUpdatingClientInterceptor = new TokenUpdatingClientInterceptor(tokenAddingClientInterceptor);
        System.out.println("Trying create channel(host:" + host + ", port:" + port + ", terminalId:"
            + terminal.getTerminalId() + ", terminalPassword:" + terminal.getPassword() + ")");
        this.channel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .intercept(tokenAddingClientInterceptor, tokenUpdatingClientInterceptor)
            .build();
        asyncStub = TerminalServiceGrpc.newStub(channel);
        blockingStub = TerminalServiceGrpc.newBlockingStub(channel);
        this.authService = new AuthServiceImpl(channel, token);
    }

    public void authenticate(long terminalId, String password) {
        authService.authenticate(terminalId, password);
    }

    public void authenticate() {
        authenticate(terminal.getTerminalId(), terminal.getPassword());
    }

    public boolean withdraw(long accountNumber, short pinCode, long amount, String currencyCode)
        throws WithdrawException {
        TerminalServiceProto.WithdrawRequest request = TerminalServiceProto.WithdrawRequest.newBuilder()
            .setAccountNumber(accountNumber)
            .setPinCode(pinCode)
            .setCurrencyCode(currencyCode)
            .setAmount(amount)
            .build();
        TerminalServiceProto.WithdrawResponse response = null;
        try {
            response = blockingStub.withdraw(request);
        } catch (StatusRuntimeException ex) {
            if (ex.getStatus().getCode().equals(Status.Code.UNAUTHENTICATED)) {
                authenticate();
                response = blockingStub.withdraw(request);
            } else {
                ex.printStackTrace();
            }
        }
        System.out.println(response.getMessage() + ", was withdrawn: " + response.getValue());
        if (response.getValue() != amount) {
            throw new WithdrawException(response.getMessage());
        }
        return true;
    }

    public void reportStatus() {
        StreamObserver<TerminalServiceProto.StatusReport> requestObserver =
            asyncStub.reportStatus(new StreamObserver<TerminalServiceProto.StatusResponse>() {
                @Override
                public void onNext(TerminalServiceProto.StatusResponse value) {
                    System.out.println(value.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Status reporting completed");
                }
            });

        for (int i = 0; i < 5; i++) {
            TerminalServiceProto.StatusReport report = TerminalServiceProto.StatusReport.newBuilder()
                .setTerminalId("terminal123")
                .setBanknotesCode("CurrentCurrency")
                .putBanknotes("50", 10)
                .putBanknotes("100", 5)
                .build();
            requestObserver.onNext(report);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestObserver.onCompleted();
    }

    public void sendLogs() {
        StreamObserver<TerminalServiceProto.LogMessage> requestObserver =
            asyncStub.sendLogs(new StreamObserver<TerminalServiceProto.LogResponse>() {
                @Override
                public void onNext(TerminalServiceProto.LogResponse value) {
                    System.out.println(value.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Log sending completed");
                }
            });
        TerminalServiceProto.LogMessage log = TerminalServiceProto.LogMessage.newBuilder()
            .setLevel("Some level")
            .setMessage("Something hapened")
            .build();
        requestObserver.onNext(log);

        requestObserver.onCompleted();
    }
}
