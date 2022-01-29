package edu.shtoiko.atmsimulator.terminal.serviceframe;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    protected JButton inputButton;
    protected JTextField inputField;

    public InputPanel(int horizontal, String text){
        this.setVisible(true);
        this.setLayout(null);
        this.setBounds(0,horizontal,355,30);

        this.inputButton = new JButton();
        inputButton.setBounds(180, 0, 175, 30);
        inputButton.setBackground(new Color(138, 200, 168));
        inputButton.setText(text);

        this.inputField = new JTextField();
        inputField.setBounds(15, 0, 155, 30);
        inputField.setBackground(new Color(250, 255, 244));

        this.add(inputButton);
        this.add(inputField);

    }
}
