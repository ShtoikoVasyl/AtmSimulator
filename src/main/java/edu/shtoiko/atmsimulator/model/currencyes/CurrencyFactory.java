package edu.shtoiko.atmsimulator.model.currencyes;

import edu.shtoiko.atmsimulator.model.currencyes.examples.*;

import java.util.List;

public class CurrencyFactory {

    private static final String[] SUPPORTED_CURRENCIES = {"USD", "UAH", "DKK", "EUR", "SEK"};

    public static Currency createCurrency(String currencyCode) {
        switch (currencyCode) {
            case "USD":
                return new USDCurrency();
            case "UAH":
                return new UAHCurrency();
            case "DKK":
                return new DKKCurrency();
            case "EUR":
                return new EURCurrency();
            case "SEK":
                return new SEKCurrency();
            default:
                throw new IllegalArgumentException("Unknown currency code: " + currencyCode);
        }
    }

    public static String[] getSupportedCurrencies() {
        return SUPPORTED_CURRENCIES;
    }
}
