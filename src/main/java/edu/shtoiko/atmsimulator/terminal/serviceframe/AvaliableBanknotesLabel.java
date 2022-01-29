package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.datawarehouse.DBsimulator;

import javax.swing.*;
import java.awt.*;

public class AvaliableBanknotesLabel extends JPanel {
    protected String text;
    protected JLabel right;
    protected JLabel left;
    public AvaliableBanknotesLabel(int vertical, String text){
        this.setLayout(null);
        this.setBounds(0,vertical,180,30);
        this.text = text;
        this.right = new JLabel();
        right.setBounds(115,0,65,30);
        right.setText(Integer.toString(DBsimulator.getFifty()));
        right.setHorizontalAlignment(JLabel.RIGHT);

        this.left = new JLabel();
        left.setText(text);
        left.setBounds(15,0,100,30);
        left.setForeground(new Color(127, 127, 127));
        this.add(left);
        this.add(right);
    }

    public void setQuantity(String text){
        this.right.setText(text);
    }
}
