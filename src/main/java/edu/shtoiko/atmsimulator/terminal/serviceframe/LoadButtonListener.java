package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.AtmLoader;
import edu.shtoiko.atmsimulator.datawarehouse.StorageProvider;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** the class responsible for loading banknotes after pressing the button */
public class LoadButtonListener implements ActionListener {
    InputPanel inputPanel;
    LoadPanel loadPanel;
    AvailablePanel availablePanel;
    AvailableBanknotesLabel availableBanknotesLabel;
    JLabel lastMessage;
    String text;
    StorageProvider dataWarehouseController;
    AtmLoader atmLoader;

    public LoadButtonListener(
        AvailablePanel availablePanel,
        AvailableBanknotesLabel availableBanknotesLabel,
        LoadPanel loadPanel,
        InputPanel inputPanel,
        JLabel lastMessage,
        String text, StorageProvider dataWarehouseController) {
        this.dataWarehouseController = dataWarehouseController;
        this.inputPanel = inputPanel;
        this.availablePanel = availablePanel;
        this.loadPanel = loadPanel;
        this.lastMessage = lastMessage;
        this.availableBanknotesLabel = availableBanknotesLabel;
        this.text = text;
        atmLoader = new AtmLoader();
    }

    /**
     * after clicking the button, the appropriate changes are made to the
     * availablePanel, loadPanel, database and set a message
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int totalQuantity = dataWarehouseController.getResourcesByValueNames().values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
        String input = inputPanel.inputField.getText();
        int sum = Integer.parseInt(input);
        if (atmLoader.loadAtm(sum, availableBanknotesLabel.getName(), dataWarehouseController)) {
            lastMessage.setText("You load " + sum + " banknotes of " + text + " denomination.");
            lastMessage.setForeground(Color.BLACK);
        } else {
            lastMessage.setText("ERROR");
            lastMessage.setForeground(new Color(205, 85, 74));
        }
        inputPanel.inputField.setText("");
        availableBanknotesLabel.setQuantity(
            Integer
                .toString(dataWarehouseController.getResourcesByValueNames().get(availableBanknotesLabel.getName())));
        availablePanel.totalBanknotes.setQuantity(Integer.toString(totalQuantity));
        loadPanel.loadToMaxLeft.setText(
            Integer.toString(loadPanel.getMaxTotalBanknotes() - totalQuantity));
    }
}
