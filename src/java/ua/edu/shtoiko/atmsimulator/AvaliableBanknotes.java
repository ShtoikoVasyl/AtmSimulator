package ua.edu.shtoiko.atmsimulator;

/** to get avaliable banknotes in ATM */
public abstract class AvaliableBanknotes {

  /**
   * filling the array with banknotes
   *
   * @return array with banknotes
   */
  public static int[] banknotesInATM() {
    int[] banknotes = new int[5];
    banknotes[0] = ATMresource.getThousand();
    banknotes[1] = ATMresource.getFiveHundred();
    banknotes[2] = ATMresource.getTwoHundred();
    banknotes[3] = ATMresource.getHundred();
    banknotes[4] = ATMresource.getFifty();
    return banknotes;
  }
}
