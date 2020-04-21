import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Bullet extends DrawableObject {
    private int speed;
    private boolean isFired;
    private static List <Bullet> bullets = new ArrayList<>();

    public static List<Bullet> getBullets() {
        return bullets;
    }


    public Bullet(int x){
        try {
            setX(x + Config.SPACESHIP_WIDTH / 2);
            setY(Config.SPACESHIP_POSITIONY);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        setHeight(15);
        setWidth(2);
        this.speed = 20;
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
            try {
                if (getY() > 0)
                    setY(getY() - speed);
                else
                    this.destroy();
            }catch (Exception ex) {
                this.destroy();
            }
        }
    }

    public void destroy() {
        this.isFired = false;
        bullets.remove(this);
    }
}
