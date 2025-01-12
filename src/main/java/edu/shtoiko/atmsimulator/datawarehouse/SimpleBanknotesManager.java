package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.model.currencyes.Currency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimpleBanknotesManager implements BanknotesManager {

    private Map<String, Integer> availableBanknotesMap;

    public SimpleBanknotesManager(Currency currency) {
        initAvailableBanknotesMap(currency);
    }

    private void initAvailableBanknotesMap(Currency currency) {
        availableBanknotesMap = convertMap(currency.getBanknotesMap());

    }

    public static Map<String, Integer> convertMap(Map<Integer, String> originalMap) {
        Map<String, Integer> newMap = new HashMap<>();
        Random random = new Random();

        for (String value : originalMap.values()) {
            int randomValue = 10 * (random.nextInt(6) + 2);
            newMap.put(value, randomValue);
        }
        return newMap;
    }

    public int getBanknotesQuantityByName(String name, Currency currency) {
        return getQuantityFromAvailableMap(name);
    }

    public void loadBanknotesByName(String name, int value, Currency currency) {
        availableBanknotesMap.put(name, getQuantityFromAvailableMap(name) + value);
    }

    public void takeOutByName(String name, int value, Currency currency) {
        availableBanknotesMap.put(name, getQuantityFromAvailableMap(name) - value);
    }

    private int getQuantityFromAvailableMap(String name) {
        int result;
        try {
            result = availableBanknotesMap.get(name);
        } catch (NullPointerException e) {
            return 0;
        }
        return result;
    }

    public Map<String, Integer> getResource(Currency currency) {
        return availableBanknotesMap;
    }
}
