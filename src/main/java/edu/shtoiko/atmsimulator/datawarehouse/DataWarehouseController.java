package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.model.currencyes.Currency;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DataWarehouseController implements StorageProvider {

    private final BanknotesManager banknotesManager;
    private Currency currency;

    public DataWarehouseController(Currency currency) {
        this.currency = currency;
        this.banknotesManager = new SimpleBanknotesManager(currency);
    }

    public Map<Integer, String> getAvailableBanknotes() {
        return getCurrencyMap().entrySet()
            .stream()
            .filter(entry -> this.getResourcesByValueNames().containsKey(entry.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * @deprecated
     */
    public Map<Integer, String> getCurrencyMap() {
        return currency.getBanknotesMap();
    }

    public Map<String, Integer> getResourcesByValueNames() {
        return banknotesManager.getResource(currency);
    }

    @Override
    public Map<Integer, Integer> getResourcesByValue() {
        Map<Integer, String> currencyMap = getCurrencyMap();
        Map<String, Integer> resourcesByValueNames = getResourcesByValueNames();
        Map<Integer, Integer> resultMap = currencyMap.entrySet()
            .stream()
            .filter(entry -> resourcesByValueNames.containsKey(entry.getValue()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> resourcesByValueNames.get(entry.getValue()),
                (e1, e2) -> e1,
                TreeMap::new));
        return resultMap;
    }

    public int getTotalQuantity() {
        return this.getResourcesByValueNames().values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    @Override
    public void takeOutByName(String name, Integer value) {
        banknotesManager.takeOutByName(name, value, currency);
    }

    public int getBanknotesQuantityByName(String name) {
        return banknotesManager.getBanknotesQuantityByName(name, currency);
    }

    public void loadBanknotesByName(String name, int value) {
        banknotesManager.loadBanknotesByName(name, value, currency);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
