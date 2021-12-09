package ua.edu.shtoiko.atmsimulator;

/**Banknote storage class
 * @author Vasyl Shtoiko
 * @version 1.0
 */
public abstract class ATMresource {

    /** number of banknotes denomination of one thousand */
    private static int thousand = 0;

    /** number of banknotes denomination of five hundred */
    private static int fiveHundred = 0;

    /** number of banknotes denomination of two hundred */
    private static int twoHundred = 0;

    /** number of banknotes denomination of one hundred */
    private static int hundred = 0;

    /** number of banknotes denomination of fifty */
    private static int fifty = 0;

    /** sum banknotes in ATM */
    private static  int totalQuantityOfBanknotesInATM = 0;

    /** method for geting sum of banknotes in ATM which is summed up when loading banknotes*/
    protected static int getTotalQuantityOfBanknotesInATM() {
        return totalQuantityOfBanknotesInATM;
    }

    /**  method for update totalQuantityOfBanknotesInATM to real */
    private static void updateTotalQuantityOfBanknotesInATM(){
        totalQuantityOfBanknotesInATM = thousand + fifty + twoHundred + hundred + fifty;
    }

    /** method for geting real sum of banknotes in ATM */
    private static int getRealTotalQuantityOfBanknotesInATM(){
        totalQuantityOfBanknotesInATM = thousand + fifty + twoHundred + hundred + fifty;
        return totalQuantityOfBanknotesInATM;
    }

    /** get the number of banknotes denomination of one thousand */
    protected static int getThousand() {
        return thousand;
    }

    /** load banknotes of denomination of one thousand */
    protected static void loadThousand(int thousand) {
        ATMresource.thousand += thousand;
        totalQuantityOfBanknotesInATM += thousand;
    }

    /** get the number of banknotes denomination of five hundred */
    protected static int getFiveHundred() {
        return fiveHundred;
    }

    /** load banknotes of denomination of five hundred */
    protected static void loadFiveHundred(int fiveHundred) {
        ATMresource.fiveHundred += fiveHundred;
        totalQuantityOfBanknotesInATM += fiveHundred;
    }

    /** get the number of banknotes denomination of two hundred */
    protected static int getTwoHundred() {
        return twoHundred;
    }

    /** load banknotes of denomination of two hundred */
    protected static void loadTwoHundred(int twoHundred) {
        ATMresource.twoHundred += twoHundred;
        totalQuantityOfBanknotesInATM += twoHundred;
    }

    /** get the number of banknotes denomination of one hundred */
    protected static int getHundred() {
        return hundred;
    }

    /** load banknotes of denomination of one hundred */
    protected static void loadHundred(int hundred) {
        ATMresource.hundred += hundred;
        totalQuantityOfBanknotesInATM += hundred;
    }

    /** get the number of banknotes denomination of fifty */
    protected static int getFifty() {
        return fifty;
    }

    /** load banknotes of denomination of fifty */
    protected static void loadFifty(int fifty) {
        ATMresource.fifty += fifty;
        totalQuantityOfBanknotesInATM += fifty;
    }

    /**
     * withdraws currency from the ATM after check
     * @see MultiplicityCheck
     * @param requestSumOfWithdraw the amount to be withdrawn
     * @return array with banknotes denomination
     * @deprecated must be rewrite
     */
    protected static int[] withdrafting(int requestSumOfWithdraw){
        int sumOfWithdraw = requestSumOfWithdraw;
        int totalQantityOfBanknotesInWithdrafting = 0;
        int requestQantity;
        int[] withdrawBanknotes = new int[5];
        if (thousand != 0){
            requestQantity = sumOfWithdraw / 1000;
            if(thousand >= requestQantity){
                withdrawBanknotes[0] = requestQantity;
            }
            else {
                withdrawBanknotes[0] = thousand;
            }
            sumOfWithdraw -= withdrawBanknotes[0] * 1000;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[0];
        }
        if (fiveHundred != 0){
            requestQantity = sumOfWithdraw / 500;
            if(fiveHundred >= requestQantity){
                withdrawBanknotes[1] = requestQantity;
            }
            else {
                withdrawBanknotes[1] = fiveHundred;
            }
            sumOfWithdraw -= withdrawBanknotes[1] * 500;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[1];
        }
        if (twoHundred != 0){
            requestQantity = sumOfWithdraw / 200;
            if(twoHundred >= requestQantity){
                withdrawBanknotes[2] = requestQantity;
            }
            else {
                withdrawBanknotes[2] = twoHundred;
            }
            sumOfWithdraw -= withdrawBanknotes[2] * 200;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[2];
        }
        if (hundred != 0){
            requestQantity = sumOfWithdraw / 100;
            if(hundred >= requestQantity){
                withdrawBanknotes[3] = requestQantity;
            }
            else {
                withdrawBanknotes[3] = hundred;
            }
            sumOfWithdraw -= withdrawBanknotes[3] * 100;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[3];
        }
        if (fifty != 0){
            requestQantity = sumOfWithdraw / 50;
            if(fifty >= requestQantity) {
                withdrawBanknotes[4] = requestQantity;
                totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[4];
            }
            else {
                int avaliableSum = 0;
                avaliableSum += withdrawBanknotes[0] * 1000 + withdrawBanknotes[1] * 500 + withdrawBanknotes[2] * 200 + withdrawBanknotes[3] * 100 + fifty * 50;
                for (int i = 0; i < withdrawBanknotes.length; i++) {

                    withdrawBanknotes[i] = 0;
                }
                System.out.println("There is not enough currency in the ATM, we can issue " + avaliableSum + "UAH");
                return withdrawBanknotes;
            }
        }
         if (totalQantityOfBanknotesInWithdrafting > 50){
            avaliableSum(withdrawBanknotes);
        }

        return checkingAmount(withdrawBanknotes, requestSumOfWithdraw);
    }

