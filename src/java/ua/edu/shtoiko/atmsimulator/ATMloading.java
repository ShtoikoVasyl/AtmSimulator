package ua.edu.shtoiko.atmsimulator;

/**
 * for loading banknotes in ATM
 */
public abstract class ATMloading{

    /**
     * request to load banknotes in ATM
     * @param sumToLoading array with banknotes to load
     */
    public static void LoadRequest(int[] sumToLoading){
        int totalRequestToLoad = 0;
        for(int i: sumToLoading){
            totalRequestToLoad += i;
        }
        if (ATMresource.getTotalQuantityOfBanknotesInATM() + totalRequestToLoad <= 5000) {
            ATMresource.loadThousand(Math.abs(sumToLoading[0]));
            ATMresource.loadFiveHundred(Math.abs(sumToLoading[1]));
            ATMresource.loadTwoHundred(Math.abs(sumToLoading[2]));
            ATMresource.loadHundred(Math.abs(sumToLoading[3]));
            ATMresource.loadFifty(Math.abs(sumToLoading[4]));
        }
        else {
            System.out.println("Loading not posible, maximum quantity to load " + ( 5000 - ATMresource.getTotalQuantityOfBanknotesInATM() ) + " banknotes!");
    }
    }


}
