package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ServicePersonTerminal {

  public ServicePersonTerminal() {

    TerminalFrame serviceFrame = new TerminalFrame();

    JLabel lastMessage = new JLabel();
    lastMessage.setText("Welcome, you authorized as service pesonal.");
    lastMessage.setHorizontalAlignment(JLabel.CENTER);
    lastMessage.setBounds(30, 15, 555, 35);
    lastMessage.setFont(new Font("", Font.BOLD, 14));

    LoadPanel loadPanel = new LoadPanel();
    loadPanel.setBorder(
            BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(new Color(240, 240, 240), 0, true),
                    "Loading Banknotes",
                    TitledBorder.RIGHT,
                    TitledBorder.TOP));
    loadPanel.setBackgroundColor(new Color(255, 255, 255));
    loadPanel.setBounds(225, 50, 370, 275);

    AvaliablePanel avaliablePanel = new AvaliablePanel();
    avaliablePanel.setBackgroundColor(new Color(250, 255, 244));
    avaliablePanel.setBorder(
            BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(new Color(138, 200, 168), 0, true),
                    "Available Banknotes",
                    TitledBorder.LEFT,
                    TitledBorder.TOP));
    avaliablePanel.setBounds(20, 50, 195, 275);

    loadPanel.fifty.inputButton.addActionListener( new LoadButtonListener( avaliablePanel,avaliablePanel.fifty, loadPanel, loadPanel.fifty, lastMessage, "fifty"));
    loadPanel.hundred.inputButton.addActionListener( new LoadButtonListener( avaliablePanel,avaliablePanel.hundred, loadPanel,loadPanel.hundred, lastMessage, "hundred"));
    loadPanel.twoHundred.inputButton.addActionListener( new LoadButtonListener( avaliablePanel,avaliablePanel.twoHundred, loadPanel,loadPanel.twoHundred, lastMessage, "two hundred"));
    loadPanel.fiveHundred.inputButton.addActionListener( new LoadButtonListener( avaliablePanel,avaliablePanel.fiveHundred, loadPanel,loadPanel.fiveHundred, lastMessage, "five hundred"));
    loadPanel.thousand.inputButton.addActionListener( new LoadButtonListener( avaliablePanel,avaliablePanel.thousand, loadPanel,loadPanel.thousand, lastMessage, "thousand"));

    serviceFrame.mainPanel.setBackground(new Color(240, 240, 240));
    serviceFrame.mainPanel.setLayout(null);
    serviceFrame.mainPanel.add(lastMessage);
    serviceFrame.mainPanel.add(loadPanel);
    serviceFrame.mainPanel.add(avaliablePanel);
  }
}
