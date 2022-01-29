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

    final int maxTotalBanknotes = 5000;

    TerminalFrame serviceFrame = new TerminalFrame();

    JLabel lastMessage = new JLabel();
    lastMessage.setText("Welcome, you authorized as service pesonal.");
    lastMessage.setHorizontalAlignment(JLabel.CENTER);
    lastMessage.setBounds(30, 15, 555, 35);
    lastMessage.setFont(new Font("", Font.BOLD, 14));


    AvaliablePanel avaliablePanel = new AvaliablePanel();
    avaliablePanel.setBeckground(new Color(250, 255, 244));
    avaliablePanel.setBorder(
            BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(new Color(138, 200, 168), 0, true),
                    "Available Banknotes",
                    TitledBorder.LEFT,
                    TitledBorder.TOP));
    avaliablePanel.setBounds(20, 50, 195, 275);

    JLabel loadToMaxLeft = new JLabel();
    loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
    loadToMaxLeft.setFont(new Font("", Font.BOLD, 15));
    loadToMaxLeft.setBounds(15, 230, 130, 30);
    JLabel loadToMaxRight = new JLabel();
    loadToMaxRight.setText("can be loaded");
    loadToMaxRight.setHorizontalAlignment(JLabel.RIGHT);
    loadToMaxRight.setFont(new Font("", Font.BOLD, 15));
    loadToMaxRight.setBounds(145, 230, 210, 30);

    JTextField inputFifty = new JTextField(5);
    inputFifty.setBounds(15, 20, 155, 30);
    inputFifty.setBackground(new Color(250, 255, 244));
    JButton loadingFifty = new JButton();
    loadingFifty.setBounds(180, 20, 175, 30);
    loadingFifty.setBackground(new Color(138, 200, 168));
    loadingFifty.setText("Load banknotes 50");
    loadingFifty.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputFifty.getText();
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
            inputFifty.setText("");
//            avaliableFiftyRight.setText(Integer.toString(DBsimulator.getFifty()));
            avaliablePanel.fifty.setQuantity(Integer.toString(DBsimulator.getFifty()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadToMaxLeft.setText(
                Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
          }
        });

    JTextField inputHundred = new JTextField(5);
    inputHundred.setBounds(15, 60, 155, 30);
    inputHundred.setBackground(new Color(250, 255, 244));

    JButton loadingHundred = new JButton();
    loadingHundred.setBounds(180, 60, 175, 30);
    loadingHundred.setBackground(new Color(138, 200, 168));
    loadingHundred.setText("Load banknotes 100");
    loadingHundred.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputHundred.getText();
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
            inputHundred.setText("");
            avaliablePanel.hundred.setQuantity(Integer.toString(DBsimulator.getHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadToMaxLeft.setText(
                Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
          }
        });

    JTextField inputTwoHundred = new JTextField(5);
    inputTwoHundred.setBounds(15, 100, 155, 30);
    inputTwoHundred.setBackground(new Color(250, 255, 244));

    JButton loadingTwoHundred = new JButton();
    loadingTwoHundred.setBounds(180, 100, 175, 30);
    loadingTwoHundred.setBackground(new Color(138, 200, 168));

    loadingTwoHundred.setText("Load banknotes 200");
    loadingTwoHundred.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputTwoHundred.getText();
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
            inputTwoHundred.setText("");
            avaliablePanel.twoHundred.setQuantity(Integer.toString(DBsimulator.getTwoHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadToMaxLeft.setText(
                Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
          }
        });

    JTextField inputFiveHundred = new JTextField(5);
    inputFiveHundred.setBounds(15, 140, 155, 30);
    inputFiveHundred.setBackground(new Color(250, 255, 244));

    JButton loadingFiveHundred = new JButton();
    loadingFiveHundred.setBounds(180, 140, 175, 30);
    loadingFiveHundred.setBackground(new Color(138, 200, 168));

    loadingFiveHundred.setText("Load banknotes 500");
    loadingFiveHundred.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputFiveHundred.getText();
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
            inputFiveHundred.setText("");
            avaliablePanel.fiveHundred.setQuantity(Integer.toString(DBsimulator.getFiveHundred()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadToMaxLeft.setText(
                Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
          }
        });

    JTextField inputThousand = new JTextField(5);
    inputThousand.setBounds(15, 180, 155, 30);
    inputThousand.setBackground(new Color(250, 255, 244));

    JButton loadingThousand = new JButton();
    loadingThousand.setBounds(180, 180, 175, 30);
    loadingThousand.setBackground(new Color(138, 200, 168));

    loadingThousand.setText("Load banknotes 1000");
    loadingThousand.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputThousand.getText();
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
            inputThousand.setText("");
            avaliablePanel.thousand.setQuantity(Integer.toString(DBsimulator.getThousand()));
            avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
            loadToMaxLeft.setText(
                Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
          }
        });
    
    JPanel loadPanel = new JPanel();
    loadPanel.setBorder(
        BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(240, 240, 240), 0, true),
            "Loading Banknotes",
            TitledBorder.RIGHT,
            TitledBorder.TOP));
    loadPanel.setBackground(new Color(255, 255, 255));
    loadPanel.setBounds(225, 50, 370, 275);
    loadPanel.setLayout(null);
    loadPanel.add(inputFifty);
    loadPanel.add(loadingFifty);
    loadPanel.add(inputHundred);
    loadPanel.add(loadingHundred);
    loadPanel.add(inputTwoHundred);
    loadPanel.add(loadingTwoHundred);
    loadPanel.add(inputFiveHundred);
    loadPanel.add(loadingFiveHundred);
    loadPanel.add(inputThousand);
    loadPanel.add(loadingThousand);
    loadPanel.add(loadToMaxLeft);
    loadPanel.add(loadToMaxRight);

    serviceFrame.mainPanel.setBackground(new Color(240, 240, 240));
    serviceFrame.mainPanel.setLayout(null);
    serviceFrame.mainPanel.add(lastMessage);
    serviceFrame.mainPanel.add(loadPanel);
    serviceFrame.mainPanel.add(avaliablePanel);
  }
}
