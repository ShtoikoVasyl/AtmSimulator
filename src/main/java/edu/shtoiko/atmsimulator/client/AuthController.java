package edu.shtoiko.atmsimulator.client;

public interface AuthController {
    void authenticate(long terminalId, String password);

    void authenticate();
}
