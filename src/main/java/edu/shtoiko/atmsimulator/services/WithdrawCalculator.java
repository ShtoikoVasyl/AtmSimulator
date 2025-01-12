package edu.shtoiko.atmsimulator.services;

import edu.shtoiko.atmsimulator.exception.WithdrawException;

import java.util.Map;

public interface WithdrawCalculator {
    public Map<String, Integer> calculate(Map<Integer, String> currencyMap, Map<String, Integer> avaliableBanknotesMap,
        int requestValue) throws WithdrawException;
}
