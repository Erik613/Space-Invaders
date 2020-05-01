import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * class represents the Start Screen of the Game
 * object is shown when program starts
 */
public class StartScreen extends JPanel {
    private JButton startButton;    //button that starts actual game
    private boolean started = false;    //indication if game is started

    /**
     * constructor for Start Screen
     * all basic settings for panel are set
     * and startButton is added
     */
    public StartScreen() {
        super(new BorderLayout(300, 300));
        this.setBackground(Color.BLACK);
        JPanel content = new JPanel(new GridLayout(3, 1));
        content.setBackground(Color.BLACK);

        startButton = new JButton();        //create new button
        JLabel logo = new JLabel();         //create new label that'll display start-Icon

        //load logo for startScreen
        ImageIcon logoIcon = new ImageIcon(Config.BOARD_LOGO, "logo");
        logo.setIcon(logoIcon);
        logo.setHorizontalAlignment(JLabel.CENTER);

        //load image and set Icon for button
        ImageIcon startButtonIcon = new ImageIcon(Config.BOARD_BUTTON, "startbutton");
        startButton.setIcon(startButtonIcon);
        startButton.setBackground(Color.BLACK);
        startButton.setVisible(true);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.addActionListener(e -> started = true);

        //add logo & startButton to panel
        content.add(logo);
        content.add(startButton);
        content.add(new JLabel());

        add(content, BorderLayout.CENTER);
    }

    /**
     * check if game started
     * @return if game has started
     */
    public boolean getStarted() {
        return started;
    }
}
