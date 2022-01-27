package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.datawarehouse.ATMloading;
import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicePersonTerminal {

    public ServicePersonTerminal(){

        int maxTotalBanknotes = 5000;

        TerminalFrame serviceFrame = new TerminalFrame();


//        Header header = new Header();

        JLabel lastMessage = new JLabel();
        lastMessage.setText("Welcome, you authorized as service pesonal.");
        lastMessage.setHorizontalAlignment(JLabel.CENTER);
        lastMessage.setBounds(30,15, 555,35);
        lastMessage.setFont(new Font("", Font.BOLD, 14));



            JLabel avaliableFiftyRight = new JLabel();
            avaliableFiftyRight.setText(Integer.toString(DBsimulator.getFifty()));
            avaliableFiftyRight.setHorizontalAlignment(JLabel.RIGHT);
            avaliableFiftyRight.setBounds(115,20,65,30);
        JLabel avaliableFiftyLeft = new JLabel();
        avaliableFiftyLeft.setText("Fifty:");
        avaliableFiftyLeft.setBounds(15,20,100,30);
        avaliableFiftyLeft.setForeground(new Color(127,127,127));

            JLabel availableHundredRight = new JLabel();
            availableHundredRight.setText(Integer.toString(DBsimulator.getHundred()));
            availableHundredRight.setHorizontalAlignment(JLabel.RIGHT);
        availableHundredRight.setBounds(115,60,65,30);
        JLabel availableHundredLeft = new JLabel();
        availableHundredLeft.setText("Hundred:");
        availableHundredLeft.setBounds(15,60,100,30);
        availableHundredLeft.setForeground(new Color(127,127,127));


        JLabel availableTwoHundredRight = new JLabel();
        availableTwoHundredRight.setText(Integer.toString(DBsimulator.getTwoHundred()));
        availableTwoHundredRight.setHorizontalAlignment(JLabel.RIGHT);
        availableTwoHundredRight.setBounds(115,100,65,30);
        JLabel availableTwoHundredLeft = new JLabel();
        availableTwoHundredLeft.setText("Two hundred:");
        availableTwoHundredLeft.setBounds(15,100,100,30);
        availableTwoHundredLeft.setForeground(new Color(127,127,127));


        JLabel availableFiveHundredRight = new JLabel();
        availableFiveHundredRight.setText(Integer.toString(DBsimulator.getFiveHundred()));
        availableFiveHundredRight.setHorizontalAlignment(JLabel.RIGHT);
        availableFiveHundredRight.setBounds(115,140,65,30);
        JLabel availableFiveHundredLeft = new JLabel();
        availableFiveHundredLeft.setText("Five hundred:");
        availableFiveHundredLeft.setBounds(15,140,100,30);
        availableFiveHundredLeft.setForeground(new Color(127,127,127));

        JLabel availableThousandRight = new JLabel();
        availableThousandRight.setText(Integer.toString(DBsimulator.getThousand()));
        availableThousandRight.setHorizontalAlignment(JLabel.RIGHT);
        availableThousandRight.setBounds(115,180,65,30);
        JLabel availableThousandLeft = new JLabel();
        availableThousandLeft.setText("Thousand:");
        availableThousandLeft.setBounds(15,180,100,30);
        availableThousandLeft.setForeground(new Color(127,127,127));


        JLabel totalBanknotesRight = new JLabel();
        totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
        totalBanknotesRight.setFont(new Font("",Font.BOLD,15));
        totalBanknotesRight.setForeground(new Color(175,65,55));
        totalBanknotesRight.setHorizontalAlignment(JLabel.RIGHT);
        totalBanknotesRight.setBounds(115,230,65,30);
        JLabel totalBanknotesLeft = new JLabel();
        totalBanknotesLeft.setText("Total quantity:");
        totalBanknotesLeft.setFont(new Font("",Font.BOLD,14));
        totalBanknotesLeft.setForeground(new Color(205,85,74));
        totalBanknotesLeft.setBounds(15,230,110,30);




        JLabel loadToMaxLeft = new JLabel();
        loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
        loadToMaxLeft.setFont(new Font("",Font.BOLD,15));
        loadToMaxLeft.setBounds(15,230,130,30);
        JLabel loadToMaxRight = new JLabel();
        loadToMaxRight.setText("can be loaded");
        loadToMaxRight.setHorizontalAlignment(JLabel.RIGHT);
        loadToMaxRight.setFont(new Font("",Font.BOLD,15));
        loadToMaxRight.setBounds(145,230,210,30);




        JTextField inputFifty = new JTextField(5);
        inputFifty.setBounds(15,20,155,30);
        inputFifty.setBackground(new Color(250,255,244));
        JButton loadingFifty = new JButton();
        loadingFifty.setBounds(180, 20, 175, 30);
        loadingFifty.setBackground(new Color(138,200,168));
        loadingFifty.setText("Load banknotes 50");
        loadingFifty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputFifty.getText();
                int sum = Integer.parseInt(input);
                int[] load = new int[5];
                load[0] = sum;
                ATMloading loading = new ATMloading();
                if (loading.ATMload(load)){
                    lastMessage.setText("You load " + sum + " banknotes of fifty denomination.");
                    lastMessage.setForeground(Color.BLACK);
                }
                else {
                    lastMessage.setText("ERROR");
                    lastMessage.setForeground(new Color(205,85,74));
                }
                inputFifty.setText("");
                avaliableFiftyRight.setText(Integer.toString(DBsimulator.getFifty()));
                totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
                loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));


            }
        });


        JTextField inputHundred = new JTextField(5);
        inputHundred.setBounds(15,60,155,30);
        inputHundred.setBackground(new Color(250,255,244));

        JButton loadingHundred = new JButton();
        loadingHundred.setBounds(180,60,175,30);
        loadingHundred.setBackground(new Color(138,200,168));
        loadingHundred.setText("Load banknotes 100");
        loadingHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputHundred.getText();
                int sum = Integer.parseInt(input);
                int[] load = new int[5];
                load[1] = sum;
                ATMloading loading = new ATMloading();
                if (loading.ATMload(load)){
                    lastMessage.setText("You load " + sum + " banknotes of hundred denomination.");
                    lastMessage.setForeground(Color.BLACK);
                }
                else {
                    lastMessage.setText("ERROR");
                    lastMessage.setForeground(new Color(205,85,74));
                }
                inputHundred.setText("");
                availableHundredRight.setText(Integer.toString(DBsimulator.getHundred()));
                totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
                loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));

            }
        });


        JTextField inputTwoHundred = new JTextField(5);
        inputTwoHundred.setBounds(15,100,155,30);
        inputTwoHundred.setBackground(new Color(250,255,244));

        JButton loadingTwoHundred = new JButton();
        loadingTwoHundred.setBounds(180,100,175,30);
        loadingTwoHundred.setBackground(new Color(138,200,168));

        loadingTwoHundred.setText("Load banknotes 200");
        loadingTwoHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTwoHundred.getText();
                int sum = Integer.parseInt(input);
                int[] load = new int[5];
                load[2] = sum;
                ATMloading loading = new ATMloading();
                if (loading.ATMload(load)){
                    lastMessage.setText("You load " + sum + " banknotes of two hundred denomination.");
                    lastMessage.setForeground(Color.BLACK);
                }
                else {
                    lastMessage.setText("ERROR");
                    lastMessage.setForeground(new Color(205,85,74));
                }
                inputTwoHundred.setText("");
                availableTwoHundredRight.setText(Integer.toString(DBsimulator.getTwoHundred()));
                totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
                loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));

            }
        });


        JTextField inputFiveHundred = new JTextField(5);
        inputFiveHundred.setBounds(15,140,155,30);
        inputFiveHundred.setBackground(new Color(250,255,244));

        JButton loadingFiveHundred = new JButton();
        loadingFiveHundred.setBounds(180,140,175,30);
        loadingFiveHundred.setBackground(new Color(138,200,168));

        loadingFiveHundred.setText("Load banknotes 500");
        loadingFiveHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputFiveHundred.getText();
                int sum = Integer.parseInt(input);
                int[] load = new int[5];
                load[3] = sum;
                ATMloading loading = new ATMloading();
                if (loading.ATMload(load)){
                    lastMessage.setText("You load " + sum + " banknotes of five hundred denomination.");
                    lastMessage.setForeground(Color.BLACK);
                }
                else {
                    lastMessage.setText("ERROR");
                    lastMessage.setForeground(new Color(205,85,74));
                }
                inputFiveHundred.setText("");
                availableFiveHundredRight.setText(Integer.toString(DBsimulator.getFiveHundred()));
                totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
                loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
            }
        });


        JTextField inputThousand = new JTextField(5);
        inputThousand.setBounds(15,180,155,30);
        inputThousand.setBackground(new Color(250,255,244));

        JButton loadingThousand = new JButton();
        loadingThousand.setBounds(180,180,175,30);
        loadingThousand.setBackground(new Color(138,200,168));

        loadingThousand.setText("Load banknotes 1000");
        loadingThousand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputThousand.getText();
                int sum = Integer.parseInt(input);
                int[] load = new int[5];
                load[4] = sum;
                ATMloading loading = new ATMloading();
                if (loading.ATMload(load)){
                    lastMessage.setText("You load " + sum + " banknotes of thousand denomination.");
                    lastMessage.setForeground(Color.BLACK);
                }
                else {
                    lastMessage.setText("ERROR");
                    lastMessage.setForeground(new Color(205,85,74));
                }
                inputThousand.setText("");
                availableThousandRight.setText(Integer.toString(DBsimulator.getThousand()));
                totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
                loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DBsimulator.getTotalBanknotes()));
            }
        });






        JPanel availablePanel = new JPanel();
        availablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(138,200,168), 0, true), "Available Banknotes", TitledBorder.LEFT, TitledBorder.TOP));

        availablePanel.setBounds(20,50,195,275);
        availablePanel.setBackground(new Color(245,255,239));
        availablePanel.setLayout(null);
        availablePanel.add(avaliableFiftyRight);
        availablePanel.add(avaliableFiftyLeft);
        availablePanel.add(availableHundredRight);
        availablePanel.add(availableHundredLeft);
        availablePanel.add(availableTwoHundredRight);
        availablePanel.add(availableTwoHundredLeft);
        availablePanel.add(availableFiveHundredRight);
        availablePanel.add(availableFiveHundredLeft);
        availablePanel.add(availableThousandRight);
        availablePanel.add(availableThousandLeft);
        availablePanel.add(totalBanknotesRight);
        availablePanel.add(totalBanknotesLeft);





        JPanel loadPanel = new JPanel();
        loadPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240,240,240), 0, true), "Loading Banknotes", TitledBorder.RIGHT, TitledBorder.TOP));
        loadPanel.setBackground(new Color(255,255,255));
        loadPanel.setBounds(225,50,370,275);
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




//        JPanel mainPanel = new JPanel();
//        serviceFrame.mainPanel.setBounds(0,125,615,475);

        serviceFrame.mainPanel.setBackground(new Color(240,240,240));
        serviceFrame.mainPanel.setLayout(null);
        serviceFrame.mainPanel.add(lastMessage);
        serviceFrame.mainPanel.add(loadPanel);
        serviceFrame.mainPanel.add(availablePanel);
//        mainPanel.add(header);

//        serviceFrame.getContentPane().add(mainPanel);
//        serviceFrame.add(mainPanel);






    }


}
