package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel;

import edu.shtoiko.atmsimulator.services.implementation.CurrencyRateService;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.Header;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.List;

public class ExchangePanel extends JPanel {

    public static int PANEL_HEIGHT = (Header.height * 9) / 10;
    public static int PANEL_WIDTH = MainFrame.SCREEN_WIDTH / 4;
    private final ContextHolder contextHolder;

    public ExchangePanel(ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
        int retreat = (Header.height * 1) / 20;
        setBounds(MainFrame.SCREEN_WIDTH - PANEL_WIDTH - retreat, retreat, PANEL_WIDTH, PANEL_HEIGHT);
        setBackground(new Color(250, 255, 244));
        setLayout(null);
        setVisible(true);
        addCurrencies();
    }

    protected void addCurrencies() {
        CurrencyRateService currencyRateService =
            new CurrencyRateService(contextHolder.getCurrency().getCurrencyCode());
        List<CurrencyRateHolder> currencies = currencyRateService.getExchangeRate();
        int i = 0;
        for (CurrencyRateHolder currencyRate : currencies) {

            int labelHeight = i * ExchangePanel.PANEL_HEIGHT / 4;
            this.add(new CurencyLabel(currencyRate.getCc(), currencyRate.getBaseCc(), currencyRate.getBuy(),
                currencyRate.getSale(), labelHeight));
            i++;
        }
    }
}
