package edu.shtoiko.atmsimulator.model.currencyes.examples;

import edu.shtoiko.atmsimulator.model.currencyes.CurrentCurrency;

import java.util.HashMap;
import java.util.Map;

public class DKKCurrency extends CurrentCurrency {

    public DKKCurrency() {
        super(createBanknotesMap(), "United States Dollar", "DKK");
    }

    private static Map<Integer, String> createBanknotesMap() {
        Map<Integer, String> banknotesMap = new HashMap<>();
        banknotesMap.put(50, "fifty kroner");
        banknotesMap.put(100, "one hundred kroner");
        banknotesMap.put(200, "two hundred kroner");
        banknotesMap.put(500, "five hundred kroner");
        banknotesMap.put(1000, "one thousand kroner");
        return banknotesMap;
    }
}
