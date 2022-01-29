package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AvaliablePanel extends JPanel {
    protected AvaliableBanknotesLabel fifty;
    protected AvaliableBanknotesLabel hundred;
    protected AvaliableBanknotesLabel twoHundred;
    protected AvaliableBanknotesLabel fiveHundred;
    protected AvaliableBanknotesLabel thousand;
    protected AvaliableBanknotesLabel totalBanknotes;

    public AvaliablePanel(){
//        this.setBackground(new Color(250, 255, 244));
        this.setLayout(null);
        fifty = new AvaliableBanknotesLabel(20, "Fifty:");
        this.add(fifty);
        hundred = new AvaliableBanknotesLabel(60, "Hundred:");
        this.add(hundred);
        twoHundred = new AvaliableBanknotesLabel(100, "Two hundred:");
        this.add(twoHundred);
        fiveHundred = new AvaliableBanknotesLabel(140, "Five hundred:");
        this.add(fiveHundred);
        thousand = new AvaliableBanknotesLabel(180, "Thousand:");
        this.add(thousand);


        this.totalBanknotes = new AvaliableBanknotesLabel(230,"Total quantity:");
        totalBanknotes.right.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
        totalBanknotes.right.setFont(new Font("", Font.BOLD, 15));
        totalBanknotes.right.setForeground(new Color(175, 65, 55));
        totalBanknotes.right.setHorizontalAlignment(JLabel.RIGHT);
        totalBanknotes.right.setBounds(115, 0, 65, 30);

        totalBanknotes.left.setText("Total quantity:");
        totalBanknotes.left.setFont(new Font("", Font.BOLD, 14));
        totalBanknotes.left.setForeground(new Color(205, 85, 74));
        totalBanknotes.left.setBounds(15, 0, 110, 30);

        this.add(totalBanknotes);

//        totalBanknotesRight.setText(Integer.toString(DBsimulator.getTotalBanknotes()));
//        totalBanknotesRight.setFont(new Font("", Font.BOLD, 15));
//        totalBanknotesRight.setForeground(new Color(175, 65, 55));
//        totalBanknotesRight.setHorizontalAlignment(JLabel.RIGHT);
//        totalBanknotesRight.setBounds(115, 230, 65, 30);
//        JLabel totalBanknotesLeft = new JLabel();
//        totalBanknotesLeft.setText("Total quantity:");
//        totalBanknotesLeft.setFont(new Font("", Font.BOLD, 14));
//        totalBanknotesLeft.setForeground(new Color(205, 85, 74));
//        totalBanknotesLeft.setBounds(15, 230, 110, 30);

    }


    public void setBeckground(Color color){
        this.setBackground(color);
        fifty.setBackground(color);
        hundred.setBackground(color);
        twoHundred.setBackground(color);
        fiveHundred.setBackground(color);
        thousand.setBackground(color);
        totalBanknotes.setBackground(color);
    }
}
