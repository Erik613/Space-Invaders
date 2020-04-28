import javax.swing.*;
import java.awt.*;

public class EndScreen extends JPanel {
    private JLabel endText;

    public EndScreen() {
        super(new BorderLayout(5, 5));
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        endText = new JLabel();
        endText.setForeground(Color.YELLOW);
        endText.setHorizontalAlignment(JLabel.CENTER);
        endText.setVerticalAlignment(JLabel.CENTER);
        endText.setSize(200, 50);
        add(endText, BorderLayout.CENTER);
    }

    public void setEndText(boolean win) {
        if(win) {
            endText.setText("Du hast gewonnen");
        }
        else {
            endText.setText("Du hast verloren");
        }
    }
}
