package edu.shtoiko.atmsimulator.terminal.mainframetemplate.dataprocessing;

/** Class for the transfer of loaded banknotes */
public class LoadBanknotes {

  /** determines which index of the array corresponds to this denomination */
  public void loadBanknotes(int[] load, int sum, String name) {
    switch (name) {
      case ("fifty"):
        load[0] = sum;
        break;
      case ("hundred"):
        load[1] = sum;
        break;
      case ("twoHundred"):
        load[2] = sum;
        break;
      case ("fiveHundred"):
        load[3] = sum;
        break;
      case ("thousand"):
        load[4] = sum;
        break;
    }
  }
}
