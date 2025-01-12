package edu.shtoiko.atmsimulator.terminal.mainframe;

import edu.shtoiko.atmsimulator.client.AbstractTerminalServiceClient;
import edu.shtoiko.atmsimulator.model.Terminal;
import edu.shtoiko.atmsimulator.services.*;
import edu.shtoiko.atmsimulator.model.currencyes.Currency;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseController;
import edu.shtoiko.atmsimulator.datawarehouse.StorageProvider;
import edu.shtoiko.atmsimulator.services.implementation.ConnectionManager;
import edu.shtoiko.atmsimulator.services.implementation.WithdrawProvider;
import edu.shtoiko.atmsimulator.services.implementation.WithdrawServiceImplementation;

public class ContextHolder {
    private final Terminal terminal;
    private ConnectionManager connectionManager;
    private final WithdrawService withdrawServiceImplementation;
    private final StorageProvider dataWarehouseController;
    private final WithdrawCalculator withdrawProvider;
    private final Currency currency;
    private AbstractTerminalServiceClient terminalServiceClient;

    public ContextHolder(Terminal terminal, Currency currency) {
        this.terminal = terminal;
        this.currency = currency;
        dataWarehouseController = new DataWarehouseController(currency);
        withdrawProvider = new WithdrawProvider();
        withdrawServiceImplementation = new WithdrawServiceImplementation(currency, withdrawProvider);
    }

    public WithdrawService getWithdrawService() {
        return withdrawServiceImplementation;
    }

    public AbstractTerminalServiceClient getTerminalServiceClient() {
        return terminalServiceClient;
    }

    public StorageProvider getDataWarehouseController() {
        return dataWarehouseController;
    }

    public WithdrawCalculator getWithdrawProvider() {
        return withdrawProvider;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminalServiceClient(AbstractTerminalServiceClient terminalServiceClient) {
        this.terminalServiceClient = terminalServiceClient;
    }
}
