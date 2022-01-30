package edu.shtoiko.atmsimulator.controllers;

import java.util.Arrays;

/** checking the possibility of output */
public class Withdrafting {

  /** request sum to withdraw */
  private int withdraftRequestSum;
  /** an array with the number of banknotes to be issued */
  private int[] outputingBanknotes;

  /**
   * to receive the issued banknotes
   *
   * @return @return array with quantity of banknotes(fifty, hundred, twoHundred, fiveHundred, thousand)
   */
  public int[] getOutputingBanknotes() {
    return outputingBanknotes;
  }

  /**
   * create withdraw request
   *
   * @param withdraftRequestSum request sum to withdraw
   */
  public Withdrafting(int withdraftRequestSum) {
    this.withdraftRequestSum = withdraftRequestSum;
    outputingBanknotes = withdraftRequest(this.withdraftRequestSum);
  }

  /**
   * to withdrawting banknotes from ATM
   *
   * @param withdraftRequestSum request sum to withdraw
   * @return array with quantity of banknotes(fifty, hundred, twoHundred, fiveHundred, thousand)
   */
  private int[] withdraftRequest(int withdraftRequestSum) {
    int[] withdrawBanknotes;
    BanknotesUAH withdraftBanknotesUAH = new BanknotesUAH();
    withdrawBanknotes = withdraftBanknotesUAH.withdraft(withdraftRequestSum);
    return withdrawBanknotes;
  }

  /**
   * withdraws currency from the ATM after check
   *
   * @param availableBanknotes available banknotes in ATM
   * @param requestSumOfWithdraw the amount to be withdrawn
   * @return array with banknotes denomination
   */
  protected static int[] withdraft(int[] availableBanknotes, int requestSumOfWithdraw) {
    int fifty = availableBanknotes[0];
    int hundred = availableBanknotes[1];
    int twoHundred = availableBanknotes[2];
    int fiveHundred = availableBanknotes[3];
    int thousand = availableBanknotes[4];
    int sumOfWithdraw = requestSumOfWithdraw;
    int totalQantityOfBanknotesInWithdrafting = 0;
    int requestQantity;
    int[] withdrawBanknotes = new int[5];
    if (thousand != 0) {
      requestQantity = sumOfWithdraw / 1000;
      if (thousand >= requestQantity) {
        withdrawBanknotes[4] = requestQantity;
      } else {
        withdrawBanknotes[4] = thousand;
      }
      sumOfWithdraw -= withdrawBanknotes[4] * 1000;
      totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[4];
    }
    if (fiveHundred != 0) {
      requestQantity = sumOfWithdraw / 500;
      if (fiveHundred >= requestQantity) {
        withdrawBanknotes[3] = requestQantity;
      } else {
        withdrawBanknotes[3] = fiveHundred;
      }
      sumOfWithdraw -= withdrawBanknotes[3] * 500;
      totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[3];
    }
    if (twoHundred != 0) {
      requestQantity = sumOfWithdraw / 200;
      if (twoHundred >= requestQantity) {
        withdrawBanknotes[2] = requestQantity;
      } else {
        withdrawBanknotes[2] = twoHundred;
      }
      sumOfWithdraw -= withdrawBanknotes[2] * 200;
      totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[2];
    }
    if (hundred != 0) {
      requestQantity = sumOfWithdraw / 100;
      if (hundred >= requestQantity) {
        withdrawBanknotes[1] = requestQantity;
      } else {
        withdrawBanknotes[1] = hundred;
      }
      sumOfWithdraw -= withdrawBanknotes[1] * 100;
      totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[1];
    }
    if (fifty != 0) {
      requestQantity = sumOfWithdraw / 50;
      if (fifty >= requestQantity) {
        withdrawBanknotes[0] = requestQantity;
        totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[0];
      } else {
        withdrawBanknotes[0] = fifty;
        System.out.println(
            "There is not enough currency in the ATM, we can issue "
                + avaliableSum(withdrawBanknotes)
                + "BanknotesUAH");
        Arrays.fill(withdrawBanknotes, 0);
        return withdrawBanknotes;
      }
    }
    if (totalQantityOfBanknotesInWithdrafting > 50) {
      System.out.println(
          "Your request could not be fulfilled, enter a smaller amount, we can issue "
              + avaliableSum(withdrawBanknotes)
              + "BanknotesUAH");
    }
    return WithdrawCheck.checkingAmount(withdrawBanknotes, requestSumOfWithdraw);
  }

  /**
   * to withdraw the amount that we can withdraw if the number of banknotes at one time does not
   * allow
   *
   * @param withdrawBanknotes result from withdrafting method
   */
  protected static int avaliableSum(int[] withdrawBanknotes) {
    int avaliablrSumOfWithdrawRequest = 0;
    int totalQantityOfBanknotesInWithdrafting = 0;
    for (int i = 0; i < withdrawBanknotes[4]; i++) {
      if (totalQantityOfBanknotesInWithdrafting < 50) {
        avaliablrSumOfWithdrawRequest += 1000;
        totalQantityOfBanknotesInWithdrafting++;
      }
    }
    for (int i = 0; i < withdrawBanknotes[3]; i++) {
      if (totalQantityOfBanknotesInWithdrafting < 50) {
        avaliablrSumOfWithdrawRequest += 500;
        totalQantityOfBanknotesInWithdrafting++;
      }
    }
    for (int i = 0; i < withdrawBanknotes[2]; i++) {
      if (totalQantityOfBanknotesInWithdrafting < 50) {
        avaliablrSumOfWithdrawRequest += 200;
        totalQantityOfBanknotesInWithdrafting++;
      }
    }
    for (int i = 0; i < withdrawBanknotes[1]; i++) {
      if (totalQantityOfBanknotesInWithdrafting < 50) {
        avaliablrSumOfWithdrawRequest += 100;
        totalQantityOfBanknotesInWithdrafting++;
      }
    }
    for (int i = 0; i < withdrawBanknotes[0]; i++) {
      if (totalQantityOfBanknotesInWithdrafting < 50) {
        avaliablrSumOfWithdrawRequest += 50;
        totalQantityOfBanknotesInWithdrafting++;
      }
    }
    Arrays.fill(withdrawBanknotes, 0);
    return avaliablrSumOfWithdrawRequest;
  }
}
