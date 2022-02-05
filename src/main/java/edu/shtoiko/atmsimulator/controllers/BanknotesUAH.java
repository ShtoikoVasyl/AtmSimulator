package edu.shtoiko.atmsimulator.controllers;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

/** currency Ukrainian hryvnia(BanknotesUAH) */
public class BanknotesUAH {

  /** number of banknotes denomination of fifty */
  private final int fifty;

  /** number of banknotes denomination of one hundred */
  private final int hundred;

  /** number of banknotes denomination of two hundred */
  private final int twoHundred;

  /** number of banknotes denomination of five hundred */
  private final int fiveHundred;

  /** number of banknotes denomination of one thousand */
  private final int thousand;

  /** constructor of BanknotesUAH */
  protected BanknotesUAH() {
    fifty = DataWarehouseInterface.getFifty();
    hundred = DataWarehouseInterface.getHundred();
    twoHundred = DataWarehouseInterface.getTwoHundred();
    fiveHundred = DataWarehouseInterface.getFiveHundred();
    thousand = DataWarehouseInterface.getThousand();
  }

  /**
   * withdraft from avaliable quantity of banknotes
   *
   * @param withdrawSum sum to withdrafting from request
   * @return array with quantity of banknotes(fifty, hundred, twoHundred, fiveHundred, thousand)
   */
  protected int[] withdraw(int withdrawSum) {
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
    DataWarehouseInterface.takeOutFifty(output[0]);
    DataWarehouseInterface.takeOutHundred(output[1]);
    DataWarehouseInterface.takeOutTwoHundred(output[2]);
    DataWarehouseInterface.takeOutFiveHundred(output[3]);
    DataWarehouseInterface.takeOutThousand(output[4]);
  }

  /**
   * take multiplicity
   *
   * @return multiplicity of available banknotes
   */
  protected int multiplicity() {
    if (0 != fifty) {
      return 50;
    }
    if (0 != hundred) {
      return 100;
    }
    if (0 != twoHundred) {
      return 200;
    }
    if (0 != fiveHundred) {
      return 500;
    }
    if (0 != thousand) {
      return 1000;
    } else {
      return 0;
    }
  }
}
