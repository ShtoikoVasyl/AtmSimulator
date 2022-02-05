package edu.shtoiko.atmsimulator.datawarehouse;

public class DataWarehouseInterface {

  /** Close constructor */
  private DataWarehouseInterface() {}

  /** to load fifty denomination banknotes */
  protected static void loadFifty(int fifty) {
    DBsimulator.loadFifty(fifty);
  }

  /** to load one hundred denomination banknotes */
  protected static void loadHundred(int hundred) {
    DBsimulator.loadHundred(hundred);
  }

  /** to load two hundred denomination banknotes */
  protected static void loadTwoHundred(int twoHundred) {
    DBsimulator.loadTwoHundred(twoHundred);
  }

  /** to load five hundred denomination banknotes */
  protected static void loadFiveHundred(int fiveHundred) {
    DBsimulator.loadFiveHundred(fiveHundred);
  }

  /** to load thousands denomination banknotes */
  protected static void loadThousand(int thousand) {
    DBsimulator.loadThousand(thousand);
  }

  /** to withdraw fifty denomination banknotes */
  public static void takeOutFifty(int fifty) {
    DBsimulator.takeOutFifty(fifty);
  }

  /** to withdraw one hundred denomination banknotes */
  public static void takeOutHundred(int hundred) {
    DBsimulator.takeOutHundred(hundred);
  }

  /** to withdraw two hundred denomination banknotes */
  public static void takeOutTwoHundred(int twoHundred) {
    DBsimulator.takeOutTwoHundred(twoHundred);
  }

  /** to withdraw five hundred denomination banknotes */
  public static void takeOutFiveHundred(int fiveHundred) {
    DBsimulator.takeOutFiveHundred(fiveHundred);
  }

  /** to withdraw thousands denomination banknotes */
  public static void takeOutThousand(int thousand) {
    DBsimulator.takeOutThousand(thousand);
  }

  /** to get fifty denomination banknotes */
  public static int getFifty() {
    return DBsimulator.getFifty();
  }
  /** to get one hundred denomination banknotes */
  public static int getHundred() {
    return DBsimulator.getHundred();
  }
  /** to get two hundred denomination banknotes */
  public static int getTwoHundred() {
    return DBsimulator.getTwoHundred();
  }
  /** to get five hundred denomination banknotes */
  public static int getFiveHundred() {
    return DBsimulator.getFiveHundred();
  }
  /** to get thousands denomination banknotes */
  public static int getThousand() {
    return DBsimulator.getThousand();
  }

  /**
   * Generate message whith available banknotes
   *
   * @return String message
   * @deprecated must be replaced
   */
  public static String getAvailableBanknotes() {
    return DataWarehouseController.getAvailableBanknotes();
  }

  /**
   * to get total quantity of banknotes
   *
   * @return total quantity
   * @deprecated must be replaced
   */
  public static int getTotalBanknotes() {
    return DataWarehouseController.getTotalBanknotes();
  }

  /**
   * write the number of available banknotes in the console
   *
   * @deprecated must be replaced
   */
  public static int[] getResource() {
    return DataWarehouseController.getResource();
  }
}
