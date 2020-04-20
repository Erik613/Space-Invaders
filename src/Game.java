import javax.swing.*;

public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;


    public Game(){
        screen = new Screen();

        frame = new JFrame();
        frame.setSize(500, 500);
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
