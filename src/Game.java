import javax.swing.*;
/* game object */
public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;  //display for the game
    private StartScreen startScreen;
    private static GameStatus gameStatus;
    private EndScreen endScreen;

    public enum GameStatus {
        RUNNING,
        WON,
        LOST,
        NOT_STARTED,
    }


    public Game(){
        gameStatus = GameStatus.NOT_STARTED;
        startScreen = new StartScreen();
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(startScreen);


    }

    @Override
    public void run() {
        while (true) {
            try {
                if(screen == null && startScreen.getStarted()) {
                    screen = new Screen();
                    startScreen.setVisible(false);
                    frame.remove(startScreen);
                    frame.add(screen);
                    screen.grabFocus();
                } else if (gameStatus == GameStatus.WON || gameStatus == GameStatus.LOST) {
                    endScreen = new EndScreen(gameStatus == GameStatus.WON);
                    endScreen.setVisible(true);
                    frame.remove(screen);
                    frame.add(endScreen);
                    screen.destroy();
                    endScreen.grabFocus();
                    break;
                }
                //Thread.sleep(10);
                this.frame.repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        while (true) {
            try {
                this.frame.repaint();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void setGameStatus(GameStatus gameStatus) {
        Game.gameStatus = gameStatus;
    }
}
