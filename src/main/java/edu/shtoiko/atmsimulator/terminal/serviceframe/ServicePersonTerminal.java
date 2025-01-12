package edu.shtoiko.atmsimulator.terminal.serviceframe;

import edu.shtoiko.atmsimulator.terminal.listeners.TerminalWindowListener;
import edu.shtoiko.atmsimulator.terminal.mainframe.ContextHolder;
import edu.shtoiko.atmsimulator.terminal.mainframe.MainFrame;
import edu.shtoiko.atmsimulator.terminal.mainframetemplate.TerminalFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Service frame, displays available banknotes and allows loading banknotes.
 */
public class ServicePersonTerminal {

    public static final int INDENTATIONS = MainFrame.SCREEN_WIDTH / 40;
    private final ContextHolder contextHolder;

    /**
     * @param superFrame the frame that will need to be processed in WindowListener
     */
    public ServicePersonTerminal(JFrame superFrame, ContextHolder contextHolder) {
        this.contextHolder = contextHolder;

        Messanger messenger = new Messanger();
        TerminalFrame serviceFrame = createServiceFrame(superFrame);

        AvailablePanel availablePanel = createAvailablePanel();
        LoadPanel loadPanel = createLoadPanel(availablePanel, messenger);

        configureMainPanel(serviceFrame, messenger, loadPanel, availablePanel);
    }

    private TerminalFrame createServiceFrame(JFrame superFrame) {
        TerminalFrame serviceFrame = new TerminalFrame(contextHolder);
        serviceFrame.addWindowListener(new TerminalWindowListener(superFrame));
        serviceFrame.setTitle("Service Terminal");
        return serviceFrame;
    }

    private AvailablePanel createAvailablePanel() {
        AvailablePanel availablePanel = new AvailablePanel(
            contextHolder.getDataWarehouseController().getResourcesByValueNames(),
            contextHolder.getCurrency());
        availablePanel.setBorder(createTitledBorder("Available Banknotes", new Color(138, 200, 168)));
        return availablePanel;
    }

    private LoadPanel createLoadPanel(AvailablePanel availablePanel, Messanger messenger) {
        LoadPanel loadPanel = new LoadPanel(
            availablePanel,
            contextHolder.getDataWarehouseController(),
            contextHolder.getCurrency(),
            messenger);
        loadPanel.setBorder(createTitledBorder("Loading Banknotes", new Color(240, 240, 240)));
        return loadPanel;
    }

    private TitledBorder createTitledBorder(String title, Color borderColor) {
        return BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(borderColor, 0, true),
            title,
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("", Font.BOLD, MainFrame.FONT_SIZE - 1));
    }

    private void configureMainPanel(TerminalFrame serviceFrame, Messanger messenger, LoadPanel loadPanel,
        AvailablePanel availablePanel) {
        serviceFrame.getMainPanel().setBackground(new Color(240, 240, 240));
        serviceFrame.getMainPanel().setLayout(null);
        serviceFrame.getMainPanel().add(messenger);
        serviceFrame.getMainPanel().add(loadPanel);
        serviceFrame.getMainPanel().add(availablePanel);
    }
}