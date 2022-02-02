package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DataWarehouseInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

/** a panel that displays an interface for loading banknotes of different denominations */
public class LoadPanel extends JPanel {
    protected InputPanel fifty;
    protected InputPanel hundred;
    protected InputPanel twoHundred;
    protected InputPanel fiveHundred;
    protected InputPanel thousand;
    protected JLabel loadToMaxLeft;
    final int maxTotalBanknotes = 5000;
    public LoadPanel(){
        this.setLayout(null);
        fifty = new InputPanel(20, "Load banknotes 50");
        this.add(fifty);
        hundred = new InputPanel(60, "Load banknotes 100");
        this.add(hundred);
        twoHundred = new InputPanel(100, "Load banknotes 200");
        this.add(twoHundred);
        fiveHundred = new InputPanel(140, "Load banknotes 500");
        this.add(fiveHundred);
        thousand = new InputPanel(180, "Load banknotes 1000");
        this.add(thousand);
        this.loadToMaxLeft = new JLabel();
            loadToMaxLeft.setText(Integer.toString(maxTotalBanknotes - DataWarehouseInterface.getTotalBanknotes()));
            loadToMaxLeft.setFont(new Font("", Font.BOLD, 15));
            loadToMaxLeft.setBounds(15, 230, 130, 30);
        JLabel loadToMaxRight = new JLabel();
            loadToMaxRight.setText("can be loaded");
            loadToMaxRight.setHorizontalAlignment(JLabel.RIGHT);
            loadToMaxRight.setFont(new Font("", Font.BOLD, 15));
            loadToMaxRight.setBounds(145, 230, 210, 30);
        this.add(loadToMaxLeft);
        this.add(loadToMaxRight);
    }

    /** set panel background and their input panels */
    public void setBackgroundColor(Color color){
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
