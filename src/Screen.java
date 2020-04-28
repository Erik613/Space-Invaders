import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * class represents game display
 * all game objects & action are
 * seen on Screen
 */
public class Screen extends JPanel implements ActionListener {
    /* Screen attributes */
    private Timer timer;
    private Spaceship spaceship;
    private final int DELAY = 15;
    public static int dimensionX = Config.BOARD_WIDTH;
    public static int dimensionY = Config.BOARD_HEIGHT;
    private KeyPressedListener keyListener;


    public Screen() {
        initScreen();
    }

    private void initScreen() {

        //create player Icon & add KeyListener
        spaceship = new Spaceship();
        keyListener = new KeyPressedListener();
        this.addKeyListener(keyListener);
        timer = new Timer(DELAY, this);

        //set basic structure for game display
        setBackground(Config.BACKGROUND);
        setSize(dimensionX, dimensionY);

        System.out.println(getHeight() + " " + getWidth());
        setFocusable(true);

    }

    private void step() {
        doKeyActions();
        spaceship.move();
        Bullet.move();
        Enemy.randomShoot();
            try {
                for (Bullet b : Bullet.getBullets()) {
                    for (Enemy e : Enemy.getEnemies()) {
                        if (b.hit(e) && b.getType() == Bullet.BulletType.BULLET_SPACESHIP)  {
                            b.destroy();
                            e.destroy();
                        }
                    }
                    if(b.hit(spaceship) && b.getType() == Bullet.BulletType.BULLET_ENEMY) {
                        spaceship.destroy();
                    }
                }
                if(Enemy.getEnemies().isEmpty()) {
                    Game.setGameStatus(Game.GameStatus.WON);
                }else if(!spaceship.isAlive())
                    Game.setGameStatus(Game.GameStatus.LOST);
            }catch (Exception ex) {

            }
    }

    /* connects keys with movement on Screen */
    private void doKeyActions() {
        if(keyListener.getPressedKeys().contains(KeyPressedListener.MOVE_RIGHT))
            spaceship.setMoveDirectionRight();
        else if(keyListener.getPressedKeys().contains(KeyPressedListener.MOVE_LEFT))
            spaceship.setMoveDirectionLeft();
        else
            spaceship.resetMoveDirection();
        if(keyListener.getPressedKeys().contains(KeyPressedListener.SHOOT))
            spaceship.getGun().shoot(spaceship.getX(), spaceship.getY());
    }

    /* draw game pieces on Screen */
    private void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        //draw spaceship
        if(spaceship.isAlive()) {
            g2d.setColor(Config.SPACESHIP_COLOR);
            g2d.drawRect(spaceship.getX(), spaceship.getY(), spaceship.getWidth(), spaceship.getHeight());
        }
        //draw bullets
        if(Bullet.getBullets() != null  && !Bullet.getBullets().isEmpty()) {
            g2d.setColor(Config.BULLET_COLOR);
            for (Bullet b : Bullet.getBullets()) {
                g2d.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());

            }
        }
        //draw enemies
        g2d.setColor(Config.ENEMY_COLOR);
        //draw a rectangle for each enemy stored in Enemy
        for(Enemy e : Enemy.getEnemies()) {
            g2d.drawRect(e.getX(), e.getY(), e.getWidth(), e.getHeight());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        draw(graphics);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        step();

    }

    public void destroy() {
        this.spaceship = null;
        this.keyListener = null;
        timer.stop();
        timer = null;
    }

    public void start() {
        if(!timer.isRunning())
            timer.start();
    }
}
