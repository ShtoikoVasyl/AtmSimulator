package edu.shtoiko.atmsimulator.model.currencyes.examples;

import edu.shtoiko.atmsimulator.model.currencyes.CurrentCurrency;

import java.util.HashMap;
import java.util.Map;

public class EURCurrency extends CurrentCurrency {
    public EURCurrency() {
        super(createBanknotesMap(), "Danish Krone", "EUR");
    }

    private static Map<Integer, String> createBanknotesMap() {
        Map<Integer, String> banknotesMap = new HashMap<>();
        banknotesMap.put(5, "five euros");
        banknotesMap.put(10, "ten euros");
        banknotesMap.put(20, "twenty euros");
        banknotesMap.put(50, "fifty euros");
        banknotesMap.put(100, "one hundred euros");
        banknotesMap.put(200, "two hundred euros");
        banknotesMap.put(500, "five hundred euros");
        return banknotesMap;
    }
}
