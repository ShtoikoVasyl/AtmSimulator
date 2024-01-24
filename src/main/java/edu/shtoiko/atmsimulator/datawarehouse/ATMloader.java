package edu.shtoiko.atmsimulator.datawarehouse;

/** to load banknotes into an ATM
 * @deprecated */
public class ATMloader {

  /** constructor for ATMloader
   * @deprecated
   */
  public ATMloader() {}

  /**
   * for loading database(simulator)
   * @return load confirmation
   * @deprecated must be replaced with DBsimulator
   * @see BanknotesManager
   */
  public boolean ATMload(int value, String name, StorageProvider dataWarehouseController) {
    int maxBanknotesInATM = 5000;
    int totalQuantityOfBanknotes = dataWarehouseController.getTotalQuantity();
    if (totalQuantityOfBanknotes + value < maxBanknotesInATM) {
      dataWarehouseController.loadBanknotesByName(name, value);
      return true;
    }
    return false;
  }
}
