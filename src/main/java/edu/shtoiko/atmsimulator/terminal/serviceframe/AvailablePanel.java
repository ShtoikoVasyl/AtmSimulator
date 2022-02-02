package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

/** a panel showing all available banknotes and their total quantity */
public class AvailablePanel extends JPanel {
  protected AvailableBanknotesLabel fifty;
  protected AvailableBanknotesLabel hundred;
  protected AvailableBanknotesLabel twoHundred;
  protected AvailableBanknotesLabel fiveHundred;
  protected AvailableBanknotesLabel thousand;
  protected AvailableBanknotesLabel totalBanknotes;

  public AvailablePanel() {
    setLayout(null);
    fifty = new AvailableBanknotesLabel(20, "Fifty:", "fifty");
    add(fifty);
    hundred = new AvailableBanknotesLabel(60, "Hundred:", "hundred");
    add(hundred);
    twoHundred = new AvailableBanknotesLabel(100, "Two hundred:", "twoHundred");
    add(twoHundred);
    fiveHundred = new AvailableBanknotesLabel(140, "Five hundred:", "fiveHundred");
    add(fiveHundred);
    thousand = new AvailableBanknotesLabel(180, "Thousand:", "thousand");
    add(thousand);
    totalBanknotes = new AvailableBanknotesLabel(230, "Total quantity:", "totalQuantity");
    totalBanknotes.right.setText(Integer.toString(DataWarehouseInterface.getTotalBanknotes()));
    totalBanknotes.right.setFont(new Font("", Font.BOLD, 15));
    totalBanknotes.right.setForeground(new Color(175, 65, 55));
    totalBanknotes.right.setHorizontalAlignment(JLabel.RIGHT);
    totalBanknotes.right.setBounds(115, 0, 65, 30);
    totalBanknotes.left.setText("Total quantity:");
    totalBanknotes.left.setFont(new Font("", Font.BOLD, 14));
    totalBanknotes.left.setForeground(new Color(205, 85, 74));
    totalBanknotes.left.setBounds(15, 0, 110, 30);
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
