package ua.edu.shtoiko.atmsimulator;


import java.util.Arrays;

/**
 * checking the possibility of output
 */
public class Withdrafting {

    /**
     * withdraws currency from the ATM after check
     *
     * @param requestSumOfWithdraw the amount to be withdrawn
     * @return array with banknotes denomination
     * @see MultiplicityCheck
     */
    protected static int[] withdraft(int requestSumOfWithdraw) {
        int thousand = ATMresource.getThousand();
        int fiveHundred = ATMresource.getFiveHundred();
        int twoHundred = ATMresource.getTwoHundred();
        int hundred = ATMresource.getHundred();
        int fifty = ATMresource.getFifty();
        int sumOfWithdraw = requestSumOfWithdraw;
        int totalQantityOfBanknotesInWithdrafting = 0;
        int requestQantity;
        int[] withdrawBanknotes = new int[5];
        if (thousand != 0) {
            requestQantity = sumOfWithdraw / 1000;
            if (thousand >= requestQantity) {
                withdrawBanknotes[0] = requestQantity;
            } else {
                withdrawBanknotes[0] = thousand;
            }
            sumOfWithdraw -= withdrawBanknotes[0] * 1000;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[0];
        }
        if (fiveHundred != 0) {
            requestQantity = sumOfWithdraw / 500;
            if (fiveHundred >= requestQantity) {
                withdrawBanknotes[1] = requestQantity;
            } else {
                withdrawBanknotes[1] = fiveHundred;
            }
            sumOfWithdraw -= withdrawBanknotes[1] * 500;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[1];
        }
        if (twoHundred != 0) {
            requestQantity = sumOfWithdraw / 200;
            if (twoHundred >= requestQantity) {
                withdrawBanknotes[2] = requestQantity;
            } else {
                withdrawBanknotes[2] = twoHundred;
            }
            sumOfWithdraw -= withdrawBanknotes[2] * 200;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[2];
        }
        if (hundred != 0) {
            requestQantity = sumOfWithdraw / 100;
            if (hundred >= requestQantity) {
                withdrawBanknotes[3] = requestQantity;
            } else {
                withdrawBanknotes[3] = hundred;
            }
            sumOfWithdraw -= withdrawBanknotes[3] * 100;
            totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[3];
        }
        if (fifty != 0) {
            requestQantity = sumOfWithdraw / 50;
            if (fifty >= requestQantity) {
                withdrawBanknotes[4] = requestQantity;
                totalQantityOfBanknotesInWithdrafting += withdrawBanknotes[4];
            } else {
                withdrawBanknotes[4] = fifty;
                System.out.println("There is not enough currency in the ATM, we can issue " + avaliableSum(withdrawBanknotes) + "UAH");

                Arrays.fill(withdrawBanknotes, 0);
                return withdrawBanknotes;
            }
        }
        if (totalQantityOfBanknotesInWithdrafting > 50) {
            System.out.println("Your request could not be fulfilled, enter a smaller amount, we can issue " + avaliableSum(withdrawBanknotes) + "UAH");
        }

        return ATMresource.checkingAmount(withdrawBanknotes, requestSumOfWithdraw);
    }


    /**
     * to withdraw the amount that we can withdraw if the number of banknotes at one time does not allow
     *
     * @param withdrawBanknotes result from withdrafting method
     */
    static int avaliableSum(int[] withdrawBanknotes) {
        int avaliablrSumOfWithdrawRequest = 0;
        int totalQantityOfBanknotesInWithdrafting = 0;
        for (int i = 0; i < withdrawBanknotes[0]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50) {
                avaliablrSumOfWithdrawRequest += 1000;
                totalQantityOfBanknotesInWithdrafting++;
            }
        }
        for (int i = 0; i < withdrawBanknotes[1]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50) {
                avaliablrSumOfWithdrawRequest += 500;
                totalQantityOfBanknotesInWithdrafting++;
            }
        }
        for (int i = 0; i < withdrawBanknotes[2]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50) {
                avaliablrSumOfWithdrawRequest += 200;
                totalQantityOfBanknotesInWithdrafting++;
            }
        }
        for (int i = 0; i < withdrawBanknotes[3]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50) {
                avaliablrSumOfWithdrawRequest += 100;
                totalQantityOfBanknotesInWithdrafting++;
            }
        }
        for (int i = 0; i < withdrawBanknotes[4]; i++) {
            if (totalQantityOfBanknotesInWithdrafting < 50) {
                avaliablrSumOfWithdrawRequest += 50;
                totalQantityOfBanknotesInWithdrafting++;
            }
        }
        Arrays.fill(withdrawBanknotes, 0);
        return avaliablrSumOfWithdrawRequest;
    }


}
