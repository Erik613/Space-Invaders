import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/*
 * class represents player character
 */
public class Spaceship extends DrawableObject{
    /* spaceship attributes */
    private int speed;
    private int moveSpeedX;
    private boolean isAlive;
    private Gun gun;


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



    public void move() {
        if(getX() >= 0 && getX()<= Config.BOARD_WIDTH)
            try {
                setX(getX() + moveSpeedX);
            }catch (Exception ex) {
                System.out.println(ex);
            }
    }

    public Gun getGun() {
        return gun;
    }

    public void setMoveDirectionLeft() {
        moveSpeedX = speed * (-1);
    }
    public void setMoveDirectionRight() {
        moveSpeedX = speed;
    }
    public void resetMoveDirection() {
        moveSpeedX = 0;
    }


    public boolean isAlive() {
        return isAlive;
    }
    @Override
    public void destroy() {
        this.isAlive = false;
    }

}
