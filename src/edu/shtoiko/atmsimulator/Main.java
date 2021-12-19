package edu.shtoiko.atmsimulator;

import edu.shtoiko.atmsimulator.atmresource.*;

public class Main {
  public static void main(String[] args) {
    int[] load = {
      2500, 0, 0, 1, 0
    }; // enter several banknotes to download (fifty, hundred, two hundred, five hundred, thousand)
    ATMloading loading = new ATMloading(); // first load
    System.out.println("Load is " + loading.ATMload(load));
    //       loading.ATMload(load);

    int[] load2 = {
      2500, 0, 0, 0, 0
    }; // enter several banknotes to download (fifty, hundred, two hundred, five hundred, thousand)
    ATMloading loading2 = new ATMloading(); // second load
    System.out.println("Load is " + loading2.ATMload(load2));

    System.out.println("Before output :");
    DBsimulator.writeResource();

    Withdrafting vivod = new Withdrafting(2950); // sum to withdraw
    int[] outputBanknotes;
    outputBanknotes = vivod.getOutputingBanknotes();
    for (int banknotes : outputBanknotes) System.out.println(banknotes);

    System.out.println("After output :");
    DBsimulator.writeResource();
  }
}
