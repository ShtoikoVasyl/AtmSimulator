package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.model.currencyes.Currency;

import java.util.Map;

public interface BanknotesManager {

    int getBanknotesQuantityByName(String name, Currency currency);

    void loadBanknotesByName(String name, int value, Currency currency);

    void takeOutByName(String name, int value, Currency currency);

    Map<String, Integer> getResource(Currency currency);
}
