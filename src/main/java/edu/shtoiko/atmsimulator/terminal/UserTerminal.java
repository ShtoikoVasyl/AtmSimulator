package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.atmresource.Withdrafting;
import edu.shtoiko.atmsimulator.atmresource.ATMloading;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserTerminal {
    public UserTerminal(){

        int[] load = {25, 20, 1, 10, 20}; // enter several banknotes to load (fifty, hundred, two hundred, five hundred, thousand)
        ATMloading loading = new ATMloading(); // first load
        loading.ATMload(load);

        JFrame userFrame = new JFrame();
        userFrame.setVisible(true);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setBounds(300,100,600,600);

        String message = "What amount do you want to get?";
        JLabel text = new JLabel();
        text.setText(message);

        JTextField inputSum = new JTextField(5);
//        String input = inputSum.getText();
//        int sum = Integer.parseInt(input);

        JButton get = new JButton();
        get.setText("Get it...");
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputSum.getText();
                int sum = Integer.parseInt(input);
                Withdrafting withdrafting = new Withdrafting(sum);
                int[] withdraftBanknotes = withdrafting.getOutputingBanknotes();


                JOptionPane.showMessageDialog(new JPanel(), "withdraft: \n" +
                        "fifty - " + withdraftBanknotes[0] + "\n" +
                        "hundred - " + withdraftBanknotes[1] + "\n" +
                        "two hundred - " + withdraftBanknotes[2] + "\n" +
                        "five hundred - " + withdraftBanknotes[3] + "\n" +
                        "thousand - " + withdraftBanknotes[4] + "\n");
            }
        });



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(text, BorderLayout.NORTH);
        mainPanel.add(inputSum, BorderLayout.CENTER);
        mainPanel.add(get, BorderLayout.SOUTH);





        userFrame.getContentPane().add(mainPanel);













    }


}
