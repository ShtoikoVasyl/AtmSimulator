package edu.shtoiko.atmsimulator.terminal.serviceframe;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

/** a panel that contains an input field and a button to load banknotes */
public class InputPanel extends JPanel {
  protected JButton inputButton;
  protected JTextField inputField;

  public InputPanel(int horizontal, String text) {
    setVisible(true);
    setLayout(null);
    setBounds(0, horizontal, 355, 30);
    inputButton = new JButton();
    inputButton.setBounds(180, 0, 175, 30);
    inputButton.setBackground(new Color(138, 200, 168));
    inputButton.setText(text);
    inputField = new JTextField();
    inputField.setBounds(15, 0, 155, 30);
    inputField.setBackground(new Color(250, 255, 244));
    add(inputButton);
    add(inputField);
  }
}
