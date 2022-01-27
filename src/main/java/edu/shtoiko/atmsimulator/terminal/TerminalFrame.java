package edu.shtoiko.atmsimulator.terminal;

import javax.swing.*;
import java.awt.*;


public class TerminalFrame extends JFrame{
protected MainTerminalPanel mainPanel;
    public TerminalFrame() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(300,100, 615, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.mainPanel = new MainTerminalPanel();
        this.add(mainPanel);
        this.add(new Header());


    }
}
