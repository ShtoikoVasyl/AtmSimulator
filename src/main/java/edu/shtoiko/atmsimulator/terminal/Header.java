package edu.shtoiko.atmsimulator.terminal;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel{

    protected Header() {
        this.setBounds(0, 0, 615, 125);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        JLabel logo = new JLabel(new ImageIcon("src/bankLogo.jpg"));
        logo.setBounds(35, 15, 300, 100);
        this.add(logo);
    }
}
