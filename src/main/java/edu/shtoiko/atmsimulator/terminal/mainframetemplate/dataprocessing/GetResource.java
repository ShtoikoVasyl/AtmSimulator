package edu.shtoiko.atmsimulator.terminal.mainframetemplate.dataprocessing;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseController;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

/** class that processes the data obtained from data controller */
public class GetResource {
  protected DataWarehouseInterface dataWarehouseController = new DataWarehouseController();

  /**
   * Generate message whith available banknotes
   *
   * @return String message
   */
  public String getAvailableBanknotes() {
    String message = "";
    if (dataWarehouseController.getThousand() != 0) {
      message += " 1000";
    }
    if (dataWarehouseController.getFiveHundred() != 0) {
      message += " 500";
    }
    if (dataWarehouseController.getTwoHundred() != 0) {
      message += " 200";
    }
    if (dataWarehouseController.getHundred() != 0) {
      message += " 100";
    }
    if (dataWarehouseController.getFifty() != 0) {
      message += " 50";
    }
    return message;
  }

  /**
   * to get total quantity of banknotes
   *
   * @return total quantity
   */
  public int getTotalBanknotes() {
    int total = 0;
    for (int banknotesQuantity : getResource()) total += banknotesQuantity;
    return total;
  }

  /** write the number of available banknotes in the console */
  public int[] getResource() {
    int[] resource = new int[5];
    resource[0] = dataWarehouseController.getFifty();
    resource[1] = dataWarehouseController.getHundred();
    resource[2] = dataWarehouseController.getTwoHundred();
    resource[3] = dataWarehouseController.getFiveHundred();
    resource[4] = dataWarehouseController.getThousand();
    return resource;
  }

  /** determines which banknotes you want to get the quantity */
  public int GetBanknotesQuantity(String name) {
    switch (name) {
      case ("fifty"):
        return dataWarehouseController.getFifty();
      case ("hundred"):
        return dataWarehouseController.getHundred();
      case ("twoHundred"):
        return dataWarehouseController.getTwoHundred();
      case ("fiveHundred"):
        return dataWarehouseController.getFiveHundred();
      case ("thousand"):
        return dataWarehouseController.getThousand();
    }
    return 0;
  }
}
