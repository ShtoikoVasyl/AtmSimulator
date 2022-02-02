package edu.shtoiko.atmsimulator.terminal.userframe;

import edu.shtoiko.atmsimulator.controllers.ControllerInterface;
import edu.shtoiko.atmsimulator.controllers.Withdrawing;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** the user frame, which allows you to withdraw money,
 *  shows the quantity of banknotes that are displayed and changes to the database */
public class UserTerminal extends JFrame {
  public UserTerminal() {
    TerminalFrame userFrame = new TerminalFrame();
    JLabel lastMessage = new JLabel();
      lastMessage.setText("Welcome, you authorized as 'USER_NAME'.");
      lastMessage.setHorizontalAlignment(JLabel.CENTER);
      lastMessage.setBounds(20, 5, 435, 35);
      lastMessage.setFont(new Font("", Font.ITALIC, 14));
    String message =
        ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: "
            + DataWarehouseInterface.getAvailableBanknotes()
            + "</div></html>");
    JLabel text = new JLabel("", SwingConstants.CENTER);
      text.setText(message);
      text.setFont(new Font("", Font.BOLD, 15));
      text.setBounds(80, 45, 315, 100);
    JTextField inputSum = new JTextField(5);
      inputSum.setBounds(130, 135, 215, 50);
      inputSum.setFont(new Font("", Font.BOLD, 19));
      inputSum.setHorizontalAlignment(JTextField.CENTER);
    JButton get = new JButton();
      get.setText("Get money");
      get.setFont(new Font("", Font.BOLD, 17));
      get.setBackground(new Color(138, 200, 168));
      get.setBounds(160, 235, 155, 50);
      get.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String input = inputSum.getText();
            int sum = Integer.parseInt(input);
            Withdrawing withdrawing = (Withdrawing) ControllerInterface.withdrawRequest(sum);
            int[] withdrawBanknotes = withdrawing.getOutputingBanknotes();
            String messageUpdate = "Withdraw complete";

            JOptionPane.showMessageDialog(
                new JPanel(),
                "withdraw: \n"
                    + "fifty - "
                    + withdrawBanknotes[0]
                    + "\n"
                    + "hundred - "
                    + withdrawBanknotes[1]
                    + "\n"
                    + "two hundred - "
                    + withdrawBanknotes[2]
                    + "\n"
                    + "five hundred - "
                    + withdrawBanknotes[3]
                    + "\n"
                    + "thousand - "
                    + withdrawBanknotes[4]
                    + "\n");
            String message =
                ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: "
                    + DataWarehouseInterface.getAvailableBanknotes()
                    + "</div></html>");
            text.setText(message);
          }
        });
    JPanel withdrawPanel = new JPanel();
      withdrawPanel.setBackground(new Color(240, 240, 240));
      withdrawPanel.setBounds(70, 0, 475, 350);
      withdrawPanel.setLayout(null);
      withdrawPanel.add(text);
      withdrawPanel.add(inputSum);
      withdrawPanel.add(get);
      withdrawPanel.add(lastMessage);
    userFrame.mainPanel.setBackground(new Color(250, 255, 244));
    userFrame.mainPanel.setLayout(null);
    userFrame.mainPanel.add(withdrawPanel);
  }
}
