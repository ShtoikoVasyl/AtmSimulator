package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.listeners.TerminalWindowListener;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

/** service frame, displays available banknotes and allows load banknotes */
public class ServicePersonTerminal {

  /** @param superFrame the frame that will need to be processed in WindowListener */
  public ServicePersonTerminal(JFrame superFrame) {
    TerminalFrame serviceFrame = new TerminalFrame();
    serviceFrame.addWindowListener(new TerminalWindowListener(superFrame));
    serviceFrame.setTitle("Service terminal");
    JLabel lastMessage = new JLabel();
    lastMessage.setText("Welcome, you authorized as service personal.");
    lastMessage.setHorizontalAlignment(JLabel.CENTER);
    lastMessage.setBounds(30, 15, 555, 35);
    lastMessage.setFont(new Font("", Font.BOLD, 14));
    AvailablePanel availablePanel = new AvailablePanel();
    availablePanel.setBackgroundColor(new Color(250, 255, 244));
    availablePanel.setBorder(
        BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(138, 200, 168), 0, true),
            "Available Banknotes",
            TitledBorder.LEFT,
            TitledBorder.TOP));
    availablePanel.setBounds(20, 50, 195, 275);
    LoadPanel loadPanel = new LoadPanel();
    loadPanel.setBorder(
        BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(240, 240, 240), 0, true),
            "Loading Banknotes",
            TitledBorder.RIGHT,
            TitledBorder.TOP));
    loadPanel.setBackgroundColor(new Color(255, 255, 255));
    loadPanel.setBounds(225, 50, 370, 275);
    loadPanel.fifty.inputButton.addActionListener(
        new LoadButtonListener(
            availablePanel,
            availablePanel.fifty,
            loadPanel,
            loadPanel.fifty,
            lastMessage,
            "fifty"));
    loadPanel.hundred.inputButton.addActionListener(
        new LoadButtonListener(
            availablePanel,
            availablePanel.hundred,
            loadPanel,
            loadPanel.hundred,
            lastMessage,
            "hundred"));
    loadPanel.twoHundred.inputButton.addActionListener(
        new LoadButtonListener(
            availablePanel,
            availablePanel.twoHundred,
            loadPanel,
            loadPanel.twoHundred,
            lastMessage,
            "two hundred"));
    loadPanel.fiveHundred.inputButton.addActionListener(
        new LoadButtonListener(
            availablePanel,
            availablePanel.fiveHundred,
            loadPanel,
            loadPanel.fiveHundred,
            lastMessage,
            "five hundred"));
    loadPanel.thousand.inputButton.addActionListener(
        new LoadButtonListener(
            availablePanel,
            availablePanel.thousand,
            loadPanel,
            loadPanel.thousand,
            lastMessage,
            "thousand"));
    serviceFrame.mainPanel.setBackground(new Color(240, 240, 240));
    serviceFrame.mainPanel.setLayout(null);
    serviceFrame.mainPanel.add(lastMessage);
    serviceFrame.mainPanel.add(loadPanel);
    serviceFrame.mainPanel.add(availablePanel);
  }
}
