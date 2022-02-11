package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JPanel;

/**
 * main area template panel on TerminalFrame
 */
public class MainTerminalPanel extends JPanel {
    public final static int width = MainFrame.width;
    public final static int height = MainFrame.height - Header.height;

    protected MainTerminalPanel() {
        setBounds(0, Header.height, MainFrame.width, height);
    }
}
