package edu.shtoiko.atmsimulator.model.currencyes.examples;

import edu.shtoiko.atmsimulator.model.currencyes.CurrentCurrency;

import java.util.HashMap;
import java.util.Map;

public class USDCurrency extends CurrentCurrency {
    public USDCurrency() {
        super(createBanknotesMap(), "United States Dollar", "USD");
    }

    private static Map<Integer, String> createBanknotesMap() {
        Map<Integer, String> banknotesMap = new HashMap<>();
        banknotesMap.put(1, "one dollar");
        banknotesMap.put(5, "five dollars");
        banknotesMap.put(10, "ten dollars");
        banknotesMap.put(20, "twenty dollars");
        banknotesMap.put(50, "fifty dollars");
        banknotesMap.put(100, "one hundred dollars");
        return banknotesMap;
    }
}
