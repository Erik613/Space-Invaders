import javax.swing.*;
/* game object */
public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;  //display for the game


    public Game(){
        screen = new Screen();

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
