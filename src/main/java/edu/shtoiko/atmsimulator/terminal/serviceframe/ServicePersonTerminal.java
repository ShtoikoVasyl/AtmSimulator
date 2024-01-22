package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.listeners.TerminalWindowListener;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

/**
 * service frame, displays available banknotes and allows load banknotes
 */
public class ServicePersonTerminal {

    /**
     * Setting indents
     */
    public final static int indentations = MainFrame.width / 40;
    ContextHolder contextHolder;
    /**
     * @param superFrame the frame that will need to be processed in WindowListener
     */
    public ServicePersonTerminal(JFrame superFrame, ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
        Messanger messanger = new Messanger();

        TerminalFrame serviceFrame = new TerminalFrame();
        serviceFrame.addWindowListener(new TerminalWindowListener(superFrame));
        serviceFrame.setTitle("Service terminal");

        AvailablePanel availablePanel = new AvailablePanel(contextHolder.getDataWarehouseController().getResources(), contextHolder.getCurrency());
        availablePanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(138, 200, 168), 0, true),
                        "Available Banknotes",
                        TitledBorder.LEFT,
                        TitledBorder.TOP, new Font("", Font.BOLD, MainFrame.fontSize - 1)));
        LoadPanel loadPanel = new LoadPanel(availablePanel, contextHolder.getDataWarehouseController(), contextHolder.getCurrency(), messanger);
        loadPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(240, 240, 240), 0, true),
                        "Loading Banknotes",
                        TitledBorder.RIGHT,
                        TitledBorder.TOP, new Font("", Font.BOLD, MainFrame.fontSize - 1)));
        serviceFrame.mainPanel.setBackground(new Color(240, 240, 240));
        serviceFrame.mainPanel.setLayout(null);
        serviceFrame.mainPanel.add(messanger);
        serviceFrame.mainPanel.add(loadPanel);
        serviceFrame.mainPanel.add(availablePanel);
    }
}
