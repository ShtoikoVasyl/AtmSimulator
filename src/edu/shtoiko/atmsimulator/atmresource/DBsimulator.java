package edu.shtoiko.atmsimulator.atmresource;

/**
 * temporary database replacement
 *
 * @deprecated must be replaced by real database
 */
public class DBsimulator {

  /** number of banknotes denomination of fifty */
  private static int fifty = 0;

  /** number of banknotes denomination of one hundred */
  private static int hundred = 0;

  /** number of banknotes denomination of two hundred */
  private static int twoHundred = 0;

  /** number of banknotes denomination of five hundred */
  private static int fiveHundred = 0;

  /** number of banknotes denomination of one thousand */
  private static int thousand = 0;

  /** to get fifty denomination banknotes */
  protected static int getFifty() {
    return fifty;
  }
  /** to load fifty denomination banknotes */
  protected static void loadFifty(int fifty) {
    DBsimulator.fifty += fifty;
  }

  /** to withdraw fifty denomination banknotes */
  protected static void takeOutFifty(int fifty) {
    DBsimulator.fifty -= fifty;
  }

  /** to get one hundred denomination banknotes */
  protected static int getHundred() {
    return hundred;
  }

  /** to load one hundred denomination banknotes */
  protected static void loadHundred(int hundred) {
    DBsimulator.hundred += hundred;
  }

  /** to withdraw one hundred denomination banknotes */
  protected static void takeOutHundred(int hundred) {
    DBsimulator.hundred -= hundred;
  }

  /** to get two hundred denomination banknotes */
  protected static int getTwoHundred() {
    return twoHundred;
  }

  /** to load two hundred denomination banknotes */
  protected static void loadTwoHundred(int twoHundred) {
    DBsimulator.twoHundred += twoHundred;
  }

  /** to withdraw two hundred denomination banknotes */
  protected static void takeOutTwoHundred(int twoHundred) {
    DBsimulator.twoHundred -= twoHundred;
  }

  /** to get five hundred denomination banknotes */
  protected static int getFiveHundred() {
    return fiveHundred;
  }

  /** to load five hundred denomination banknotes */
  protected static void loadFiveHundred(int fiveHundred) {
    DBsimulator.fiveHundred += fiveHundred;
  }

  /** to withdraw five hundred denomination banknotes */
  protected static void takeOutFiveHundred(int fiveHundred) {
    DBsimulator.fiveHundred -= fiveHundred;
  }

  /** to get thousands denomination banknotes */
  protected static int getThousand() {
    return thousand;
  }

  /** to load thousands denomination banknotes */
  protected static void loadThousand(int thousand) {
    DBsimulator.thousand += thousand;
  }

  /** to withdraw thousands denomination banknotes */
  protected static void takeOutThousand(int thousand) {
    DBsimulator.thousand -= thousand;
  }

  /**
   * write the number of available banknotes in the console
   *
   * @deprecated must be replaced
   */
  public static void writeResource() {
    System.out.println("Fifty        " + fifty);
    System.out.println("Hundred      " + hundred);
    System.out.println("Two hundred  " + twoHundred);
    System.out.println("Five hundred " + fiveHundred);
    System.out.println("Thousand     " + thousand);
  }
}
