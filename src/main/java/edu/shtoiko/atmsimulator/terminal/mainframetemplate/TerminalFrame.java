package edu.shtoiko.atmsimulator.terminal.mainframetemplate;

import javax.swing.*;

/** terminal frame template*/
public class TerminalFrame extends JFrame {
  public MainTerminalPanel mainPanel;

  public TerminalFrame() {
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setBounds(300, 100, 615, 600);
    this.setResizable(false);
    this.setVisible(true);
    this.setLayout(null);
    this.mainPanel = new MainTerminalPanel();
    this.add(mainPanel);
    this.add(new Header());
  }
}
