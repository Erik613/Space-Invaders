import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
    private Button b;
    private boolean started =false;

    public StartScreen() {
        b = new Button("Start");
        b.setSize(200, 50);
        b.setVisible(true);
        b.addActionListener(e -> started = true);
        add(b);
    }

    public boolean getStarted() {
        return started;
    }
}
