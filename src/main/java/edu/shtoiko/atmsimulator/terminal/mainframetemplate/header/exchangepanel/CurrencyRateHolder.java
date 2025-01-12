package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel;

public class CurrencyRateHolder {

    private String cc;
    private String baseCc;
    private String buy;
    private String sale;

    public CurrencyRateHolder(String cc, String baseCc, String buy, String sale) {
        this.cc = cc;
        this.baseCc = baseCc;
        this.buy = buy;
        this.sale = sale;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBaseCc() {
        return baseCc;
    }

    public void setBaseCc(String baseCc) {
        this.baseCc = baseCc;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
