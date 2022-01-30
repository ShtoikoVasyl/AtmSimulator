package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

public abstract class DBcontroller {

    protected static int[] loadBanknotes(int[] load, int sum, String name){
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
        return load;
    }

    protected static int GetBanknotesQuantity(String name){
    switch (name) {
      case ("fifty"):
        return DBsimulator.getFifty();
      case ("hundred"):
        return DBsimulator.getHundred();
      case ("twoHundred"):
        return DBsimulator.getTwoHundred();
      case ("fiveHundred"):
        return DBsimulator.getFiveHundred();
      case ("thousand"):
        return DBsimulator.getThousand();
    }
        return 0;
    }
}
