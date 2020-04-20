import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    private Timer timer;
    private Spaceship spaceship;
    private final int DELAY = 15;
    public static int dimensionX = 500;
    public static int dimensionY = 500;
    private KeyPressedListener keyListener;


    public Screen() {
        initScreen();
    }

    private void initScreen() {
        setBackground(Color.BLACK);

        spaceship = new Spaceship();
        keyListener = new KeyPressedListener();


        timer = new Timer(DELAY, this);
        timer.start();
        setSize(dimensionX, dimensionY);
        System.out.println(getHeight() + " " + getWidth());
        this.setVisible(true);
        this.addKeyListener(keyListener);
        setFocusable(true);

    }

    private void step() {
        doKeyActions();
        spaceship.move();
        Bullet.move();


    }

    private void doKeyActions() {
        if(keyListener.getPressedKeys().contains(KeyPressedListener.MOVE_RIGHT))
            spaceship.setMoveDirectionRight();
        else if(keyListener.getPressedKeys().contains(KeyPressedListener.MOVE_LEFT))
            spaceship.setMoveDirectionLeft();
        else
            spaceship.resetMoveDirection();
        if(keyListener.getPressedKeys().contains(KeyPressedListener.SHOOT))
            spaceship.getGun().shoot(spaceship.getX());
    }


    private void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        //Spaceship zeichenen
        g2d.setColor(Color.BLUE);
        g2d.drawRect(spaceship.getX(), spaceship.getY(), spaceship.getHeight(), spaceship.getWidth());
        //Kugeln Zeichnen
        if(Bullet.getBullets() != null  && !Bullet.getBullets().isEmpty()) {
            for (Bullet b : Bullet.getBullets()) {
                g2d.drawRect(b.getX(), b.getY(), b.getHeigth(), b.getWidth());
            }
        }
        //Enemies Zeichenen
        g2d.setColor(Color.RED);
        for(Enemy e : Enemy.getEnemies()) {
            g2d.drawRect(e.getX(), e.getY(), e.getHeight(), e.getWidth());
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
}
