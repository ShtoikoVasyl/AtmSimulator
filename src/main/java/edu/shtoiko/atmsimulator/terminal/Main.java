package edu.shtoiko.atmsimulator.terminal;

import edu.shtoiko.atmsimulator.terminal.serviceframe.ServicePersonTerminal;
import edu.shtoiko.atmsimulator.terminal.userframe.UserTerminal;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class
 * @deprecated must be rewritten when to be an authorizations
 */
public class Main {
  public static void main(String[] args)
      throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
          IllegalAccessException {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {

    JFrame mainFrame = new JFrame("ATM");

    mainFrame.setBounds(300, 100, 300, 300);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setLayout(new BorderLayout());
    ButtonGroup choice = new ButtonGroup();
    JRadioButton user = new JRadioButton("User", true);
    choice.add(user);
    JRadioButton service = new JRadioButton("Service person", false);
    choice.add(service);
    String message = "You want authorithed as..";
    JLabel text = new JLabel();
    text.setText(message);

    /**
     * a button which, depending on the conditions, creates an object UserFrame or ServicePersonalFrame
     */
    JButton autorized = new JButton();
    autorized.setText("Autorization");
    autorized.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (user.isSelected()) {
              text.setText(message + "User");
              mainFrame.setVisible(false);
              UserTerminal user = new UserTerminal(mainFrame);
            }
            if (service.isSelected()) {
              text.setText(message + "Service");
              mainFrame.setVisible(false);
              ServicePersonTerminal service = new ServicePersonTerminal(mainFrame);
            }
          }
        });

    JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(text, BorderLayout.NORTH);
        panel.add(service, BorderLayout.EAST);
        panel.add(user, BorderLayout.WEST);
        panel.add(autorized, BorderLayout.SOUTH);
    mainFrame.getContentPane().add(panel);
    mainFrame.setVisible(true);

          }
      });
  }
}
