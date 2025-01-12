package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.model.discovery.DiscoveryServerCredentialsHolder;
import edu.shtoiko.atmsimulator.model.Terminal;
import edu.shtoiko.atmsimulator.model.currencyes.Currency;
import edu.shtoiko.atmsimulator.model.currencyes.CurrencyFactory;
import edu.shtoiko.atmsimulator.services.implementation.ConnectionManager;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.UnsupportedLookAndFeelException;
import java.util.Scanner;

public class Main {
    public static final int MAINTENANCE_GRPC_PORT = 8009;
    private static final String MAINTENANCE_SERVICE_NAME = "INFRASTRUCTURESERVICE";
    private static final int DISCOVERY_PORT = 8001;
    private static final String DISCOVERY_HOST = "13.36.126.221";
    private static final String DISCOVERY_CLIENT_USERNAME = "shtoiko";
    private static final String DISCOVERY_CLIENT_PASSWORD = "1123";

    private static final Long DEFAULT_TERMINAL_ID = 683189L;
    private static final String DEFAULT_PASSWORD = "1123";
    private static final String DEFAULT_SIGNATURE = "u2hxY9zQhRF//dRQSfb66Q==";

    private static final DiscoveryServerCredentialsHolder discoveryCredentials =
        new DiscoveryServerCredentialsHolder(DISCOVERY_HOST, DISCOVERY_PORT,
            DISCOVERY_CLIENT_USERNAME, DISCOVERY_CLIENT_PASSWORD);

    public static void main(String[] args) {
        String currencyCode;
        try {
            if (args.length == 4) {
                currencyCode = args[3];
                Terminal terminal = initializeCredentials(args);
                startApplication(terminal, getCurrencyByCode(currencyCode));
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter currency(\"EUR\", \"USD\", \"UAH\", \"DKK\", \"SEK\")");
                currencyCode = scanner.nextLine().toUpperCase();
                Terminal terminal = initializeCredentials(scanner);
                startApplication(terminal, getCurrencyByCode(currencyCode));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static Currency getCurrencyByCode(String currencyCode) {
        Currency currentCurrency = null;
        try {
            currentCurrency = CurrencyFactory.createCurrency(currencyCode);
        } catch (IllegalArgumentException ex) {
            System.err.println("Terminal doesn't support currency " + currencyCode + " | " + ex.getMessage());
            System.exit(1);
        }
        return currentCurrency;
    }

    private static Terminal initializeCredentials(String[] args) {
        Long terminalId = Long.valueOf(args[0]);
        String password = args[1];
        String signature = args[2];
        return new Terminal(terminalId, password, signature);
    }

    private static Terminal initializeCredentials(Scanner scanner) {
        System.out.println("Please enter your credentials or use the default credentials.\n" +
            "Default Terminal ID: " + DEFAULT_TERMINAL_ID + "\n" +
            "Default Password: " + DEFAULT_PASSWORD + "\n" +
            "Default Signature: " + DEFAULT_SIGNATURE + "\n" +
            "You can also enter a blank Terminal ID to use the default data.");

        System.out.print("Enter Terminal ID: ");
        String terminalIdInput = scanner.nextLine();
        Long terminalId;
        String password;
        String signature;

        if (terminalIdInput.isEmpty()) {
            terminalId = DEFAULT_TERMINAL_ID;
            password = DEFAULT_PASSWORD;
            signature = DEFAULT_SIGNATURE;
        } else {
            terminalId = Long.valueOf(terminalIdInput);
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            System.out.print("Enter Signature: ");
            signature = scanner.nextLine();
        }

        return new Terminal(terminalId, password, signature);
    }

    private static void startApplication(Terminal terminal, Currency currentCurrency) {
        try {
            new MainFrame(initContext(terminal, currentCurrency));
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
            | IllegalAccessException exception) {
            System.err.println("Exception: " + exception.getMessage());
            System.exit(2);
        }
    }

    private static ContextHolder initContext(Terminal terminal, Currency currency) {
        ContextHolder contextHolder = new ContextHolder(terminal, currency);
        ConnectionManager connectionManager =
            new ConnectionManager(contextHolder, discoveryCredentials, MAINTENANCE_SERVICE_NAME);
        contextHolder.setConnectionManager(connectionManager);
        return contextHolder;
    }
}