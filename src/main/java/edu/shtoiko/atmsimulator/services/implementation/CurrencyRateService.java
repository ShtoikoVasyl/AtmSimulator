package edu.shtoiko.atmsimulator.services.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.shtoiko.atmsimulator.exception.ExchangePanelException;
import edu.shtoiko.atmsimulator.model.currencyes.CurrencyFactory;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel.CurrencyRate;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel.CurrencyRateHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CurrencyRateService {
    private static final String URL_ADDRESS = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private static final int TIMEOUT = 400;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BigDecimal MARGIN = new BigDecimal("0.02");
    private final String BASE_CURRENCY_CODE;
    private BigDecimal baseCurrencyRate;

    public CurrencyRateService(String baseCurrencyCode) {
        BASE_CURRENCY_CODE = baseCurrencyCode;
    }

    private List<CurrencyRate> getExchangeRateFromNbu() {
        objectMapper.registerModule(new JavaTimeModule());
        try (
            InputStreamReader inputStreamReader =
                new InputStreamReader(new URL(URL_ADDRESS).openConnection().getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            URLConnection urlConnection = new URL(URL_ADDRESS).openConnection();
            urlConnection.setConnectTimeout(TIMEOUT);
            urlConnection.setReadTimeout(TIMEOUT);

            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();

            List<CurrencyRate> currenciesList = objectMapper.readValue(json, new TypeReference<List<CurrencyRate>>() {
            });
            currenciesList.add(new CurrencyRate(980, "Ukrainian hryvna", BigDecimal.ONE, "UAH", LocalDate.now()));
            return currenciesList;

        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch exchange rates", e);
        }
    }

    public List<CurrencyRateHolder> getExchangeRate() {
        String[] supportedCurrencies = CurrencyFactory.getSupportedCurrencies();
        Set<String> supportedCurrencySet = new HashSet<>(Arrays.asList(supportedCurrencies));
        List<CurrencyRate> currencyRates = getExchangeRateFromNbu();
        baseCurrencyRate = currencyRates.stream()
            .filter(currencyRate -> currencyRate.getCc().equalsIgnoreCase(BASE_CURRENCY_CODE))
            .findFirst()
            .orElseThrow(() -> new ExchangePanelException("Base currency not found in currencyRatesList"))
            .getRate();

        List<CurrencyRateHolder> currencies = currencyRates
            .stream()
            .filter(currencyRate -> supportedCurrencySet.contains(currencyRate.getCc()))
            .filter(currencyRate -> !currencyRate.getCc().equalsIgnoreCase(BASE_CURRENCY_CODE))
            .map(this::convertCurrencyRateToCurrencyRateHolder)
            .collect(Collectors.toList());
        return currencies;
    }

    private CurrencyRateHolder convertCurrencyRateToCurrencyRateHolder(CurrencyRate currencyRate) {
        return new CurrencyRateHolder(currencyRate.getCc(), BASE_CURRENCY_CODE,
            getBuyRate(currencyRate.getRate()).toEngineeringString(),
            getSaleRate(currencyRate.getRate()).toEngineeringString());
    }

    private BigDecimal getSaleRate(BigDecimal basicRate) {
        return basicRate.divide(baseCurrencyRate, 5, RoundingMode.HALF_UP).subtract(basicRate.multiply(MARGIN));
    }

    private BigDecimal getBuyRate(BigDecimal basicRate) {
        return basicRate.divide(baseCurrencyRate, 5, RoundingMode.HALF_UP).add(basicRate.multiply(MARGIN));
    }
}