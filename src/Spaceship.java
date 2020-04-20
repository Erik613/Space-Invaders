import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Spaceship extends DrawableObject{
    private int speed;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width;
    private int height;
    private int moveSpeedX;
    private int moveSpeedY;

    private Gun gun;


    public Spaceship() {
        this.width = 15;
        this.height = 25;
        try {
            this.setX(235);
            this.setY(400);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        this.moveSpeedX = 0;
        this.speed = 5;
        gun = new Gun(600);
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
