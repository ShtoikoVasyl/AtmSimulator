package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;

import java.util.Map;

public interface StorageProvider {

  public Map<Integer, String> getAvailableBanknotes();

  Map<Integer, String> getCurrencyMap();

  public int getTotalQuantity();

  public Map<String, Integer> getResources();

  public void loadBanknotesByName(String name, int value);

  void takeOutByName(String name, Integer value);
}
