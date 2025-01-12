package edu.shtoiko.atmsimulator.services.implementation;

import edu.shtoiko.atmsimulator.exception.WithdrawException;
import edu.shtoiko.atmsimulator.services.WithdrawCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WithdrawProvider implements WithdrawCalculator {
    int requestSum;
    int confirmSum;
    int withdrawBanknotesSum;

    public Map<String, Integer> calculate(Map<Integer, String> currencyMap, Map<String, Integer> availableBanknotesMap,
        int requestValue) throws WithdrawException {
        requestSum = requestValue;
        confirmSum = 0;
        withdrawBanknotesSum = 0;
        List<Integer> currencyKey = new ArrayList<>(currencyMap.keySet());
        currencyKey.sort(Comparator.comparingInt(x -> -x));
        Map<String, Integer> result = new HashMap<>();
        for (Integer iterator : currencyKey) {
            int value =
                calc(getQuantityFromAvailableMap(availableBanknotesMap, currencyMap, iterator), iterator, requestSum);
            result.put(currencyMap.get(iterator), value);
        }
        if (requestSum != 0) {
            throw new WithdrawException("We can withdraw " + (requestValue - requestSum));
        }
        return result;
    }

    private int getQuantityFromAvailableMap(Map<String, Integer> availableBanknotesMap,
        Map<Integer, String> currencyMap, Integer denomination) {
        int result;
        try {
            result = availableBanknotesMap.get(currencyMap.get(denomination));
        } catch (NullPointerException e) {
            return 0;
        }
        return result;
    }

    private int calc(int availableQuantity, int denomination, int requestValue) throws WithdrawException {
        if (availableQuantity * denomination > requestValue) {
            int result = requestValue / denomination;
            checkBanknotesQuantity(withdrawBanknotesSum + result, denomination);
            addChange(result, denomination);
            return result;
        } else {
            checkBanknotesQuantity(withdrawBanknotesSum + availableQuantity, denomination);
            addChange(availableQuantity, denomination);
            return availableQuantity;
        }
    }

    private void addChange(int banknotesQuantity, int denomination) {
        withdrawBanknotesSum += banknotesQuantity;
        confirmSum += banknotesQuantity * denomination;
        requestSum -= banknotesQuantity * denomination;
    }

    private void checkBanknotesQuantity(int quantity, int denomination) throws WithdrawException {
        if (quantity > 50) {
            int canWithdraw = confirmSum + ((50 - withdrawBanknotesSum) * denomination);
            throw new WithdrawException("banknotes quantity more 50, we can withdraw " + canWithdraw);
        }
    }
}
