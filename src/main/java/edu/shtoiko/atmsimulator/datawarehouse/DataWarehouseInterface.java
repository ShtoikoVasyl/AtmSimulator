package edu.shtoiko.atmsimulator.datawarehouse;

public interface DataWarehouseInterface {

  /** to load fifty denomination banknotes */
  public void loadFifty(int fifty);

  /** to load one hundred denomination banknotes */
  public void loadHundred(int hundred);

  /** to load two hundred denomination banknotes */
  public void loadTwoHundred(int twoHundred);

  /** to load five hundred denomination banknotes */
  public void loadFiveHundred(int fiveHundred);

  /** to load thousands denomination banknotes */
  public void loadThousand(int thousand);

  /** to withdraw fifty denomination banknotes */
  public void takeOutFifty(int fifty);

  /** to withdraw one hundred denomination banknotes */
  public void takeOutHundred(int hundred);

  /** to withdraw two hundred denomination banknotes */
  public void takeOutTwoHundred(int twoHundred);

  /** to withdraw five hundred denomination banknotes */
  public void takeOutFiveHundred(int fiveHundred);

  /** to withdraw thousands denomination banknotes */
  public void takeOutThousand(int thousand);

  /** to get fifty denomination banknotes */
  public int getFifty();

  /** to get one hundred denomination banknotes */
  public int getHundred();

  /** to get two hundred denomination banknotes */
  public int getTwoHundred();

  /** to get five hundred denomination banknotes */
  public int getFiveHundred();

  /** to get thousands denomination banknotes */
  public int getThousand();

  /**
   * write the number of available banknotes in the console
   *
   * @deprecated must be replaced
   */
  public int[] getResource();
}
