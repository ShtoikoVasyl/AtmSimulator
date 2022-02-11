package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * terminal frame template
 */
public class TerminalFrame extends JFrame {
    public final static int width = MainFrame.width;
    public final static int height = MainFrame.height;
    public MainTerminalPanel mainPanel;

    public TerminalFrame() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(MainFrame.width / 2, (MainFrame.gd.getDisplayMode().getHeight() - MainFrame.height) / 2,
                width, height);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        add(new Header());
        mainPanel = new MainTerminalPanel();
        add(mainPanel);
    }
}
