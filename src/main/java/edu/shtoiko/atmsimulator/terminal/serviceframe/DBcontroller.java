package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

/** class to interact with the database  */
public abstract class DBcontroller {

    /** determines which index of the array corresponds to this denomination */
    protected static void loadBanknotes(int[] load, int sum, String name){
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

    /** determines which banknotes you want to get the quantity */
    protected static int GetBanknotesQuantity(String name){
    switch (name) {
      case ("fifty"):
        return DataWarehouseInterface.getFifty();
      case ("hundred"):
        return DataWarehouseInterface.getHundred();
      case ("twoHundred"):
        return DataWarehouseInterface.getTwoHundred();
      case ("fiveHundred"):
        return DataWarehouseInterface.getFiveHundred();
      case ("thousand"):
        return DataWarehouseInterface.getThousand();
    }
        return 0;
    }
}
