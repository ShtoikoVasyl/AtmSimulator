package edu.shtoiko.atmsimulator.terminal.serviceframe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

/** panel used to display available banknotes on the available panel */
public class AvailableBanknotesLabel extends JPanel {
  protected String name;
  protected String text;
  protected JLabel right;
  protected JLabel left;

  public AvailableBanknotesLabel(int vertical, String text, String name) {
    this.name = name;
    setLayout(null);
    setBounds(0, vertical, 180, 30);
    this.text = text;
    right = new JLabel();
    right.setBounds(115, 0, 65, 30);
    right.setText(Integer.toString(DBcontroller.GetBanknotesQuantity(this.name)));
    right.setHorizontalAlignment(JLabel.RIGHT);
    left = new JLabel();
    left.setText(text);
    left.setBounds(15, 0, 100, 30);
    left.setForeground(new Color(127, 127, 127));
    add(left);
    add(right);
  }

  /** set text with a quantity of banknotes */
  public void setQuantity(String text) {
    right.setText(text);
  }
}
