package ua.edu.shtoiko.atmsimulator;

public class Main {
    public static void main(String[] args){
        int[] toLoad = {0,1,1,1,100}; //array with banknotes (thousand, fiwe hundred, two hundred, hundred, fifty)
        ATMloading.LoadRequest(toLoad);
        System.out.println("resource " + ATMresource.getTotalQuantityOfBanknotesInATM());

        System.out.println("50UAH " + ATMresource.getFifty());

    int[] arrayWithdrawRequest = WithdrawCheck.withdrawRequest(5800);

    for(int s : arrayWithdrawRequest){
        System.out.println(s);
    }
        System.out.println("50UAH " + ATMresource.getFifty());
        System.out.println("resourse " + ATMresource.getTotalQuantityOfBanknotesInATM());
    }
}
