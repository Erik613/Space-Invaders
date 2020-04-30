import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * class represents the Start Screen of the Game
 */
public class StartScreen extends JPanel {
    private JButton startButton;
    private boolean started = false;

    /**
     * the actual Start Screen
     */
    public StartScreen() {
        super(new BorderLayout(300, 300));
        this.setBackground(Color.BLACK);
        JPanel content = new JPanel(new GridLayout(3, 1));
        content.setBackground(Color.BLACK);

        startButton = new JButton();
        JLabel logo = new JLabel();

        ImageIcon startButtonIcon = new ImageIcon(Config.BOARD_BUTTON, "startbutton");
        ImageIcon logoIcon = new ImageIcon(Config.BOARD_LOGO, "logo");
        startButton.setIcon(startButtonIcon);
        logo.setIcon(logoIcon);
        logo.setHorizontalAlignment(JLabel.CENTER);

        startButton.setBackground(Color.BLACK);
        startButton.setVisible(true);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.addActionListener(e -> started = true);

        content.add(logo);
        content.add(startButton);
        content.add(new JLabel());

        add(content, BorderLayout.CENTER);
    }

    /**
     * if the Game Starts
     * @return Start
     */
    public boolean getStarted() {
        return started;
    }
}
