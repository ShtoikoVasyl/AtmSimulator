package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;

import java.util.HashMap;
import java.util.Map;

public class SimpleBanknotesManager implements BanknotesManager{

    Map<String, Integer> availableBanknotesMap;

    {
        availableBanknotesMap = new HashMap<>();
        availableBanknotesMap.put("thousand", 10);
        availableBanknotesMap.put("five hundred", 20);
        availableBanknotesMap.put("two hundred", 30);
        availableBanknotesMap.put("one hundred", 40);
        availableBanknotesMap.put("fifty", 50);
    }

    public int getBanknotesQuantityByName(String name, Currency currency){
        return getQuantityFromAvailableMap(name);
    }

    public void loadBanknotesByName(String name, int value, Currency currency){
        availableBanknotesMap.put(name, getQuantityFromAvailableMap(name) + value);
    }

    public void takeOutByName(String name, int value, Currency currency){
        availableBanknotesMap.put(name, getQuantityFromAvailableMap(name) - value);
    }

    private int getQuantityFromAvailableMap(String name){
        int result;
        try { result = availableBanknotesMap.get(name);
        } catch (NullPointerException e){
            return 0;
        }
        return result;
    }

    public Map<String, Integer> getResource(Currency currency) {
        return availableBanknotesMap;
    }
}
