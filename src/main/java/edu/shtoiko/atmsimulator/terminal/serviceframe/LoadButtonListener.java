package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.ATMloading;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;
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
    public LoadButtonListener(AvailablePanel availablePanel, AvailableBanknotesLabel availableBanknotesLabel, LoadPanel loadPanel, InputPanel inputPanel, JLabel lastMessage, String text){
        this.inputPanel = inputPanel;
        this.availablePanel = availablePanel;
        this.loadPanel = loadPanel;
        this.lastMessage = lastMessage;
        this.availableBanknotesLabel = availableBanknotesLabel;
        this.text = text;
    }

    /** after clicking the button,
     * the appropriate changes are made to the availablePanel, loadPanel, database and set a message*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputPanel.inputField.getText();
        int sum = Integer.parseInt(input);
        int[] load = new int[5];
        DBcontroller.loadBanknotes(load, sum, availableBanknotesLabel.name);
        ATMloading loading = new ATMloading();
        if (loading.ATMload(load)) {
            lastMessage.setText("You load " + sum + " banknotes of " + text +" denomination.");
            lastMessage.setForeground(Color.BLACK);
        } else {
            lastMessage.setText("ERROR");
            lastMessage.setForeground(new Color(205, 85, 74));
        }
        inputPanel.inputField.setText("");
        availableBanknotesLabel.setQuantity(Integer.toString(DBcontroller.GetBanknotesQuantity(availableBanknotesLabel.name)));
        availablePanel.totalBanknotes.setQuantity(Integer.toString(DataWarehouseInterface.getTotalBanknotes()));
        loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DataWarehouseInterface.getTotalBanknotes()));
    }
}
