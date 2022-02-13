package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.MainTerminalPanel;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.dataprocessing.GetResource;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

/** a panel showing all available banknotes and their total quantity */
public class AvailablePanel extends JPanel {
  public static final int width = MainTerminalPanel.width / 5 * 2;
  public static final int height = MainTerminalPanel.height / 5 * 3;
  protected AvailableBanknotesLabel fifty;
  protected AvailableBanknotesLabel hundred;
  protected AvailableBanknotesLabel twoHundred;
  protected AvailableBanknotesLabel fiveHundred;
  protected AvailableBanknotesLabel thousand;
  protected AvailableBanknotesLabel totalBanknotes;

  public AvailablePanel() {
    setLayout(null);
    setBounds(
        ServicePersonTerminal.indentations,
        ServicePersonTerminal.indentations * 4,
        width - (ServicePersonTerminal.indentations * 3) / 2,
        height);
    fifty =
        new AvailableBanknotesLabel(
            height / 7 - ServicePersonTerminal.indentations, "Fifty:", "fifty");
    add(fifty);
    hundred =
        new AvailableBanknotesLabel(
            height / 7 * 2 - ServicePersonTerminal.indentations, "Hundred:", "hundred");
    add(hundred);
    twoHundred =
        new AvailableBanknotesLabel(
            height / 7 * 3 - ServicePersonTerminal.indentations, "Two hundred:", "twoHundred");
    add(twoHundred);
    fiveHundred =
        new AvailableBanknotesLabel(
            height / 7 * 4 - ServicePersonTerminal.indentations, "Five hundred:", "fiveHundred");
    add(fiveHundred);
    thousand =
        new AvailableBanknotesLabel(
            height / 7 * 5 - ServicePersonTerminal.indentations, "Thousand:", "thousand");
    add(thousand);
    totalBanknotes =
        new AvailableBanknotesLabel(height / 7 * 6, "Total quantity:", "totalQuantity");
    totalBanknotes.getRight().setText(Integer.toString(new GetResource().getTotalBanknotes()));
    totalBanknotes.getRight().setFont(new Font("", Font.BOLD, MainFrame.fontSize + 5));
    totalBanknotes.getRight().setForeground(new Color(175, 65, 55));
    totalBanknotes.getRight().setHorizontalAlignment(JLabel.RIGHT);
    totalBanknotes
        .getRight()
        .setBounds(
            width / 3 * 2 - ServicePersonTerminal.indentations * 2,
            0,
            width / 3,
            ServicePersonTerminal.indentations * 2);
    totalBanknotes.getLeft().setText("Total quantity:");
    totalBanknotes.getLeft().setFont(new Font("", Font.BOLD, MainFrame.fontSize + 2));
    totalBanknotes.getLeft().setForeground(new Color(205, 85, 74));
    totalBanknotes
        .getLeft()
        .setBounds(
            ServicePersonTerminal.indentations,
            0,
            width / 3 * 2 - ServicePersonTerminal.indentations * 2,
            ServicePersonTerminal.indentations * 2);
    add(totalBanknotes);
  }

  /** set loadPanel background and their availableLabel */
  public void setBackgroundColor(Color color) {
    setBackground(color);
    fifty.setBackground(color);
    hundred.setBackground(color);
    twoHundred.setBackground(color);
    fiveHundred.setBackground(color);
    thousand.setBackground(color);
    totalBanknotes.setBackground(color);
  }
}