    /**
     * Test to corect worcing
     * @param withdrawBanknotes array with request banknotes
     * @param requestSumOfWithdraw the amount to be withdrawn
     * @return array with zero in all cell if the test fails or with result if the test is passed
     * @deprecated must be rewrite
     */
    private static int[] checkingAmount(int[] withdrawBanknotes, int requestSumOfWithdraw) {
        int sumOfWithdrawRequest = 0;
        sumOfWithdrawRequest += withdrawBanknotes[0] * 1000 + withdrawBanknotes[1] * 500 + withdrawBanknotes[2] * 200 + withdrawBanknotes[3] * 100 + withdrawBanknotes[4] * 50;
        if (sumOfWithdrawRequest != requestSumOfWithdraw) {
            avaliableSum(withdrawBanknotes);
            for (int i = 0; i < withdrawBanknotes.length; i++) {
                withdrawBanknotes[i] = 0;
            }
            return withdrawBanknotes;
        }
        else {
            outputingBanknotes(withdrawBanknotes);
            return withdrawBanknotes;
        }
    }

    /**
     * for withdrafting ( only this method can reduce the number of banknotes in the ATM )
     * @param output array with banknotes to be withdrafting
     */
    private static void outputingBanknotes(int[] output){
        thousand -= output[0];
        fiveHundred -= output[1];
        twoHundred -= output[2];
        hundred -= output[3];
        fifty -= output[4];
        for(int i: output) {
            totalQuantityOfBanknotesInATM -= i;
        }
    }

    /**
     * to withdraw the amount that we can withdraw if the number of banknotes at one time does not allow
     * @param withdrawBanknotes result from withdrafting method
     * @deprecated must be rewrite
     */
    private static void avaliableSum(int[] withdrawBanknotes){
       int avaliablrSumOfWithdrawRequest = 0;
       int totalQantityOfBanknotesInWithdrafting = 0;
       for (int i = 0; i < withdrawBanknotes[0]; i++) {
           if (totalQantityOfBanknotesInWithdrafting < 50){
                avaliablrSumOfWithdrawRequest += 1000;
                totalQantityOfBanknotesInWithdrafting++;
            }
       }
       for (int i = 0; i < withdrawBanknotes[1]; i++) {
           if (totalQantityOfBanknotesInWithdrafting < 50){
               avaliablrSumOfWithdrawRequest += 500;
               totalQantityOfBanknotesInWithdrafting++;
           }
       }
       for (int i = 0; i < withdrawBanknotes[2]; i++) {
           if (totalQantityOfBanknotesInWithdrafting < 50){
               avaliablrSumOfWithdrawRequest += 200;
               totalQantityOfBanknotesInWithdrafting++;
           }
       }
       for (int i = 0; i < withdrawBanknotes[3]; i++) {
             if (totalQantityOfBanknotesInWithdrafting < 50){
               avaliablrSumOfWithdrawRequest += 100;
               totalQantityOfBanknotesInWithdrafting++;
             }
       }
       for (int i = 0; i < withdrawBanknotes[4]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50){
               avaliablrSumOfWithdrawRequest += 50;
               totalQantityOfBanknotesInWithdrafting++;
              }
       }
       for (int i = 0; i < withdrawBanknotes.length; i++) {
             withdrawBanknotes[i] = 0;
             }
          System.out.println("Your request could not be fulfilled, enter a smaller amount, we can issue " + avaliablrSumOfWithdrawRequest + "UAH");
    }
}





