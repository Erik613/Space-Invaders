import javax.swing.*;
import java.awt.*;

public class EndScreen extends JPanel {
    private JLabel endText;

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

    public void setEndText(boolean win) {
        if(win) {
            try {
                JLabel jl=new JLabel();
                jl.setIcon(new javax.swing.ImageIcon("ressources/img/you_win.png"));
                jl.setHorizontalAlignment(JLabel.CENTER);
                jl.setVerticalAlignment(JLabel.CENTER);
                add(jl, BorderLayout.CENTER);
            }catch (Exception ex){
                endText.setText("Du hast gewonnen");
            }

        }
        else {
            try {
                JLabel jl=new JLabel();
                jl.setIcon(new javax.swing.ImageIcon("ressources/img/game_over.png"));
                jl.setHorizontalAlignment(JLabel.CENTER);
                jl.setVerticalAlignment(JLabel.CENTER);
                add(jl, BorderLayout.CENTER);
            }catch (Exception ex){
                endText.setText("Du hast verloren");
            }

        }
    }
}
