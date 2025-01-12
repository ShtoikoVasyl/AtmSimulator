package edu.shtoiko.atmsimulator.model;

public class Terminal {
    private Long terminalId;
    private String password;
    private String signature;

    public Terminal(Long terminalId, String password, String signature) {
        this.terminalId = terminalId;
        this.password = password;
        this.signature = signature;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
