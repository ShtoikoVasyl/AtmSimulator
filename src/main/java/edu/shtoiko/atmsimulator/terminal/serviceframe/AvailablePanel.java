package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.model.currencyes.Currency;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.MainTerminalPanel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** a panel showing all available banknotes and their total quantity */
public class AvailablePanel extends JPanel {
    public static final int width = MainTerminalPanel.width / 5 * 2;
    public static final int height = MainTerminalPanel.height / 5 * 3;
    protected AvailableBanknotesLabel totalBanknotes;
    private List<AvailableBanknotesLabel> labels;

    public List<AvailableBanknotesLabel> getLabels() {
        return labels;
    }

    public AvailablePanel(Map<String, Integer> availableBanknotes, Currency currency) {
        Color backgroundColor = new Color(250, 255, 244);
        setLayout(null);
        setBounds(
            ServicePersonTerminal.INDENTATIONS,
            ServicePersonTerminal.INDENTATIONS * 4,
            width - (ServicePersonTerminal.INDENTATIONS * 3) / 2,
            height);

        labels = new ArrayList<>();

        int i = 1;
        List<String> available =
            availableBanknotes.keySet().stream().sorted(currency::compareBanknotes).collect(Collectors.toList());
        for (String name : available) {
            AvailableBanknotesLabel label = new AvailableBanknotesLabel(
                height / (availableBanknotes.size() + 2) * i - ServicePersonTerminal.INDENTATIONS,
                name, name, backgroundColor);
            label.setQuantity(String.valueOf(availableBanknotes.get(name)));

            labels.add(label);
            add(label);
            i++;
        }
        totalBanknotes =
            new AvailableBanknotesLabel(height / 7 * 6, "Total quantity:", "totalQuantity", backgroundColor);
        totalBanknotes.getRight().setText(Integer.toString(availableBanknotes.values()
            .stream()
            .mapToInt(Integer::intValue)
            .sum()));
        totalBanknotes.getRight().setFont(new Font("", Font.BOLD, MainFrame.FONT_SIZE + 5));
        totalBanknotes.getRight().setForeground(new Color(175, 65, 55));
        totalBanknotes.getRight().setHorizontalAlignment(JLabel.RIGHT);
        totalBanknotes
            .getRight()
            .setBounds(
                width / 3 * 2 - ServicePersonTerminal.INDENTATIONS * 2,
                0,
                width / 3,
                ServicePersonTerminal.INDENTATIONS * 2);
        totalBanknotes.getLeft().setText("Total quantity:");
        totalBanknotes.getLeft().setFont(new Font("", Font.BOLD, MainFrame.FONT_SIZE + 2));
        totalBanknotes.getLeft().setForeground(new Color(205, 85, 74));
        totalBanknotes
            .getLeft()
            .setBounds(
                ServicePersonTerminal.INDENTATIONS,
                0,
                width / 3 * 2 - ServicePersonTerminal.INDENTATIONS * 2,
                ServicePersonTerminal.INDENTATIONS * 2);
        add(totalBanknotes);
    }
}
