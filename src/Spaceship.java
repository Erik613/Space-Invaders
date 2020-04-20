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
    private int width;
    private int height;
    private int moveSpeedX;
    //private int moveSpeedY;
    private Gun gun;


    public Spaceship() {
        this.width = Config.SPACESHIP_WIDTH;
        this.height = Config.SPACESHIP_HEIGHT;
        try {
            this.setX(235);
            this.setY(400);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        this.moveSpeedX = 0;
        this.speed = 5;
        //get new Gun Object for spaceship
        gun = new Gun(Config.SPACESHIP_GUN_COOLDOWN);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }





    public void move() {
        if(getX() >= 0 && getX()<= 480)
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
}
