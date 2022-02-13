package edu.shtoiko.atmsimulator.controllers;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseController;
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
  protected DataWarehouseInterface dataWarehouseController = new DataWarehouseController();

  /** constructor of BanknotesUAH */
  protected BanknotesUAH() {
    fifty = dataWarehouseController.getFifty();
    hundred = dataWarehouseController.getHundred();
    twoHundred = dataWarehouseController.getTwoHundred();
    fiveHundred = dataWarehouseController.getFiveHundred();
    thousand = dataWarehouseController.getThousand();
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
    dataWarehouseController.takeOutFifty(output[0]);
    dataWarehouseController.takeOutHundred(output[1]);
    dataWarehouseController.takeOutTwoHundred(output[2]);
    dataWarehouseController.takeOutFiveHundred(output[3]);
    dataWarehouseController.takeOutThousand(output[4]);
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
