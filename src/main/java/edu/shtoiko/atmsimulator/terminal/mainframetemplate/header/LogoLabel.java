package edu.shtoiko.atmsimulator.terminal.mainframetemplate.header;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.net.URL;

public class LogoLabel extends JLabel {

    public LogoLabel(int xOrientation, int yOrientation, int width, int height) {
        URL imageUrl = getClass().getClassLoader().getResource("bankLogo.jpg");
        if (imageUrl != null) {
            ImageIcon rawImage = new ImageIcon(imageUrl);
            ImageIcon scaledImage = new ImageIcon(
                rawImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            setIcon(scaledImage);
        } else {
            System.err.println("bankLogo.jpg not found");
        }

        setBounds(xOrientation, yOrientation, width, height);
        setVisible(true);
    }
}
