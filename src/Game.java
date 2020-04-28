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
        screen = new Screen();
        endScreen = new EndScreen();
        frame = new JFrame() {
            @Override
            public void pack() {
                super.pack();
                this.setSize(Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
            }
        };
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(startScreen);
        frame.pack();

    }

    @Override
    public void run() {
        while (true) {
            try {
                if(gameStatus == GameStatus.NOT_STARTED && startScreen.getStarted()) {
                    startScreen.setVisible(false);
                    screen.setVisible(true);
                    frame.add(screen);
                    frame.remove(startScreen);
                    frame.pack();
                    Thread.sleep(1000);
                    screen.start();
                    screen.grabFocus();
                    setGameStatus(GameStatus.RUNNING);
                } else if (gameStatus == GameStatus.WON || gameStatus == GameStatus.LOST) {
                    endScreen.setEndText(gameStatus == GameStatus.WON);
                    screen.setVisible(false);
                    endScreen.setVisible(true);
                    frame.add(endScreen);
                    frame.remove(screen);
                    frame.pack();
                    screen.destroy();
                    endScreen.grabFocus();
                    Thread.sleep(2000);
                    break;
                }
                Thread.sleep(10);
                this.frame.repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        resetGame();

    }

    private void resetGame() {
        Enemy.reset();
        Bullet.reset();
        startScreen = new StartScreen();
        screen = new Screen();
        setGameStatus(GameStatus.NOT_STARTED);
        frame.add(startScreen);
        frame.remove(endScreen);
        startScreen.setVisible(true);
        frame.pack();
        this.run();
    }

    public static void setGameStatus(GameStatus gameStatus) {
        Game.gameStatus = gameStatus;
    }
}
