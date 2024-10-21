package edu.shtoiko.atmsimulator.controllers.currencyes;

import java.util.Map;

public interface Currency {

    public int compareBanknotes(String banknote1, String banknote2);

    public Map<Integer, String> getBanknotesMap();
}
