package edu.shtoiko.atmsimulator.terminal.mainframe;

import edu.shtoiko.atmsimulator.services.implementation.ConnectionManager;
import edu.shtoiko.atmsimulator.terminal.serviceframe.ServicePersonTerminal;
import edu.shtoiko.atmsimulator.terminal.userframe.UserTerminal;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MainFrame {

    /** Get screen width and height */
    public static final GraphicsDevice GRAPHICS_DEVICE =
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static final int SCREEN_WIDTH = GRAPHICS_DEVICE.getDisplayMode().getWidth() / 2;
    public static final int SCREEN_HEIGHT = GRAPHICS_DEVICE.getDisplayMode().getWidth() / 2;

    /** Set font size */
    public static final int FONT_SIZE = SCREEN_HEIGHT * 13 / 720;

    private final ConnectionManager connectionManager;

    public MainFrame(ContextHolder contextHolder)
        throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
        IllegalAccessException {
        this.connectionManager = contextHolder.getConnectionManager();
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        EventQueue.invokeLater(() -> {
            try {
                connectionManager.authenticate();
                initializeMainFrame(contextHolder);
            } catch (Exception e) {
                System.err.println("Error during frame initialization: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void initializeMainFrame(ContextHolder contextHolder) {
        JFrame mainFrame = new JFrame("ATM");
        mainFrame.setBounds(300, 100, 300, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        ButtonGroup roleSelectionGroup = new ButtonGroup();
        JRadioButton userOption = new JRadioButton("User", true);
        roleSelectionGroup.add(userOption);
        JRadioButton serviceOption = new JRadioButton("Service person", false);
        roleSelectionGroup.add(serviceOption);

        JLabel instructionLabel = new JLabel("You want to authorize as...");

        JButton authorizeButton = new JButton("Authorization");
        authorizeButton.addActionListener(e -> {
            if (userOption.isSelected()) {
                instructionLabel.setText("You want to authorize as... User");
                mainFrame.setVisible(false);
                new UserTerminal(mainFrame, contextHolder);
            } else if (serviceOption.isSelected()) {
                instructionLabel.setText("You want to authorize as... Service");
                mainFrame.setVisible(false);
                new ServicePersonTerminal(mainFrame, contextHolder);
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(instructionLabel, BorderLayout.NORTH);
        mainPanel.add(serviceOption, BorderLayout.EAST);
        mainPanel.add(userOption, BorderLayout.WEST);
        mainPanel.add(authorizeButton, BorderLayout.SOUTH);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }
}