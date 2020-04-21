import javax.swing.*;
/* game object */
public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;  //display for the game
    private StartScreen startScreen;


    public Game(){
        startScreen = new StartScreen();
        frame = new JFrame();
        frame.setSize(Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(startScreen);


    }

    @Override
    public void run() {
        while (true) {
            try {
                if(startScreen.isVisible() && startScreen.getStarted()) {
                    screen = new Screen();
                    startScreen.setVisible(false);
                    frame.remove(startScreen);
                    frame.add(screen);
                    screen.grabFocus();
                }
                //Thread.sleep(10);
                this.frame.repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
