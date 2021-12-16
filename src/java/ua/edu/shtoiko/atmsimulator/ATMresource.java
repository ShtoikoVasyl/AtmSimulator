package ua.edu.shtoiko.atmsimulator;

import java.util.Arrays;

/**
 * Banknote storage class
 *
 * @author Vasyl Shtoiko
 * @version 1.0
 */
public abstract class ATMresource {

  /** number of banknotes denomination of one thousand */
  private static int thousand = 0;

  /** number of banknotes denomination of five hundred */
  private static int fiveHundred = 0;

  /** number of banknotes denomination of two hundred */
  private static int twoHundred = 0;

  /** number of banknotes denomination of one hundred */
  private static int hundred = 0;

  /** number of banknotes denomination of fifty */
  private static int fifty = 0;

  /** sum banknotes in ATM */
  private static int totalQuantityOfBanknotesInATM = 0;

  /** method for geting sum of banknotes in ATM which is summed up when loading banknotes */
  protected static int getTotalQuantityOfBanknotesInATM() {
    return totalQuantityOfBanknotesInATM;
  }

  /** method for update totalQuantityOfBanknotesInATM to real */
  private static void updateTotalQuantityOfBanknotesInATM() {
    totalQuantityOfBanknotesInATM = thousand + fifty + twoHundred + hundred + fifty;
  }

  /** method for geting real sum of banknotes in ATM */
  protected static int getRealTotalQuantityOfBanknotesInATM() {
    int realTotalQuantityOfBanknotesInATM = thousand + fiveHundred + twoHundred + hundred + fifty;
    return realTotalQuantityOfBanknotesInATM;
  }

  /** get the number of banknotes denomination of one thousand */
  protected static int getThousand() {
    return thousand;
  }

  /** load banknotes of denomination of one thousand */
  protected static void loadThousand(int thousand) {
    ATMresource.thousand += thousand;
    totalQuantityOfBanknotesInATM += thousand;
  }

  /** get the number of banknotes denomination of five hundred */
  protected static int getFiveHundred() {
    return fiveHundred;
  }

  /** load banknotes of denomination of five hundred */
  protected static void loadFiveHundred(int fiveHundred) {
    ATMresource.fiveHundred += fiveHundred;
    totalQuantityOfBanknotesInATM += fiveHundred;
  }

  /** get the number of banknotes denomination of two hundred */
  protected static int getTwoHundred() {
    return twoHundred;
  }

  /** load banknotes of denomination of two hundred */
  protected static void loadTwoHundred(int twoHundred) {
    ATMresource.twoHundred += twoHundred;
    totalQuantityOfBanknotesInATM += twoHundred;
  }

  /** get the number of banknotes denomination of one hundred */
  protected static int getHundred() {
    return hundred;
  }

  /** load banknotes of denomination of one hundred */
  protected static void loadHundred(int hundred) {
    ATMresource.hundred += hundred;
    totalQuantityOfBanknotesInATM += hundred;
  }

  /** get the number of banknotes denomination of fifty */
  protected static int getFifty() {
    return fifty;
  }

  /** load banknotes of denomination of fifty */
  protected static void loadFifty(int fifty) {
    ATMresource.fifty += fifty;
    totalQuantityOfBanknotesInATM += fifty;
  }

  /**
   * Test to corect working
   *
   * @param withdrawBanknotes array with request banknotes
   * @param requestSumOfWithdraw the amount to be withdrawn
   * @return array with zero in all cell if the test fails or with result if the test is passed
   */
  static int[] checkingAmount(int[] withdrawBanknotes, int requestSumOfWithdraw) {
    int sumOfWithdrawRequest = 0;
    sumOfWithdrawRequest +=
        withdrawBanknotes[0] * 1000
            + withdrawBanknotes[1] * 500
            + withdrawBanknotes[2] * 200
            + withdrawBanknotes[3] * 100
            + withdrawBanknotes[4] * 50;
    if (sumOfWithdrawRequest != requestSumOfWithdraw) {
      System.out.println(Withdrafting.avaliableSum(withdrawBanknotes));
      Arrays.fill(withdrawBanknotes, 0);
      return withdrawBanknotes;
    } else {
      outputingBanknotes(withdrawBanknotes);
      return withdrawBanknotes;
    }
  }

  /**
   * for withdrafting ( only this method can reduce the number of banknotes in the ATM )
   *
   * @param output array with banknotes to be withdrafting
   */
  private static void outputingBanknotes(int[] output) {
    thousand -= output[0];
    fiveHundred -= output[1];
    twoHundred -= output[2];
    hundred -= output[3];
    fifty -= output[4];
    for (int i : output) {
      totalQuantityOfBanknotesInATM -= i;
    }
  }
}
