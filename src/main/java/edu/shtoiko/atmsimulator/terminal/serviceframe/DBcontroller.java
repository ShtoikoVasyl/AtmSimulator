package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

public abstract class GetBanknotes {

    public static int GetBanknotesQuantity(String name){
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
