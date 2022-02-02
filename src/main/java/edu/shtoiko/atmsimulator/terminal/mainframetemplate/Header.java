package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.JComponent;
import javax.swing.JPanel;
//import java.awt.Paint;
//import java.awt.Container;
import java.awt.Color;

/** frame header template */
public class Header extends JPanel{
    protected Header() {
        setBounds(0, 0, 615, 125);
        setBackground(Color.WHITE);
        setLayout(null);
        JLabel logo = new JLabel(new ImageIcon(""));
        logo.setBounds(35, 15, 300, 100);
        add(logo);
    }
}
