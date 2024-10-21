package edu.shtoiko.atmsimulator.terminal.userframe;

import edu.shtoiko.atmsimulator.terminal.listeners.TerminalWindowListener;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.Header;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * the user frame, which allows you to withdraw money, shows the quantity of banknotes that are
 * displayed and changes to the database
 */
public class UserTerminal {

    /**
     * Setting indents
     */
    public final static int indentations = MainFrame.width / 40;
    int width = MainFrame.width;
    int height = MainFrame.height;
    private ContextHolder contextHolder;
    public UserTerminal(JFrame superFrame, ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
        TerminalFrame userFrame = new TerminalFrame();
        userFrame.addWindowListener(new TerminalWindowListener(superFrame));
        userFrame.setTitle("User terminal");
        JLabel lastMessage = new JLabel();
        lastMessage.setText("Welcome, you authorized as 'USER_NAME'.");
        lastMessage.setHorizontalAlignment(JLabel.CENTER);
        lastMessage.setBounds(indentations, indentations / 2, width / 3 * 2 - indentations * 2, indentations * 2);
        lastMessage.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 3));
        String message =
                ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: "
                        + contextHolder.getDataWarehouseController().getAvailableBanknotes().keySet().stream()
                        .sorted()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                        + "</div></html>");
        JLabel text = new JLabel("", SwingConstants.CENTER);
        text.setText(message);
        text.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 3));
        text.setBounds(indentations, indentations * 3, width / 3 * 2 - indentations * 2, indentations * 4);
        JTextField inputSum = new JTextField(5);
        inputSum.setBounds(width / 6, indentations * 8, width / 3, indentations * 3);
        inputSum.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 9));
        inputSum.setHorizontalAlignment(JTextField.CENTER);
        JButton get = new JButton();
        get.setText("Get money");
        get.setFont(new Font("", Font.BOLD, MainFrame.fontSize + 5));
        get.setBackground(new Color(138, 200, 168));
        get.setBounds(width / 6 + indentations, indentations * 13, width / 3 - indentations * 2, indentations * 4);
        get.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input = inputSum.getText();
                        int sum = Integer.parseInt(input);

                        Map<String, Integer> result = contextHolder.getControllerInterface().withdrawRequest(contextHolder.getDataWarehouseController().getResources(), sum);
                        String messageUpdate = "Withdraw complete";
                        JOptionPane.showMessageDialog(
                                new JPanel(),
                                "withdraw: \n" + result.toString().replaceAll("[{}]", "")
                        );
                        takeOutBanknotes(result);
                        String message =
                                ("<html><div style= 'text-align: center;'>What amount do you want to get?<br>Available banknotes: "
                                        + contextHolder.getDataWarehouseController().getAvailableBanknotes().keySet().stream()
                                        .sorted()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", "))
                                        + "</div></html>");
                        text.setText(message);
                    }
                });
        userFrame.mainPanel.setBackground(new Color(250, 255, 244));
        userFrame.mainPanel.setLayout(null);
        userFrame.mainPanel.add(CreateWithdrawPanel(text, inputSum, get, lastMessage));
    }

    private boolean takeOutBanknotes(Map<String, Integer> banknotesMap){
        banknotesMap.forEach((name, value) -> contextHolder.getDataWarehouseController().takeOutByName(name, value));
        return true;
    }

    /**
     * Create main panel
     *
     * @param text        welcome message and display of available banknotes
     * @param inputSum    field to input request sum
     * @param get         button to start withdraw
     * @param lastMessage label to last message
     * @return JPanel
     */
    protected JPanel CreateWithdrawPanel(
            JLabel text, JTextField inputSum, JButton get, JLabel lastMessage) {
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBackground(new Color(240, 240, 240));
        withdrawPanel.setBounds(width / 6, 0, width / 3 * 2, height - Header.height * 2);
        withdrawPanel.setLayout(null);
        withdrawPanel.add(text);
        withdrawPanel.add(inputSum);
        withdrawPanel.add(get);
        withdrawPanel.add(lastMessage);
        return withdrawPanel;
    }
}
