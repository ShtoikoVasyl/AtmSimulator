package edu.shtoiko.atmsimulator.controllers;

import java.util.Arrays;

/** Checking withdraw request */
public class WithdrawCheck {

  /** close constructor for WiithdrawCheck */
  private WithdrawCheck() {}

  /**
   * check to corect sum of withdraw
   *
   * @param multiplicity multiplicity of available banknotes
   * @param sumOfWithdraw request sum
   * @return array with banknotes
   */
  protected static boolean withdrawRequestCheck(int sumOfWithdraw, int multiplicity) {
    if (multiplicity == 0) {
      System.out.println("There are no banknotes in the ATM");
      return false;
    }
    if (sumOfWithdraw <= 0) {
      System.out.println("Incorect withdraw sum!");
      return false;
    }
    if (sumOfWithdraw % multiplicity != 0) {
      System.out.println("Withdraw sum is not multiplicity to " + multiplicity + "BanknotesUAH");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Test to corect working
   *
   * @param withdrawBanknotes array with request banknotes
   * @param requestSumOfWithdraw the amount to be withdrawn
   * @return array with zero in all cell if the test fails or with result if the test is passed
   */
  protected static int[] checkingAmount(int[] withdrawBanknotes, int requestSumOfWithdraw) {
    int sumOfWithdrawRequest = 0;
    sumOfWithdrawRequest +=
        withdrawBanknotes[4] * 1000
            + withdrawBanknotes[3] * 500
            + withdrawBanknotes[2] * 200
            + withdrawBanknotes[1] * 100
            + withdrawBanknotes[0] * 50;
    if (sumOfWithdrawRequest != requestSumOfWithdraw) {
      System.out.println(
          "Sorry we can't withdraw this amount, we can give out "
              + Withdrawing.avaliableSum(withdrawBanknotes));
      Arrays.fill(withdrawBanknotes, 0);
      System.out.println("Error, check amount failed!");
      return withdrawBanknotes;
    } else {
      return withdrawBanknotes;
    }
  }
}
