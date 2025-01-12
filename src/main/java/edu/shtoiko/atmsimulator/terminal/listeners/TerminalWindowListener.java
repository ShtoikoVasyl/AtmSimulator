package edu.shtoiko.atmsimulator.terminal.listeners;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/** Class implements the listener interface for receiving window events */
public class TerminalWindowListener implements WindowListener {
    JFrame superFrame;

    /**
     * @param superFrame the super frame to provide visibility after closing the
     *                   window
     */
    public TerminalWindowListener(JFrame superFrame) {
        this.superFrame = superFrame;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    /** to do visible superFrame */
    @Override
    public void windowClosing(WindowEvent e) {
        superFrame.setVisible(true);
    }

    /** to do visible superFrame */
    @Override
    public void windowClosed(WindowEvent e) {
        superFrame.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
