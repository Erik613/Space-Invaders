import javax.swing.*;
import java.awt.*;

/**
 * class represents the End Screen of the Game
 * is shown when game ends
 */
public class EndScreen extends JPanel {
    private JLabel endLabel;     //text/image that is shown

    /**
     * constructor for EndScreen
     * set al basic settings for the panel
     */
    public EndScreen() {
        super(new BorderLayout(5, 5));
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        endLabel = new JLabel();
        endLabel.setHorizontalAlignment(JLabel.CENTER);     //position label in center
        endLabel.setVerticalAlignment(JLabel.CENTER);
        endLabel.setSize(200, 50);
        add(endLabel, BorderLayout.CENTER);                 //add label
    }

    /**
     * chooses what to display in endLabel
     * @param win True if player win the game
     */
    public void setEndLabel(boolean win) {
        if(win) {                                           //game is won
            try {                                           //try loading image
                endLabel.setIcon(new ImageIcon(Config.ICON_WON));
            }catch (Exception ex){                          //when image can not be loaded
                endLabel.setFont(new Font("Arial", Font.PLAIN, 40));    //show text instead
                endLabel.setForeground(Color.YELLOW);
                endLabel.setText("Du hast gewonnen");
            }
        }
        else {                                              //game is lost
            try {                                           //try loading image
                endLabel.setIcon(new ImageIcon(Config.ICON_LOST));
            }catch (Exception ex){                          //when image can not be loaded
                endLabel.setFont(new Font("Arial", Font.PLAIN, 40));    //show text instead
                endLabel.setForeground(Color.YELLOW);
                endLabel.setText("Du hast verloren");
            }
        }
    }
}
