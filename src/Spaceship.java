import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * class represents player character
 */
public class Spaceship extends DrawableObject{
    /* spaceship attributes */
    private int speed;
    private int moveSpeedX;
    private boolean isAlive;
    private Gun gun;


    /**
     * the Spaceship of the player
     */
    public Spaceship() {
        super("ressources/img/baseshipa.png", "Spaceship");
        this.isAlive = true;
        try {
            this.setX(Config.SPACESHIP_POSITIONX);
            this.setY(Config.SPACESHIP_POSITIONY);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        this.moveSpeedX = 0;
        this.speed = 5;
        //get new Gun Object for spaceship
        gun = new Gun(Config.SPACESHIP_GUN_COOLDOWN, Bullet.BulletType.BULLET_SPACESHIP);
    }


    /**
     * move for the player
     */
    public void move() {
        if(getX() >= 0 && getX()<= Config.BOARD_WIDTH)
            try {
                setX(getX() + moveSpeedX);
            }catch (Exception ex) {
                System.out.println(ex);
            }
    }

    /**
     * getter for Gun
     * @return Gun
     */
    public Gun getGun() {
        return gun;
    }

    /**
     * set the move direction to left
     */
    public void setMoveDirectionLeft() {
        moveSpeedX = speed * (-1);
    }

    /**
     * set the move direction to right
     */
    public void setMoveDirectionRight() {
        moveSpeedX = speed;
    }

    /**
     * reset the move direction
     */
    public void resetMoveDirection() {
        moveSpeedX = 0;
    }

    /**
     * @return
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     *
     */
    @Override
    public void destroy() {
        this.isAlive = false;
    }

}
