import javax.swing.*;
import java.awt.*;

/**
 * class represents the End Screen of the Game
 */
public class EndScreen extends JPanel {
    private JLabel endText;

    /**
     * the actual End Screen
     */
    public EndScreen() {
        super(new BorderLayout(5, 5));
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        endText = new JLabel();
        endText.setFont(new Font("Arial", Font.PLAIN, 40));
        endText.setForeground(Color.YELLOW);
        endText.setHorizontalAlignment(JLabel.CENTER);
        endText.setVerticalAlignment(JLabel.CENTER);
        endText.setSize(200, 50);
        add(endText, BorderLayout.CENTER);
    }

    /**
     * set the End Screen for win or lose
     * @param win True if player win the game
     */
    public void setEndText(boolean win) {
        if(win) {
            try {
                endText.setIcon(new ImageIcon(Config.ICON_WON));
                endText.setHorizontalAlignment(JLabel.CENTER);
                endText.setVerticalAlignment(JLabel.CENTER);
                add(endText, BorderLayout.CENTER);
            }catch (Exception ex){
                endText.setText("Du hast gewonnen");
            }

        }
        else {
            try {
                endText.setIcon(new ImageIcon(Config.ICON_LOST));
                endText.setHorizontalAlignment(JLabel.CENTER);
                endText.setVerticalAlignment(JLabel.CENTER);
                add(endText, BorderLayout.CENTER);
            }catch (Exception ex){
                endText.setText("Du hast verloren");
            }

        }
    }
}
