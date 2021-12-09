package ua.edu.shtoiko.atmsimulator;

/**
 * Checking withdraw request
 */
public abstract class WithdrawCheck {

    /**
     * check to corect sum of withdraw
     * @param sumOfWithdraw request sum
     * @return array with banknotes
     */
    protected static int[] withdrawRequest(int sumOfWithdraw){
        int[] withdrawBanknotes = new int[5];
        if (sumOfWithdraw <= 0) {
            System.out.println("Incorect withdraw sum!");

        }
        if (sumOfWithdraw % MultiplicityCheck.multiplicity() != 0){
            System.out.println("Withdraw sum in not multiplicity to " + MultiplicityCheck.multiplicity() + "UAH");
        }
        if (sumOfWithdraw > 0 && sumOfWithdraw % MultiplicityCheck.multiplicity() == 0) {
            withdrawBanknotes = ATMresource.withdrafting(sumOfWithdraw);
        }
        return withdrawBanknotes;
    }
}
