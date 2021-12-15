package ua.edu.shtoiko.atmsimulator;

public class Main {
    public static void main(String[] args) {
        int[] toLoad = {19, 9, 8, 0, 0}; //array with banknotes (thousand, fiwe hundred, two hundred, hundred, fifty)
        ATMloading.LoadRequest(toLoad);


        int[] banknotesInATM = AvaliableBanknotes.banknotesInATM();

        System.out.print("Avaliable banknotes before outputing: ");
        for (int banknotes : banknotesInATM) {
            System.out.print("  " + banknotes);
        }
        System.out.println();

  //     int comandArgs = Integer.parseInt(args[0]);



        int[] arrayWithdrawRequest = WithdrawCheck.withdrawRequest(200);
        System.out.print("Outputing banknotes:                  ");
        for (int outputBanknotes : arrayWithdrawRequest) {
            System.out.print("  " + outputBanknotes);
        }
        System.out.println();
        banknotesInATM = AvaliableBanknotes.banknotesInATM();
        System.out.print("Avaliable banknotes after outputing:  ");
        for (int banknotes : banknotesInATM) {
            System.out.print("  " + banknotes);
        }
        System.out.println();

    }

}
