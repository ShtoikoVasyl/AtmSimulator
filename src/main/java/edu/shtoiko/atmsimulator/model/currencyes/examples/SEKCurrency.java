package edu.shtoiko.atmsimulator.model.currencyes.examples;

import edu.shtoiko.atmsimulator.model.currencyes.CurrentCurrency;

import java.util.HashMap;
import java.util.Map;

public class SEKCurrency extends CurrentCurrency {

    public SEKCurrency() {
        super(createBanknotesMap(), "Swedish Krona", "SEK");
    }

    private static Map<Integer, String> createBanknotesMap() {
        Map<Integer, String> banknotesMap = new HashMap<>();
        banknotesMap.put(20, "twenty kronor");
        banknotesMap.put(50, "fifty kronor");
        banknotesMap.put(100, "one hundred kronor");
        banknotesMap.put(200, "two hundred kronor");
        banknotesMap.put(500, "five hundred kronor");
        banknotesMap.put(1000, "one thousand kronor");
        return banknotesMap;
    }
}
