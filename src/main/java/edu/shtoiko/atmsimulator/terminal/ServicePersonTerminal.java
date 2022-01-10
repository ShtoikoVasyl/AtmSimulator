package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.atmresource.DBsimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicePersonTerminal {

    public ServicePersonTerminal(){
        JFrame serviceFrame = new JFrame();
        serviceFrame.setVisible(true);
        serviceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serviceFrame.setBounds(300,100,600,600);



//            int[] resource;
//            resource = DBsimulator.writeResource();
//            String message = ("Available banknotes:" + "\n" + "Fifty - " + resource[0] + "\n" + "Hundred - " + resource[1]
//                    + "\n" + "Two hundred - " + resource[2] + "\n" + "Five hundred - " + resource[3]
//                    + "\n" + "Thousand - " + resource[4]);
            JLabel mainMesage = new JLabel();
            mainMesage.setText(DBsimulator.messageResource());


        JTextField inputFifty = new JTextField(5);
        JButton loadingFifty = new JButton();
        loadingFifty.setText("Load banknotes 50");
        loadingFifty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputFifty.getText();
                int sum = Integer.parseInt(input);
                DBsimulator.loadFifty(sum);
                mainMesage.setText(DBsimulator.messageResource());
                inputFifty.setText("");
            }
        });


        JTextField inputHundred = new JTextField(5);
        JButton loadingHundred = new JButton();
        loadingHundred.setText("Load banknotes 100");
        loadingHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputHundred.getText();
                int sum = Integer.parseInt(input);
                DBsimulator.loadHundred(sum);
                mainMesage.setText(DBsimulator.messageResource());
                inputHundred.setText("");
            }
        });


        JTextField inputTwoHundred = new JTextField(5);
        JButton loadingTwoHundred = new JButton();
        loadingTwoHundred.setText("Load banknotes 200");
        loadingTwoHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTwoHundred.getText();
                int sum = Integer.parseInt(input);
                DBsimulator.loadTwoHundred(sum);
                mainMesage.setText(DBsimulator.messageResource());
                inputTwoHundred.setText("");
            }
        });


        JTextField inputFiveHundred = new JTextField(5);
        JButton loadingFiveHundred = new JButton();
        loadingFiveHundred.setText("Load banknotes 500");
        loadingFiveHundred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputFiveHundred.getText();
                int sum = Integer.parseInt(input);
                DBsimulator.loadFiveHundred(sum);
                mainMesage.setText(DBsimulator.messageResource());
                inputFiveHundred.setText("");
            }
        });


        JTextField inputThousand = new JTextField(5);
        JButton loadingThousand = new JButton();
        loadingThousand.setText("Load banknotes 1000");
        loadingThousand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputThousand.getText();
                int sum = Integer.parseInt(input);
                DBsimulator.loadThousand(sum);
                mainMesage.setText(DBsimulator.messageResource());
                inputThousand.setText("");
            }
        });




        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(mainMesage);
        mainPanel.add(inputFifty);
        mainPanel.add(loadingFifty);
        mainPanel.add(inputHundred);
        mainPanel.add(loadingHundred);
        mainPanel.add(inputTwoHundred);
        mainPanel.add(loadingTwoHundred);
        mainPanel.add(inputFiveHundred);
        mainPanel.add(loadingFiveHundred);
        mainPanel.add(inputThousand);
        mainPanel.add(loadingThousand);

        serviceFrame.getContentPane().add(mainPanel);






    }


}
