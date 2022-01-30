package edu.shtoiko.atmsimulator.datawarehouse;

public abstract class DataWarehouseController {
    protected static String getAvailableBanknotes() {
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
     */
    protected static int getTotalBanknotes() {
        int total = DataWarehouseInterface.getFifty() + DataWarehouseInterface.getHundred() + DataWarehouseInterface.getTwoHundred() + DataWarehouseInterface.getFiveHundred() + DataWarehouseInterface.getThousand();
        return total;
    }

    /**
     * write the number of available banknotes in the console
     *
     * @deprecated must be replaced
     */
    protected static int[] getResource() {
        int[] resource = new int[5];
        resource[0] = DataWarehouseInterface.getFifty();
        resource[1] = DataWarehouseInterface.getHundred();
        resource[2] = DataWarehouseInterface.getTwoHundred();
        resource[3] = DataWarehouseInterface.getFiveHundred();
        resource[4] = DataWarehouseInterface.getThousand();
        return resource;
    }
}
