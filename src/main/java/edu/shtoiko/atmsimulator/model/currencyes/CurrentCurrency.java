package edu.shtoiko.atmsimulator.model.currencyes;

import java.util.Map;

public class CurrentCurrency implements Currency {
    private Map<Integer, String> banknotesMap;
    private String fullName;
    private String currencyCode;

    public CurrentCurrency(Map<Integer, String> banknotesMap, String fullName, String shortName) {
        this.banknotesMap = banknotesMap;
        this.fullName = fullName;
        this.currencyCode = shortName;
    }

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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
