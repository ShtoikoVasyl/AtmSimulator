package edu.shtoiko.atmsimulator.terminal.serviceframe;

import javax.swing.*;
import java.awt.*;

public class LoadPanel extends JPanel {

    public InputPanel fifty;
    public InputPanel hundred;
    public InputPanel twoHundred;
    public InputPanel fiveHundred;
    public InputPanel thousand;

    public LoadPanel(){
        System.out.println("text");
        this.setLayout(null);

        fifty = new InputPanel(20, "Load banknotes 50");
        this.add(fifty);

    }

@Override
    public void setBackground(Color color){
        super.setBackground(color);
//        if (fifty == null){
//            return;
//        }
            fifty.setBackground(color);
    }

}
