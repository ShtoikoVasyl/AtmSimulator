package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.MainTerminalPanel;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.dataprocessing.GetResource;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

/** a panel that displays an interface for loading banknotes of different denominations */
public class LoadPanel extends JPanel {
  public static final int width = MainTerminalPanel.width / 5 * 3;
  public static final int height = MainTerminalPanel.height / 5 * 3;
  final int maxTotalBanknotes = 5000;
  protected InputPanel fifty;
  protected InputPanel hundred;
  protected InputPanel twoHundred;
  protected InputPanel fiveHundred;
  protected InputPanel thousand;
  protected JLabel loadToMaxLeft;

  public LoadPanel() {
    setLayout(null);
    setBounds(
        AvailablePanel.width + ServicePersonTerminal.indentations / 2,
        ServicePersonTerminal.indentations * 4,
        width - (ServicePersonTerminal.indentations * 3) / 2,
        height);
    fifty = new InputPanel(height / 7 - ServicePersonTerminal.indentations, "Load banknotes 50");
    add(fifty);
    hundred =
        new InputPanel(height / 7 * 2 - ServicePersonTerminal.indentations, "Load banknotes 100");
    add(hundred);
    twoHundred =
        new InputPanel(height / 7 * 3 - ServicePersonTerminal.indentations, "Load banknotes 200");
    add(twoHundred);
    fiveHundred =
        new InputPanel(height / 7 * 4 - ServicePersonTerminal.indentations, "Load banknotes 500");
    add(fiveHundred);
    thousand =
        new InputPanel(height / 7 * 5 - ServicePersonTerminal.indentations, "Load banknotes 1000");
    add(thousand);
    loadToMaxLeft = new JLabel();
    loadToMaxLeft.setText(
        Integer.toString(maxTotalBanknotes - new GetResource().getTotalBanknotes()));
    loadToMaxLeft.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 5));
    loadToMaxLeft.setBounds(15, height / 7 * 6, 130, 30);
    JLabel loadToMaxRight = new JLabel();
    loadToMaxRight.setText("can be loaded");
    loadToMaxRight.setHorizontalAlignment(JLabel.RIGHT);
    loadToMaxRight.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 5));
    loadToMaxRight.setBounds(145, height / 7 * 6, 210, 30);
    add(loadToMaxLeft);
    add(loadToMaxRight);
  }

  /** set panel background and their input panels */
  public void setBackgroundColor(Color color) {
    super.setBackground(color);
    fifty.setBackground(color);
    hundred.setBackground(color);
    twoHundred.setBackground(color);
    fiveHundred.setBackground(color);
    thousand.setBackground(color);
  }

  /** returns the maximum number of banknotes that can still be loaded */
  public int getMaxTotalBanknotes() {
    return maxTotalBanknotes;
  }
}
