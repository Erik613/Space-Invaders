import javax.swing.*;
import java.io.IOException;

/* game object */
public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;  //display for the game


    public Game() throws IOException {
        screen = new Screen("C:\\xampp\\htdocs\\ZFC\\zugferd_rechnungserstellung\\logo\\Test456.jpg");

        frame = new JFrame();
        frame.setSize(Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(screen);


    }

    @Override
    public void run() {
        while (true) {
            try {
                //Thread.sleep(10);
                this.frame.repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
