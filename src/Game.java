import javax.swing.*;
/**
 * class represents the actual game
 * decides which status the game is at
 * and which Screen to display
 */
public class Game implements Runnable {
    private JFrame frame;
    private Screen screen;  //display for the game
    private StartScreen startScreen;    //screen before actual game starts
    private static GameStatus gameStatus;
    private EndScreen endScreen;        //screen after game ends

    /**
     * list of statutes
     * that the game can have
     */
    public enum GameStatus {
        RUNNING,
        WON,
        LOST,
        NOT_STARTED,
    }


    /**
     * constructor for game
     * sets status and creates screens
     */
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

    /**
     * method to start actual SpaceInvaders game
     */
    @Override
    public void run() {
        while (true) {      //loops run till game is won or lost
            try {
                //if game has not started & start Button is pressed
                if(gameStatus == GameStatus.NOT_STARTED && startScreen.getStarted()) {
                    startScreen.setVisible(false);
                    screen.setVisible(true);
                    frame.add(screen);                      //show actual game screen
                    frame.remove(startScreen);
                    frame.pack();
                    Thread.sleep(1000);
                    screen.start();
                    screen.grabFocus();
                    setGameStatus(GameStatus.RUNNING);          //change status
                    //game has ended
                } else if (gameStatus == GameStatus.WON || gameStatus == GameStatus.LOST) {
                    endScreen.setEndLabel(gameStatus == GameStatus.WON);    //choose which label to display
                    screen.setVisible(false);
                    endScreen.setVisible(true);
                    frame.add(endScreen);               //display endscreen
                    frame.remove(screen);
                    frame.pack();
                    screen.destroy();
                    endScreen.grabFocus();
                    Thread.sleep(3000);
                    break;                          //break while.loop
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

    /**
     * resets the Game
     */
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
        this.run();             //start new round
    }

    /**
     * set the game Status
     * @param gameStatus the game status
     */
    public static void setGameStatus(GameStatus gameStatus) {
        Game.gameStatus = gameStatus;
    }
}
