package edu.shtoiko.atmsimulator.datawarehouse;

public class DataWarehouseController implements DataWarehouseInterface {

  /**
   * write the number of available banknotes in the console
   *
   * @deprecated must be replaced
   */
  public int[] getResource() {
    int[] resource = new int[5];
    resource[0] = getFifty();
    resource[1] = getHundred();
    resource[2] = getTwoHundred();
    resource[3] = getFiveHundred();
    resource[4] = getThousand();
    return resource;
  }

  /** to load fifty denomination banknotes */
  public void loadFifty(int fifty) {
    DBsimulator.loadFifty(fifty);
  }

  /** to load one hundred denomination banknotes */
  public void loadHundred(int hundred) {
    DBsimulator.loadHundred(hundred);
  }

  /** to load two hundred denomination banknotes */
  public void loadTwoHundred(int twoHundred) {
    DBsimulator.loadTwoHundred(twoHundred);
  }

  /** to load five hundred denomination banknotes */
  public void loadFiveHundred(int fiveHundred) {
    DBsimulator.loadFiveHundred(fiveHundred);
  }

  /** to load thousands denomination banknotes */
  public void loadThousand(int thousand) {
    DBsimulator.loadThousand(thousand);
  }

  /** to withdraw fifty denomination banknotes */
  public void takeOutFifty(int fifty) {
    DBsimulator.takeOutFifty(fifty);
  }

  /** to withdraw one hundred denomination banknotes */
  public void takeOutHundred(int hundred) {
    DBsimulator.takeOutHundred(hundred);
  }

  /** to withdraw two hundred denomination banknotes */
  public void takeOutTwoHundred(int twoHundred) {
    DBsimulator.takeOutTwoHundred(twoHundred);
  }

  /** to withdraw five hundred denomination banknotes */
  public void takeOutFiveHundred(int fiveHundred) {
    DBsimulator.takeOutFiveHundred(fiveHundred);
  }

  /** to withdraw thousands denomination banknotes */
  public void takeOutThousand(int thousand) {
    DBsimulator.takeOutThousand(thousand);
  }

  /** to get fifty denomination banknotes */
  public int getFifty() {
    return DBsimulator.getFifty();
  }
  /** to get one hundred denomination banknotes */
  public int getHundred() {
    return DBsimulator.getHundred();
  }
  /** to get two hundred denomination banknotes */
  public int getTwoHundred() {
    return DBsimulator.getTwoHundred();
  }
  /** to get five hundred denomination banknotes */
  public int getFiveHundred() {
    return DBsimulator.getFiveHundred();
  }
  /** to get thousands denomination banknotes */
  public int getThousand() {
    return DBsimulator.getThousand();
  }
}
