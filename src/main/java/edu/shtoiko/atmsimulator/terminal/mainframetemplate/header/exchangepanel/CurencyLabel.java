package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class CurencyLabel extends JLabel {

    public CurencyLabel(String ccy, String base_ccy, String buy, String sale, int height) {
        buy = getSubstring(buy);
        sale = getSubstring(sale);
        setText(ccy + " / " + base_ccy + "  :  " + buy + " / " + sale);
        this.setForeground(new Color(138, 200, 168));
        setHorizontalAlignment(JLabel.CENTER);

        setFont(new Font("", Font.BOLD, MainFrame.FONT_SIZE));
        this.setBounds(0, height, ExchangePanel.PANEL_WIDTH, ExchangePanel.PANEL_HEIGHT / 4);
        this.setVisible(true);
    }

    private String getSubstring(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (raw.length() < 5) {
            raw = raw + "    ";
        }
        return raw.substring(0, 5);
    }
}
