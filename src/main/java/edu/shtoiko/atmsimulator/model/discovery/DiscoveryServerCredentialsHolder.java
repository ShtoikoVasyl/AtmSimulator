package edu.shtoiko.atmsimulator.model.discovery;

public class DiscoveryServerCredentialsHolder {
    private final String serverHost;
    private final int serverPort;
    private final String discoveryUsername;
    private final String discoveryPassword;

    public DiscoveryServerCredentialsHolder(String serverHost, int serverPort, String discoveryUsername,
        String discoveryPassword) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.discoveryUsername = discoveryUsername;
        this.discoveryPassword = discoveryPassword;
    }

    public String getServerHost() {
        return serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getDiscoveryUsername() {
        return discoveryUsername;
    }

    public String getDiscoveryPassword() {
        return discoveryPassword;
    }
}
