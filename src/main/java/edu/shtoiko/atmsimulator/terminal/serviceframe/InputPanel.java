package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

/** a panel that contains an input field and a button to load banknotes */
public class InputPanel extends JPanel {
  public static final int width = LoadPanel.width - (ServicePersonTerminal.indentations * 3) / 2;
  protected JButton inputButton;
  protected JTextField inputField;

  public InputPanel(int horizontal, String text) {
    setVisible(true);
    setLayout(null);
    setBounds(0, horizontal, width, ServicePersonTerminal.indentations * 2);
    inputButton = new JButton();
    inputButton.setBounds(
        width / 7 * 3,
        0,
        width / 7 * 4 - ServicePersonTerminal.indentations,
        ServicePersonTerminal.indentations * 2);
    inputButton.setBackground(new Color(138, 200, 168));
    inputButton.setText(text);
    inputButton.setFont(new Font("", Font.BOLD, MainFrame.fontSize));
    inputField = new JTextField();
    inputField.setBounds(
        ServicePersonTerminal.indentations,
        0,
        width / 7 * 3 - ServicePersonTerminal.indentations * 2,
        ServicePersonTerminal.indentations * 2);
    inputField.setBackground(new Color(250, 255, 244));
    inputField.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 1));
    add(inputButton);
    add(inputField);
  }
}
