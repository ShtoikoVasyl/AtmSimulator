package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.ATMloading;
import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadButtonListener implements ActionListener {
    InputPanel inputPanel;
    LoadPanel loadPanel;
    AvaliablePanel avaliablePanel;
    AvaliableBanknotesLabel avaliableBanknotesLabel;
    JLabel lastMessage;
    String text;


    public LoadButtonListener( AvaliablePanel avaliablePanel,AvaliableBanknotesLabel avaliableBanknotesLabel,  LoadPanel loadPanel, InputPanel inputPanel, JLabel lastMessage, String text){
        this.inputPanel = inputPanel;
        this.avaliablePanel = avaliablePanel;
        this.loadPanel = loadPanel;
        this.lastMessage = lastMessage;
        this.avaliableBanknotesLabel = avaliableBanknotesLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputPanel.inputField.getText();
        int sum = Integer.parseInt(input);
        int[] load = new int[5];

        load = DBcontroller.loadBanknotes(load, sum, avaliableBanknotesLabel.name);

        ATMloading loading = new ATMloading();
        if (loading.ATMload(load)) {
            lastMessage.setText("You load " + sum + " banknotes of " + text +" denomination.");
            lastMessage.setForeground(Color.BLACK);
        } else {
            lastMessage.setText("ERROR");
            lastMessage.setForeground(new Color(205, 85, 74));
        }
        inputPanel.inputField.setText("");
        avaliableBanknotesLabel.setQuantity(Integer.toString(DBcontroller.GetBanknotesQuantity(avaliableBanknotesLabel.name)));
        avaliablePanel.totalBanknotes.setQuantity(Integer.toString(DBsimulator.getTotalBanknotes()));
        loadPanel.loadToMaxLeft.setText(
                Integer.toString(loadPanel.getMaxTotalBanknotes() - DBsimulator.getTotalBanknotes()));
    }

}
