package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header;

import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.exchangepanel.ExchangePanel;

import javax.swing.*;
import java.awt.Color;
import java.util.List;

/** frame header template */
public class Header extends JPanel {
    public static int height = MainFrame.SCREEN_HEIGHT / 5;

    public Header(ContextHolder contextHolder) {
        setBounds(0, 0, MainFrame.SCREEN_WIDTH, height);
        setBackground(Color.WHITE);
        setLayout(null);
        try {
            add(new LogoLabel(MainFrame.SCREEN_WIDTH / 20, height * 4 / 21, height * 37 / 21, height * 13 / 21));
            add(new ExchangePanel(contextHolder));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
