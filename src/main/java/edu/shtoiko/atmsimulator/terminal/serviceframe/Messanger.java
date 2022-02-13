package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;

import javax.swing.JLabel;
import java.awt.Font;

/** Message line */
public class Messanger extends JLabel {
  public Messanger() {
    setText("Welcome, you authorized as service personal.");
    setHorizontalAlignment(JLabel.CENTER);
    setBounds(
        ServicePersonTerminal.indentations,
        ServicePersonTerminal.indentations,
        MainFrame.width - ServicePersonTerminal.indentations / 2,
        ServicePersonTerminal.indentations * 2);
    setFont(new Font("", Font.BOLD, MainFrame.fontSize + 1));
  }
}
