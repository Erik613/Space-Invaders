import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartScreen extends JPanel {
    private Button startButton;
    private boolean started =false;

    public StartScreen() {

        super(new BorderLayout(5, 5));
        this.setBackground(Color.BLACK);
        JPanel content = new JPanel(new GridLayout(3, 1));
        content.setBackground(Color.BLACK);
        JLabel jl=new JLabel();
        try {
            jl.setIcon(new javax.swing.ImageIcon("ressources/img/logo.jpg"));
            jl.setHorizontalAlignment(JLabel.CENTER);
        }catch (Exception ex){
            System.out.println(ex);
        }

        startButton = new Button("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.setForeground(Color.YELLOW);
        startButton.setBackground(Color.BLACK);
        startButton.setVisible(true);
        startButton.addActionListener(e -> started = true);

        //content.add(new JLabel());
        content.add(jl);
        content.add(startButton);
        content.add(new JLabel());

        add(content, BorderLayout.CENTER);
    }

    public boolean getStarted() {
        return started;
    }
}
