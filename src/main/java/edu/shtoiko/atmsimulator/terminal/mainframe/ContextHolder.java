package edu.shtoiko.atmsimulator.terminal.mainframe;

import edu.shtoiko.atmsimulator.controllers.WithdrawCalculator;
import edu.shtoiko.atmsimulator.controllers.WithdrawService;
import edu.shtoiko.atmsimulator.controllers.WithdrawServiceImplementation;
import edu.shtoiko.atmsimulator.controllers.WithdrawProvider;
import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseController;
import edu.shtoiko.atmsimulator.datawarehouse.StorageProvider;

public class ContextHolder {
    private final WithdrawService withdrawServiceImplementation;
    private final StorageProvider dataWarehouseController;

    private final WithdrawCalculator withdrawProvider;
    private final Currency currency;

    public ContextHolder(Currency currency) {
        this.currency = currency;
        dataWarehouseController = new DataWarehouseController(currency);
        withdrawProvider = new WithdrawProvider();
        withdrawServiceImplementation = new WithdrawServiceImplementation(currency, withdrawProvider);
    }

    public WithdrawService getControllerInterface() {
        return withdrawServiceImplementation;
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
}
