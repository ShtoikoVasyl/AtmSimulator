package edu.shtoiko.atmsimulator.datawarehouse;

/** to load banknotes into an ATM */
public class ATMloading {

  /** constructor for ATMloading */
  public ATMloading() {}

  /**
   * for loading database(simulator)
   *
   * @param banknotesToLoad request to load
   * @return load confirmation
   * @deprecated must be replaced with DBsimulator
   * @see DBsimulator
   */
  public boolean ATMload(int[] banknotesToLoad) {
    int sumToLoad = 0;
    for (int quantity : banknotesToLoad) sumToLoad += quantity;
    int maxBanknotesInATM = 5000;
    DataWarehouseInterface dataWarehouseController = new DataWarehouseController();
    int totalQuantityOfBanknotes =
        dataWarehouseController.getFifty()
            + dataWarehouseController.getHundred()
            + dataWarehouseController.getTwoHundred()
            + dataWarehouseController.getFiveHundred()
            + dataWarehouseController.getThousand();
    if (totalQuantityOfBanknotes + sumToLoad < maxBanknotesInATM) {
      dataWarehouseController.loadFifty(banknotesToLoad[0]);
      dataWarehouseController.loadHundred(banknotesToLoad[1]);
      dataWarehouseController.loadTwoHundred(banknotesToLoad[2]);
      dataWarehouseController.loadFiveHundred(banknotesToLoad[3]);
      dataWarehouseController.loadThousand(banknotesToLoad[4]);
      return true;
    }
    return false;
  }
}
