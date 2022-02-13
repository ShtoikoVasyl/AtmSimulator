package edu.shtoiko.atmsimulator.terminal.mainframetemplate.dataprocessing;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

public class GetResource {

    /**
     * Generate message whith available banknotes
     *
     * @return String message
     * @deprecated must be replaced
     */
    public String getAvailableBanknotes() {
        String message = "";
        if (DataWarehouseInterface.getThousand() != 0) {
            message += " 1000";
        }
        if (DataWarehouseInterface.getFiveHundred() != 0) {
            message += " 500";
        }
        if (DataWarehouseInterface.getTwoHundred() != 0) {
            message += " 200";
        }
        if (DataWarehouseInterface.getHundred() != 0) {
            message += " 100";
        }
        if (DataWarehouseInterface.getFifty() != 0) {
            message += " 50";
        }
        return message;
    }

    /**
     * to get total quantity of banknotes
     *
     * @return total quantity
     * @deprecated must be replaced
     */
    public int getTotalBanknotes() {
        int total =
                DataWarehouseInterface.getFifty()
                        + DataWarehouseInterface.getHundred()
                        + DataWarehouseInterface.getTwoHundred()
                        + DataWarehouseInterface.getFiveHundred()
                        + DataWarehouseInterface.getThousand();
        return total;
    }

    /**
     * write the number of available banknotes in the console
     *
     * @deprecated must be replaced
     */
    public int[] getResource() {
        int[] resource = new int[5];
        resource[0] = DataWarehouseInterface.getFifty();
        resource[1] = DataWarehouseInterface.getHundred();
        resource[2] = DataWarehouseInterface.getTwoHundred();
        resource[3] = DataWarehouseInterface.getFiveHundred();
        resource[4] = DataWarehouseInterface.getThousand();
        return resource;
    }

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


    /** determines which banknotes you want to get the quantity */
    public int GetBanknotesQuantity(String name) {
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
