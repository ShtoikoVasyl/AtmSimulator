package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonFormat
public class CurrencyRate {
    private int r030;
    private String txt;
    private BigDecimal rate;
    private String cc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate exchangedate;

    public CurrencyRate() {
    }

    public CurrencyRate(int r030, String txt, BigDecimal rate, String cc, LocalDate exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public LocalDate getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(LocalDate exchangedate) {
        this.exchangedate = exchangedate;
    }
}
