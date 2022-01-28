package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.terminal.serviceframe.ServicePersonTerminal;
import edu.shtoiko.atmsimulator.terminal.userframe.UserTerminal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static void main(String[] args)
      throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
          IllegalAccessException {

    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

    JFrame frame = new JFrame("ATM");

    frame.setBounds(300, 100, 300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    ButtonGroup choice = new ButtonGroup();
    JRadioButton user = new JRadioButton("User", true);
    choice.add(user);
    JRadioButton service = new JRadioButton("Service person", false);
    choice.add(service);

    String message = "You want authorithed as..";
    JLabel text = new JLabel();
    text.setText(message);

    JButton autorized = new JButton();
    autorized.setText("Autorization");
    autorized.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (user.isSelected()) {

              text.setText(message + "User");

              //              frame.setVisible(false);
              UserTerminal user = new UserTerminal();
            }
            if (service.isSelected()) {

              text.setText(message + "Service");

              //              frame.setVisible(false);
              ServicePersonTerminal service = new ServicePersonTerminal();
            }
          }
        });


    JPanel panel = new JPanel();

    panel.setLayout(new BorderLayout());

    panel.add(text, BorderLayout.NORTH);
    panel.add(service, BorderLayout.EAST);
    panel.add(user, BorderLayout.WEST);
    panel.add(autorized, BorderLayout.SOUTH);

    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }
}
