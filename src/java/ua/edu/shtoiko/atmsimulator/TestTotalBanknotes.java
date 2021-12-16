package ua.edu.shtoiko.atmsimulator;

/** failure test */
public abstract class TestTotalBanknotes {
  /**
   * test for the absence of failures in the counting of banknotes
   *
   * @return test result (true or fouls)
   */
  public static boolean testTotalBanknotes() {
    return ATMresource.getTotalQuantityOfBanknotesInATM()
        == ATMresource.getRealTotalQuantityOfBanknotesInATM();
  }
}
