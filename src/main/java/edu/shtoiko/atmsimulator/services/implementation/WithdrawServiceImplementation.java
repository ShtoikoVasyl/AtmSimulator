package edu.shtoiko.atmsimulator.services.implementation;

import edu.shtoiko.atmsimulator.exception.WithdrawException;
import edu.shtoiko.atmsimulator.model.currencyes.Currency;
import edu.shtoiko.atmsimulator.services.WithdrawCalculator;
import edu.shtoiko.atmsimulator.services.WithdrawService;

import java.util.Map;

public class WithdrawServiceImplementation implements WithdrawService {
    Currency currency;

    private WithdrawCalculator provider;

    public WithdrawServiceImplementation(Currency currency, WithdrawCalculator withdrawProvider) {
        provider = withdrawProvider;
        this.currency = currency;
    }

    public Map<String, Integer> withdrawRequest(Map<String, Integer> availableBanknotes, int withdrawRequestSum)
        throws WithdrawException {
        return provider.calculate(currency.getBanknotesMap(), availableBanknotes, withdrawRequestSum);
    }
}
