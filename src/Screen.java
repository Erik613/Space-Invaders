import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
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
    private Image backgroundImg;


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
        setSize(dimensionX, dimensionY);
        backgroundImg = new ImageIcon(Config.BOARD_BACKGROUND).getImage();

        setFocusable(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        doKeyActions();
        spaceship.move();
        Bullet.move();
        moveAliens();
        Enemy.randomShoot();
        hitDetection();

    }

    /**
     * checks if player or enemy gets hit by a bullet
     */
    private void hitDetection() {
        try {
            for (Bullet b : Bullet.getBullets()) {
                for (Enemy e : Enemy.getEnemies()) {
                    if (b.hit(e) && b.getType() == Bullet.BulletType.BULLET_SPACESHIP)  {
                        b.destroy();
                        e.destroy();
                    }
                    if(e.hit(spaceship))
                        spaceship.destroy();
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
            System.out.println(ex);
        }
    }

    /**
     * connects keys with movement on Screen
     */
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

    /** draw game pieces on Screen */
    private void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        g2d.drawImage(backgroundImg, 0, 0, null);

        //draw spaceship
        if(spaceship.isAlive()) {
            g2d.drawImage(spaceship.getImg(), spaceship.getX(), spaceship.getY(), null);
        }
        //draw bullets
        if(Bullet.getBullets() != null  && !Bullet.getBullets().isEmpty()) {
            g2d.setColor(Config.BULLET_COLOR);
            for (Bullet b : Bullet.getBullets()) {
                g2d.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
        }
        //draw enemies
        //draw a rectangle for each enemy stored in Enemy
        for(Enemy e : Enemy.getEnemies()) {
            g2d.drawImage(e.getImg(), e.getX(), e.getY(), null);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        draw(graphics);

        Toolkit.getDefaultToolkit().sync();
    }



    /**
     * deletes enemy or player if they get hit
     */
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

    /**
     * moves the enemy ships
     */
    public void moveAliens() {
        boolean moveY = false;
        int index = Enemy.getEnemies().size();

        //Move Enemies and make revert moves if an enemy touch the Edge.
        for(int i = 0; i < index; i++) {
            Enemy e = Enemy.getEnemies().get(i);
            try {
                if(Enemy.shouldMoveRight()){
                    e.setX(e.getX() + Config.ENEMY_SPEED);
                }else{
                    e.setX(e.getX() + (Config.ENEMY_SPEED * -1));
                }
            } catch (Exception ex) {
                moveY = true;
                index = Enemy.getEnemies().indexOf(e);
                i = 0;
            }
        }
        //Move on Y-axis if an enemy touched the Edge
        //Exception get thrown if an enemy touches the edge of the y-axis -> Player lost -> spaceship.destroy
        if(moveY) {
            for (Enemy e : Enemy.getEnemies()) {
                try {
                    e.setY(e.getY() + 10);
                } catch (Exception ex) {
                    spaceship.destroy();
                }
            }
        }
    }
}
