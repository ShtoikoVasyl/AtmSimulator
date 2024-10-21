package edu.shtoiko.atmsimulator.controllers.currencyes;

import java.util.HashMap;
import java.util.Map;

public class UAH implements Currency {
    private static Map<Integer, String> banknotesMap;
     private String fullName;
     private String shortName;

    {
        fullName = "Ukrainian hryvna";
        shortName = "UAH";
        banknotesMap = new HashMap<>();
        banknotesMap.put(50, "fifty");
        banknotesMap.put(100, "one hundred");
        banknotesMap.put(200, "two hundred");
        banknotesMap.put(500, "five hundred");
        banknotesMap.put(1000, "thousand");
    }

    public UAH() {}

    public Map<Integer, String> getBanknotesMap() {
        return banknotesMap;
    }

    public int compareBanknotes(String banknote1, String banknote2) {
        int value1 = getKeyByValue(banknotesMap, banknote1);
        int value2 = getKeyByValue(banknotesMap, banknote2);
        return Integer.compare(value1, value2);
    }

    private int getKeyByValue(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void setBanknotesMap(Map<Integer, String> banknotesMap) {
        this.banknotesMap = banknotesMap;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
