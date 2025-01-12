package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.Header;

import javax.swing.*;

/** terminal frame template */
public class TerminalFrame extends JFrame {
    public static final int width = MainFrame.SCREEN_WIDTH;
    public static final int height = MainFrame.SCREEN_HEIGHT;
    private MainTerminalPanel mainPanel;
    private final ContextHolder contextHolder;
    private Header header;

    public TerminalFrame(ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
        this.header = new Header(contextHolder);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(
            MainFrame.SCREEN_WIDTH / 2,
            (MainFrame.GRAPHICS_DEVICE.getDisplayMode().getHeight() - MainFrame.SCREEN_HEIGHT) / 2,
            width,
            height);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        add(header);
        mainPanel = new MainTerminalPanel();
        add(mainPanel);
    }

    public MainTerminalPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainTerminalPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
