package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

/** panel used to display available banknotes on the available panel */
public class AvailableBanknotesLabel extends JPanel {
  public static final int width =
      AvailablePanel.width - (ServicePersonTerminal.indentations * 3) / 2;
  private final String name;
  private final JLabel right;
  private final JLabel left;

  public AvailableBanknotesLabel(int vertical, String text, String name, Color color) {
    this.setBackground(color);
    this.name = name;
    setLayout(null);
    setBounds(0, vertical, width, ServicePersonTerminal.indentations * 2);
    right = new JLabel();
    right.setBounds(
        width / 3 * 2 - ServicePersonTerminal.indentations,
        0,
        width / 3,
        ServicePersonTerminal.indentations * 2);
    right.setHorizontalAlignment(JLabel.RIGHT);
    right.setFont(new Font("", Font.BOLD, MainFrame.fontSize));
    left = new JLabel();
    left.setText(text);
    left.setFont(new Font("", Font.BOLD, MainFrame.fontSize));
    left.setBounds(
        ServicePersonTerminal.indentations,
        0,
        width / 3 * 2 - ServicePersonTerminal.indentations * 2,
        ServicePersonTerminal.indentations * 2);

    left.setForeground(new Color(127, 127, 127));
    add(left);
    add(right);
  }

  @Override
  public String getName() {
    return name;
  }

  public JLabel getRight() {
    return right;
  }

  public JLabel getLeft() {
    return left;
  }

  /** set text with a quantity of banknotes */
  public void setQuantity(String text) {
    right.setText(text);
  }
}
