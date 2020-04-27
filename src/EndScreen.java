import javax.swing.*;
import java.awt.*;

public class EndScreen extends JPanel {
    private JLabel endText;

    public EndScreen(boolean win) {
        super(new BorderLayout(5, 5));
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        if(win) {
            endText = new JLabel("Du hast gewonnen");
        }
        else {
            endText = new JLabel("Du hast verloren");
        }
        this.setBackground(Color.BLACK);
        endText.setForeground(Color.YELLOW);
        endText.setHorizontalAlignment(JLabel.CENTER);
        endText.setVerticalAlignment(JLabel.CENTER);
        endText.setVisible(true);
        endText.setSize(200, 50);
        this.setSize(Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        add(endText, BorderLayout.CENTER);
    }
}
