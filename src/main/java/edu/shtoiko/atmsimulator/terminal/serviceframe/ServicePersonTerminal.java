package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.ATMloading;
import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    loadPanel.fifty.inputButton.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = loadPanel.fifty.inputField.getText();
            int sum = Integer.parseInt(input);
            int[] load = new int[5];
            load[0] = sum;
            ATMloading loading = new ATMloading();
            if (loading.ATMload(load)) {
              lastMessage.setText("You load " + sum + " banknotes of fifty denomination.");
              lastMessage.setForeground(Color.BLACK);
            } else {
              lastMessage.setText("ERROR");
              lastMessage.setForeground(new Color(205, 85, 74));
            }
            loadPanel.fifty.inputField.setText("");
            avaliablePanel.fifty.setQuantity(Integer.toString(DBsimulator.getFifty()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DBsimulator.getTotalBanknotes()));
          }
        });

    loadPanel.hundred.inputButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = loadPanel.hundred.inputField.getText();
            int sum = Integer.parseInt(input);
            int[] load = new int[5];
            load[1] = sum;
            ATMloading loading = new ATMloading();
            if (loading.ATMload(load)) {
              lastMessage.setText("You load " + sum + " banknotes of hundred denomination.");
              lastMessage.setForeground(Color.BLACK);
            } else {
              lastMessage.setText("ERROR");
              lastMessage.setForeground(new Color(205, 85, 74));
            }
            loadPanel.hundred.inputField.setText("");
            avaliablePanel.hundred.setQuantity(Integer.toString(DBsimulator.getHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes()- DBsimulator.getTotalBanknotes()));
          }
        });

    loadPanel.twoHundred.inputButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = loadPanel.twoHundred.inputField.getText();
            int sum = Integer.parseInt(input);
            int[] load = new int[5];
            load[2] = sum;
            ATMloading loading = new ATMloading();
            if (loading.ATMload(load)) {
              lastMessage.setText("You load " + sum + " banknotes of two hundred denomination.");
              lastMessage.setForeground(Color.BLACK);
            } else {
              lastMessage.setText("ERROR");
              lastMessage.setForeground(new Color(205, 85, 74));
            }
            loadPanel.twoHundred.inputField.setText("");
            avaliablePanel.twoHundred.setQuantity(Integer.toString(DBsimulator.getTwoHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DBsimulator.getTotalBanknotes()));
          }
        });

    loadPanel.fiveHundred.inputButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = loadPanel.fiveHundred.inputField.getText();
            int sum = Integer.parseInt(input);
            int[] load = new int[5];
            load[3] = sum;
            ATMloading loading = new ATMloading();
            if (loading.ATMload(load)) {
              lastMessage.setText("You load " + sum + " banknotes of five hundred denomination.");
              lastMessage.setForeground(Color.BLACK);
            } else {
              lastMessage.setText("ERROR");
              lastMessage.setForeground(new Color(205, 85, 74));
            }
            loadPanel.fiveHundred.inputField.setText("");
            avaliablePanel.fiveHundred.setQuantity(Integer.toString(DBsimulator.getFiveHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DBsimulator.getTotalBanknotes()));
          }
        });

    loadPanel.thousand.inputButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = loadPanel.thousand.inputField.getText();
            int sum = Integer.parseInt(input);
            int[] load = new int[5];
            load[4] = sum;
            ATMloading loading = new ATMloading();
            if (loading.ATMload(load)) {
              lastMessage.setText("You load " + sum + " banknotes of thousand denomination.");
              lastMessage.setForeground(Color.BLACK);
            } else {
              lastMessage.setText("ERROR");
              lastMessage.setForeground(new Color(205, 85, 74));
            }
            loadPanel.thousand.inputField.setText("");
            avaliablePanel.thousand.setQuantity(Integer.toString(DBsimulator.getThousand()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DBsimulator.getTotalBanknotes()));
          }
        });

    serviceFrame.mainPanel.setBackground(new Color(240, 240, 240));
    serviceFrame.mainPanel.setLayout(null);
    serviceFrame.mainPanel.add(lastMessage);
    serviceFrame.mainPanel.add(loadPanel);
    serviceFrame.mainPanel.add(avaliablePanel);
  }
}
