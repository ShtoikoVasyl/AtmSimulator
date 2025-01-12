package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.Header;

import javax.swing.JPanel;

/** main area template panel on TerminalFrame */
public class MainTerminalPanel extends JPanel {
    public static final int width = MainFrame.SCREEN_WIDTH;
    public static final int height = MainFrame.SCREEN_HEIGHT - Header.height;

    protected MainTerminalPanel() {
        setBounds(0, Header.height, MainFrame.SCREEN_WIDTH, height);
    }
}
