package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.datawarehouse.StorageProvider;

/**
 * to load banknotes into an ATM
 */
public class AtmLoader {

    /**
     * constructor for AtmLoader
     */
    public AtmLoader() {
    }

    /**
     * for loading database(simulator)
     * 
     * @return load confirmation
     */
    public boolean loadAtm(int value, String name, StorageProvider dataWarehouseController) {
        int maxBanknotesInATM = 5000;
        int totalQuantityOfBanknotes = dataWarehouseController.getTotalQuantity();
        if (totalQuantityOfBanknotes + value < maxBanknotesInATM) {
            dataWarehouseController.loadBanknotesByName(name, value);
            return true;
        }
        return false;
    }
}
