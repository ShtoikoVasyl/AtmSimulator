package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.controllers.currencyes.Currency;
import edu.shtoiko.atmsimulator.controllers.currencyes.UAH;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseController;
import edu.shtoiko.atmsimulator.datawarehouse.StorageProvider;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.MainTerminalPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** a panel that displays an interface for loading banknotes of different denominations */
public class LoadPanel extends JPanel {
  public static final int width = MainTerminalPanel.width / 5 * 3;
  public static final int height = MainTerminalPanel.height / 5 * 3;
  final int maxTotalBanknotes = 5000;
  protected JLabel loadToMaxLeft;
  protected Color color = new Color(255, 255, 255);
  private Map<String, Integer> availableBanknotes;
  public LoadPanel(AvailablePanel availablePanel, StorageProvider dataWarehouseController, Currency currency, Messanger messanger) {
    availableBanknotes = dataWarehouseController.getResources();
    setLayout(null);
    setBounds(
        AvailablePanel.width + ServicePersonTerminal.indentations / 2,
        ServicePersonTerminal.indentations * 4,
        width - (ServicePersonTerminal.indentations * 3) / 2,
        height);
    int i = 1;
    List<String> available = availableBanknotes.keySet().stream().sorted(currency::compareBanknotes).collect(Collectors.toList());
    for(String name : available){
      InputPanel inputPanel = new InputPanel(height / (available.size() + 2) * i - ServicePersonTerminal.indentations, "Load " + name);
      inputPanel.setBackground(color);
      inputPanel.inputButton.addActionListener(
              new LoadButtonListener(
                      availablePanel,
                      availablePanel.getLabels().get(i - 1),
                      this,
                      inputPanel,
                      messanger,
                      name, dataWarehouseController));
      add(inputPanel);
      i++;
    }
    setBackground(color);
    loadToMaxLeft = new JLabel();
    loadToMaxLeft.setText(
        Integer.toString(maxTotalBanknotes - dataWarehouseController.getTotalQuantity()));
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

  /** returns the maximum number of banknotes that can still be loaded */
  public int getMaxTotalBanknotes() {
    return maxTotalBanknotes;
  }
}
