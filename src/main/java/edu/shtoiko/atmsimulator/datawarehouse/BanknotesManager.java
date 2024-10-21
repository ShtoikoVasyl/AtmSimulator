package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;

import java.util.Map;

public interface BanknotesManager {

  public int getBanknotesQuantityByName(String name, Currency currency);

  public void loadBanknotesByName(String name, int value, Currency currency);

  public void takeOutByName(String name, int value, Currency currency);

  public Map<String, Integer> getResource(Currency currency);
}
