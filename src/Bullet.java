import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Bullet {
    private int width;
    private int heigth;
    private int speed;
    private int x;
    private int y;
    private boolean isFired;
    private static List <Bullet> bullets = new ArrayList<>();

    public static List<Bullet> getBullets() {
        return bullets;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(int x){
        this.width = 3;
        this.heigth = 15;
        this.speed = 20;
        this.x = x;
        this.y = 400;
        this.isFired = true;
        bullets.add(this);

    }

    public static void move() {
        try {
            if(!bullets.isEmpty()) {
                for (Bullet b : bullets) {
                    b.moveMe();
                }
            }
        }catch (ConcurrentModificationException ex) {
            System.out.println(bullets.size());
        }
    }


    private void moveMe() {
        if(isFired) {
            if (y > 0)
                y -= speed;
            else
                this.destroy();
        }
    }

    private void destroy() {
        this.isFired = false;
        bullets.remove(this);
    }
}
