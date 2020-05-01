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
    private boolean isAlive;        //indication if Spaceship is hit
    private Gun gun;


    /**
     * constructor for Spaceship
     */
    public Spaceship() {
        super(Config.SPACESHIP_ICON, "Spaceship");          //set Image
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
     * move spaceship horizontal
     * try setting new x coordinate
     * by adding moveSpeed to old coordinate
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
     * check if spaceship is hit
     * @return indication if spaceship is alive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * destroy spaceship
     * alive status is set to false
     */
    @Override
    public void destroy() {
        this.isAlive = false;
    }

}
