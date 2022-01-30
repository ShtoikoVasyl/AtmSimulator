package edu.shtoiko.atmsimulator.controllers;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

/** currency Ukrainian hryvnia(BanknotesUAH) */
public class BanknotesUAH {

  /** number of banknotes denomination of fifty */
  private int fifty;

  /** number of banknotes denomination of one hundred */
  private int hundred;

  /** number of banknotes denomination of two hundred */
  private int twoHundred;

  /** number of banknotes denomination of five hundred */
  private int fiveHundred;

  /** number of banknotes denomination of one thousand */
  private int thousand;

  /** get totalBanknotes */
  private final int totalBanknotes = fifty + hundred + twoHundred + fiveHundred + thousand;

  /** constructor of BanknotesUAH */
  protected BanknotesUAH() {
    this.fifty = DBsimulator.getFifty();
    this.hundred = DBsimulator.getHundred();
    this.twoHundred = DBsimulator.getTwoHundred();
    this.fiveHundred = DBsimulator.getFiveHundred();
    this.thousand = DBsimulator.getThousand();
  }

  /**
   * to get total quantity of banknotes
   *
   * @return total quantity
   */
  public int getTotalBanknotes() {
    return totalBanknotes;
  }

  /**
   * withdraft from avaliable quantity of banknotes
   *
   * @param withdrawSum sum to withdrafting from request
   * @return array with quantity of banknotes(fifty, hundred, twoHundred, fiveHundred, thousand)
   */
  protected int[] withdraft(int withdrawSum) {
    int[] withdrawBanknotes = new int[5];
    int[] availableBanknotes = new int[] {fifty, hundred, twoHundred, fiveHundred, thousand};
    if (WithdrawCheck.withdrawRequestCheck(withdrawSum, multiplicity())) {
      withdrawBanknotes = Withdrawing.withdraft(availableBanknotes, withdrawSum);
      outputBanknotes(withdrawBanknotes);
      return withdrawBanknotes;
    }
    return withdrawBanknotes;
  }

  /**
   * output banknotes from database(simulator)
   *
   * @param output array with quantity of banknotes(fifty, hundred, twoHundred, fiveHundred,
   *     thousand)
   * @deprecated must be replaced with DBsimulator
   */
  private void outputBanknotes(int[] output) {
    DBsimulator.takeOutFifty(output[0]);
    DBsimulator.takeOutHundred(output[1]);
    DBsimulator.takeOutTwoHundred(output[2]);
    DBsimulator.takeOutFiveHundred(output[3]);
    DBsimulator.takeOutThousand(output[4]);
  }

  /**
   * take multiplicity
   *
   * @return multiplicity of available banknotes
   */
  protected int multiplicity() {
    if (fifty != 0) {
      return 50;
    }
    if (hundred != 0) {
      return 100;
    }
    if (twoHundred != 0) {
      return 200;
    }
    if (fiveHundred != 0) {
      return 500;
    }
    if (thousand != 0) {
      return 1000;
    } else {
      return 0;
    }
  }
}
