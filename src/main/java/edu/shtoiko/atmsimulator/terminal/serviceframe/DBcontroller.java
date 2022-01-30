package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

public abstract class DBcontroller {

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
//        return load;
    }

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
