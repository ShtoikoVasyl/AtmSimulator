package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * frame header template
 */
public class Header extends JPanel {
    public static int height = MainFrame.height / 5;

    protected Header() {
        setBounds(0, 0, MainFrame.width, height);
        setBackground(Color.WHITE);
        setLayout(null);
    }
}
