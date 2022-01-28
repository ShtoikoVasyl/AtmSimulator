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
        DBsimulator.getFifty()
            + DBsimulator.getHundred()
            + DBsimulator.getTwoHundred()
            + DBsimulator.getFiveHundred()
            + DBsimulator.getThousand();
    if (totalQuantityOfBanknotes + sumToLoad < maxBanknotesInATM) {
      DBsimulator.loadFifty(banknotesToLoad[0]);
      DBsimulator.loadHundred(banknotesToLoad[1]);
      DBsimulator.loadTwoHundred(banknotesToLoad[2]);
      DBsimulator.loadFiveHundred(banknotesToLoad[3]);
      DBsimulator.loadThousand(banknotesToLoad[4]);
      return true;
    }
    System.out.println(
        "Loading not possible, maximum quantity to load "
            + (maxBanknotesInATM - totalQuantityOfBanknotes)
            + " banknotes!");
    return false;
  }
}
