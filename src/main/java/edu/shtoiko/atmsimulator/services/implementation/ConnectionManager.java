package edu.shtoiko.atmsimulator.services.implementation;

import edu.shtoiko.atmsimulator.client.implementation.EurekaClient;
import edu.shtoiko.atmsimulator.client.implementation.TerminalServiceClientGrpcImpl;
import edu.shtoiko.atmsimulator.model.discovery.DiscoveryServerCredentialsHolder;
import edu.shtoiko.atmsimulator.model.discovery.Instance;
import edu.shtoiko.atmsimulator.model.Terminal;
import edu.shtoiko.atmsimulator.terminal.Main;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConnectionManager {
    private final ContextHolder contextHolder;
    private final Terminal terminal;
    private final EurekaClient eurekaClient;
    private final Random random;
    private final TerminalServiceClientGrpcImpl terminalServiceClientGrpc;

    public ConnectionManager(ContextHolder contextHolder, DiscoveryServerCredentialsHolder discoveryCredentials,
        String maintenancesServiceName) {
        this.terminal = contextHolder.getTerminal();
        this.contextHolder = contextHolder;
        this.random = new Random();
        this.eurekaClient = new EurekaClient(discoveryCredentials, maintenancesServiceName);
        this.terminalServiceClientGrpc = createNewTerminalServiceClient();
    }

    private TerminalServiceClientGrpcImpl createNewTerminalServiceClient() {
        Instance instance = getRandomServiceInstance();
        TerminalServiceClientGrpcImpl clientGrpc =
            new TerminalServiceClientGrpcImpl(terminal, Main.MAINTENANCE_GRPC_PORT, instance.getIpAddr());
        contextHolder.setTerminalServiceClient(clientGrpc);
        return clientGrpc;
    }

    private Instance getRandomServiceInstance() {
        List<Instance> availableInstances = getAvailableInstances();
        return availableInstances.get(random.nextInt(availableInstances.size()));
    }

    private List<Instance> getAvailableInstances() {
        List<Instance> instances = eurekaClient.getInstances();
        return instances.stream()
            .filter(instance -> instance.getStatus().equals("UP"))
            .collect(Collectors.toList());
    }

    public void authenticate() {
        terminalServiceClientGrpc.authenticate();
    }
}
