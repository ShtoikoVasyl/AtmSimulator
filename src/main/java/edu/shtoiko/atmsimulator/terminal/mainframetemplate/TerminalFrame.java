package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/** terminal frame template*/
public class TerminalFrame extends JFrame {
  public MainTerminalPanel mainPanel;

  public TerminalFrame() {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setBounds(300, 100, 615, 600);
    setResizable(false);
    setVisible(true);
    setLayout(null);
    mainPanel = new MainTerminalPanel();
    add(mainPanel);
    add(new Header());
  }
}
