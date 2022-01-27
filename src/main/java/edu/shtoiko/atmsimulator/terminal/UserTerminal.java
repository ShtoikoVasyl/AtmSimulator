package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;
import edu.shtoiko.atmsimulator.atmresource.Withdrafting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserTerminal extends JFrame{
    public UserTerminal(){

//        int[] load = {25, 20, 1, 10, 20}; // enter several banknotes to load (fifty, hundred, two hundred, five hundred, thousand)
//        ATMloading loading = new ATMloading(); // first load
//        loading.ATMload(load);

        TerminalFrame userFrame = new TerminalFrame();


//        Header header = new Header();

        JLabel lastMessage = new JLabel();
        lastMessage.setText("Welcome, you authorized as 'USER_NAME'.");
        lastMessage.setHorizontalAlignment(JLabel.CENTER);
        lastMessage.setBounds(20,5, 435,35);
        lastMessage.setFont(new Font("", Font.ITALIC, 14));


        String message = ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: " + DBsimulator.getAvailableBanknotes() + "</div></html>");
        JLabel text = new JLabel("", SwingConstants.CENTER);
        text.setText(message);
        text.setFont(new Font("",Font.BOLD,15));
        text.setBounds(80,45,315,100);


        JTextField inputSum = new JTextField(5);
        inputSum.setBounds(130,135,215,50);
        inputSum.setFont(new Font("", Font.BOLD, 19));
        inputSum.setHorizontalAlignment(JTextField.CENTER);
//        String input = inputSum.getText();
//        int sum = Integer.parseInt(input);

        JButton get = new JButton();
        get.setText("Get money");
        get.setFont(new Font("",Font.BOLD,17));
        get.setBackground(new Color(138,200,168));
        get.setBounds(160,235,155,50);
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputSum.getText();
                int sum = Integer.parseInt(input);
                Withdrafting withdrafting = new Withdrafting(sum);
                int[] withdraftBanknotes = withdrafting.getOutputingBanknotes();
                String messageUpdate = "Withdraft complete";


                JOptionPane.showMessageDialog(new JPanel(), "withdraft: \n" +
                        "fifty - " + withdraftBanknotes[0] + "\n" +
                        "hundred - " + withdraftBanknotes[1] + "\n" +
                        "two hundred - " + withdraftBanknotes[2] + "\n" +
                        "five hundred - " + withdraftBanknotes[3] + "\n" +
                        "thousand - " + withdraftBanknotes[4] + "\n");
                String message = ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: " + DBsimulator.getAvailableBanknotes() + "</div></html>");


                        text.setText(message);
            }
        });

        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBackground(new Color(240,240,240));
        withdrawPanel.setBounds(70,0,475,350);
        withdrawPanel.setLayout(null);
        withdrawPanel.add(text);
        withdrawPanel.add(inputSum);
        withdrawPanel.add(get);
        withdrawPanel.add(lastMessage);



//        JPanel mainPanel = new JPanel();
        userFrame.mainPanel.setBackground(new Color(250,255,244));
        userFrame.mainPanel.setLayout(null);
//        mainPanel.add(text);
//        mainPanel.add(inputSum);
//        mainPanel.add(get);
//        mainPanel.add(header);
   //     mainPanel.add(lastMessage);
        userFrame.mainPanel.add(withdrawPanel);





//        userFrame.getContentPane().add(mainPanel);













    }


}
