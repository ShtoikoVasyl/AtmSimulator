package edu.shtoiko.atmsimulator.datawarehouse;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;
import java.util.Map;
import java.util.stream.Collectors;

public class DataWarehouseController implements StorageProvider {

  private final BanknotesManager banknotesManager;
  private Currency currency;

  {
      banknotesManager = new SimpleBanknotesManager();}

  public DataWarehouseController(Currency currency) {
    this.currency = currency;
  }

  public Map<Integer, String> getAvailableBanknotes() {
    return getCurrencyMap().entrySet()
            .stream()
            .filter(entry -> getResources().containsKey(entry.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

    /**
     * @deprecated
     */
  public Map<Integer, String> getCurrencyMap(){
    return currency.getBanknotesMap();
  }
  public Map<String, Integer> getResources(){
    return banknotesManager.getResource(currency);
  }

  public int getTotalQuantity(){
    return getResources().values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
  }

  @Override
  public void takeOutByName(String name, Integer value) {
    banknotesManager.takeOutByName(name, value, currency);
  }

  public int getBanknotesQuantityByName(String name){
    return banknotesManager.getBanknotesQuantityByName(name, currency);
  }

  public void loadBanknotesByName(String name, int value){
    banknotesManager.loadBanknotesByName(name, value, currency);
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }
}
