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
    int totalQuantityOfBanknotes =
        DataWarehouseInterface.getFifty()
            + DataWarehouseInterface.getHundred()
            + DataWarehouseInterface.getTwoHundred()
            + DataWarehouseInterface.getFiveHundred()
            + DataWarehouseInterface.getThousand();
    if (totalQuantityOfBanknotes + sumToLoad < maxBanknotesInATM) {
      DataWarehouseInterface.loadFifty(banknotesToLoad[0]);
      DataWarehouseInterface.loadHundred(banknotesToLoad[1]);
      DataWarehouseInterface.loadTwoHundred(banknotesToLoad[2]);
      DataWarehouseInterface.loadFiveHundred(banknotesToLoad[3]);
      DataWarehouseInterface.loadThousand(banknotesToLoad[4]);
      return true;
    }
    return false;
  }
}
