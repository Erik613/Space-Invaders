import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
    private Button startButton;
    private boolean started =false;

    public StartScreen() {
        super(new BorderLayout(5, 5));
        this.setBackground(Color.BLACK);
        JPanel content = new JPanel(new GridLayout(3, 1));
        content.setBackground(Color.BLACK);
        startButton = new Button("Start");
        startButton.setForeground(Color.YELLOW);
        startButton.setVisible(true);
        startButton.addActionListener(e -> started = true);
        content.add(new JLabel());
        content.add(startButton);
        content.add(new JLabel());

        add(content, BorderLayout.CENTER);

    }

    public boolean getStarted() {
        return started;
    }
}
