package edu.shtoiko.atmsimulator.datawarehouse;

import java.util.Map;

public interface StorageProvider {

    Map<Integer, String> getAvailableBanknotes();

    Map<Integer, String> getCurrencyMap();

    int getTotalQuantity();

    Map<String, Integer> getResourcesByValueNames();

    Map<Integer, Integer> getResourcesByValue();

    void loadBanknotesByName(String name, int value);

    void takeOutByName(String name, Integer value);
}
