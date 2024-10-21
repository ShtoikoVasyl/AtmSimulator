package edu.shtoiko.atmsimulator.controllers;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;
import java.util.Map;

public class WithdrawServiceImplementation implements WithdrawService{
  Currency currency;

  private WithdrawCalculator provider;
  public WithdrawServiceImplementation(Currency currency, WithdrawCalculator withdrawProvider) {
    provider = withdrawProvider;
    this.currency = currency;
  }

  public Map<String, Integer> withdrawRequest(Map<String, Integer> availableBanknotes, int withdrawRequestSum) {
    try {
      return provider.calculate(currency.getBanknotesMap(), availableBanknotes, withdrawRequestSum);
    } catch (WithdrawException e) {
      throw new RuntimeException(e);
    }
  }
}
