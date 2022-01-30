package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;
import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

import javax.swing.*;
import java.awt.*;

public class AvailablePanel extends JPanel {
    protected AvailableBanknotesLabel fifty;
    protected AvailableBanknotesLabel hundred;
    protected AvailableBanknotesLabel twoHundred;
    protected AvailableBanknotesLabel fiveHundred;
    protected AvailableBanknotesLabel thousand;
    protected AvailableBanknotesLabel totalBanknotes;

    public AvailablePanel(){
        this.setLayout(null);
        fifty = new AvailableBanknotesLabel(20, "Fifty:", "fifty");
        this.add(fifty);
        hundred = new AvailableBanknotesLabel(60, "Hundred:", "hundred");
        this.add(hundred);
        twoHundred = new AvailableBanknotesLabel(100, "Two hundred:", "twoHundred");
        this.add(twoHundred);
        fiveHundred = new AvailableBanknotesLabel(140, "Five hundred:", "fiveHundred");
        this.add(fiveHundred);
        thousand = new AvailableBanknotesLabel(180, "Thousand:", "thousand");
        this.add(thousand);
        this.totalBanknotes = new AvailableBanknotesLabel(230,"Total quantity:", "totalQuantity");
        totalBanknotes.right.setText(Integer.toString(DataWarehouseInterface.getTotalBanknotes()));
        totalBanknotes.right.setFont(new Font("", Font.BOLD, 15));
        totalBanknotes.right.setForeground(new Color(175, 65, 55));
        totalBanknotes.right.setHorizontalAlignment(JLabel.RIGHT);
        totalBanknotes.right.setBounds(115, 0, 65, 30);
        totalBanknotes.left.setText("Total quantity:");
        totalBanknotes.left.setFont(new Font("", Font.BOLD, 14));
        totalBanknotes.left.setForeground(new Color(205, 85, 74));
        totalBanknotes.left.setBounds(15, 0, 110, 30);
        this.add(totalBanknotes);
    }


    public void setBackgroundColor(Color color){
        this.setBackground(color);
        fifty.setBackground(color);
        hundred.setBackground(color);
        twoHundred.setBackground(color);
        fiveHundred.setBackground(color);
        thousand.setBackground(color);
        totalBanknotes.setBackground(color);
    }
}
