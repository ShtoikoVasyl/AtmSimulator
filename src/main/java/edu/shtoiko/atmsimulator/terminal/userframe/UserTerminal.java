package edu.shtoiko.atmsimulator.terminal.userframe;

import edu.shtoiko.atmsimulator.exception.WithdrawException;
import edu.shtoiko.atmsimulator.terminal.listeners.TerminalWindowListener;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.header.Header;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTerminal {

    private static final int INDENTATIONS = MainFrame.SCREEN_WIDTH / 40;
    private final int width = MainFrame.SCREEN_WIDTH;
    private final int height = MainFrame.SCREEN_HEIGHT;
    private final ContextHolder contextHolder;

    public UserTerminal(JFrame superFrame, ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
        TerminalFrame userFrame = new TerminalFrame(contextHolder);
        userFrame.addWindowListener(new TerminalWindowListener(superFrame));
        userFrame.setTitle("User Terminal");

        JLabel lastMessage = createLabel("<html><div style='text-align: center;'>Welcome to the user terminal,<br>" +
            "here you can withdraw funds from your account</div></html>",
            INDENTATIONS, INDENTATIONS, width / 3 * 2 - INDENTATIONS * 2, INDENTATIONS * 2,
            MainFrame.FONT_SIZE + 3);

        JLabel text = createLabel(generateBanknoteMessage(), INDENTATIONS, INDENTATIONS * 12,
            width / 3 * 2 - INDENTATIONS * 2, INDENTATIONS * 4, MainFrame.FONT_SIZE + 3);

        JLabel textSetNumber = createLabel("Input account number", INDENTATIONS, INDENTATIONS * 5 / 2,
            width / 3 * 2 - INDENTATIONS * 2, INDENTATIONS * 4, MainFrame.FONT_SIZE + 3);

        JTextField inputAccountNumber = createTextField("4145510513397250", width / 6, INDENTATIONS * 6,
            width / 3, INDENTATIONS * 2, MainFrame.FONT_SIZE + 7);

        JLabel textSetPin = createLabel("Input pin", INDENTATIONS, INDENTATIONS * 7,
            width / 3 * 2 - INDENTATIONS * 2, INDENTATIONS * 4, MainFrame.FONT_SIZE + 3);

        JTextField inputAccountPin = createTextField("1111", width / 6, INDENTATIONS * 10,
            width / 3, INDENTATIONS * 2, MainFrame.FONT_SIZE + 7);

        JTextField inputSum = createTextField("", width / 6, INDENTATIONS * 15,
            width / 3, INDENTATIONS * 3, MainFrame.FONT_SIZE + 9);

        JButton getButton = createButton("Get money", width / 6 + INDENTATIONS, INDENTATIONS * 19,
            width / 3 - INDENTATIONS * 2, INDENTATIONS * 4, MainFrame.FONT_SIZE + 5, new Color(138, 200, 168));

        getButton.addActionListener(e -> handleWithdrawAction(inputSum, inputAccountNumber, inputAccountPin, text));

        userFrame.getMainPanel().setBackground(new Color(250, 255, 244));
        userFrame.getMainPanel().setLayout(null);
        userFrame.getMainPanel()
            .add(createWithdrawPanel(text, inputSum, getButton, lastMessage, textSetNumber, textSetPin,
                inputAccountPin, inputAccountNumber));
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("", Font.BOLD, fontSize));
        return label;
    }

    private JTextField createTextField(String defaultText, int x, int y, int width, int height, int fontSize) {
        JTextField textField = new JTextField(defaultText);
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("", Font.BOLD, fontSize));
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height, int fontSize, Color background) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(background);
        return button;
    }

    private String generateBanknoteMessage() {
        return "<html><div style='text-align: center;'>What amount do you want to get?<br>Available banknotes: " +
            contextHolder.getDataWarehouseController().getAvailableBanknotes().keySet().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
            +
            "</div></html>";
    }

    private void handleWithdrawAction(JTextField inputSum, JTextField inputAccountNumber, JTextField inputAccountPin,
        JLabel text) {
        try {
            int sum = Integer.parseInt(inputSum.getText());
            if (sum == 0) {
                throw new NumberFormatException();
            }

            long accountNumber = Long.parseLong(inputAccountNumber.getText());
            short pin = Short.parseShort(inputAccountPin.getText());

            Map<String, Integer> result = contextHolder.getWithdrawService().withdrawRequest(
                contextHolder.getDataWarehouseController().getResourcesByValueNames(), sum);

            contextHolder.getTerminalServiceClient().withdraw(accountNumber, pin, sum,
                contextHolder.getCurrency().getCurrencyCode());

            JOptionPane.showMessageDialog(new JPanel(), "Withdraw successful: \n" +
                result.toString().replaceAll("[{}]", ""));
            takeOutBanknotes(result);
            text.setText(generateBanknoteMessage());

        } catch (WithdrawException ex) {
            JOptionPane.showMessageDialog(new JPanel(), ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JPanel(), "Invalid input. Please enter valid numbers.");
        }
    }

    private boolean takeOutBanknotes(Map<String, Integer> banknotesMap) {
        banknotesMap.forEach((name, value) -> contextHolder.getDataWarehouseController().takeOutByName(name, value));
        return true;
    }

    protected JPanel createWithdrawPanel(JLabel text, JTextField inputSum, JButton getButton, JLabel lastMessage,
        JLabel textSetNumber, JLabel textSetPin, JTextField inputAccountPin,
        JTextField inputAccountNumber) {
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBackground(new Color(240, 240, 240));
        withdrawPanel.setBounds(width / 6, 0, width / 3 * 2, height - Header.height * 2);
        withdrawPanel.setLayout(null);
        withdrawPanel.add(text);
        withdrawPanel.add(inputSum);
        withdrawPanel.add(getButton);
        withdrawPanel.add(lastMessage);
        withdrawPanel.add(textSetNumber);
        withdrawPanel.add(textSetPin);
        withdrawPanel.add(inputAccountPin);
        withdrawPanel.add(inputAccountNumber);
        return withdrawPanel;
    }
}