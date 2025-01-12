package edu.shtoiko.atmsimulator.model.currencyes.examples;

import edu.shtoiko.atmsimulator.model.currencyes.CurrentCurrency;

import java.util.HashMap;
import java.util.Map;

public class UAHCurrency extends CurrentCurrency {
    public UAHCurrency() {
        super(createBanknotesMap(), "Ukrainian hryvna", "UAH");
    }

    private static Map<Integer, String> createBanknotesMap() {
        Map<Integer, String> banknotesMap = new HashMap<>();
        banknotesMap.put(50, "fifty");
        banknotesMap.put(100, "one hundred");
        banknotesMap.put(200, "two hundred");
        banknotesMap.put(500, "five hundred");
        banknotesMap.put(1000, "thousand");
        return banknotesMap;
    }
}
