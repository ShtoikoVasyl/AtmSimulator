package edu.shtoiko.atmsimulator.datawarehouse;

public abstract class DataWarehouseInterface {
    /** to withdraw fifty denomination banknotes */
    public static void takeOutFifty(int fifty) {
        DBsimulator.takeOutFifty(fifty);
    }


    /** to withdraw one hundred denomination banknotes */
    public static void takeOutHundred(int hundred) {
        DBsimulator.takeOutHundred(hundred);
    }

    /** to withdraw two hundred denomination banknotes */
    public static void takeOutTwoHundred(int twoHundred) {
        DBsimulator.takeOutTwoHundred(twoHundred);
    }

    /** to withdraw five hundred denomination banknotes */
    public static void takeOutFiveHundred(int fiveHundred) {
        DBsimulator.takeOutFiveHundred(fiveHundred);
    }

    /** to withdraw thousands denomination banknotes */
    public static void takeOutThousand(int thousand) {
        DBsimulator.takeOutThousand(thousand);
    }



    /** to get fifty denomination banknotes */
    public static int getFifty() { return DBsimulator.getFifty();}
    /** to get one hundred denomination banknotes */
    public static int getHundred() {
        return DBsimulator.getHundred();
    }
    /** to get two hundred denomination banknotes */
    public static int getTwoHundred() {
        return DBsimulator.getTwoHundred();
    }
    /** to get five hundred denomination banknotes */
    public static int getFiveHundred() {
        return DBsimulator.getFiveHundred();
    }
    /** to get thousands denomination banknotes */
    public static int getThousand() {
        return DBsimulator.getThousand();
    }



    public static String getAvailableBanknotes(){
        return DataWarehouseController.getAvailableBanknotes();
    }

    public static int getTotalBanknotes() {
        return DataWarehouseController.getTotalBanknotes();
    }

    public static int[] getResource() {
        return  DataWarehouseController.getResource();
    }

}
