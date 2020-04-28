import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public abstract class Bullet extends DrawableObject {
    protected boolean isFired;
    private BulletType type;
    private static List <Bullet> bullets = new ArrayList<>();

    public static List<Bullet> getBullets() {
        return bullets;
    }

    public BulletType getType() {
        return type;
    }

    public enum BulletType {
        BULLET_ENEMY,
        BULLET_SPACESHIP
    }

    public static void newBullet(BulletType type, int x, int y) {
        BulletFactory.getBulletType(type, x, y);
    }

    private Bullet(BulletType type, int x, int y){
        super(); //No parameter super-constructor because the bullet have no image
        try {
            setX(x + Config.BULLET_POSITION_CORRECTION);
            setY(y);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        this.type = type;
        this.isFired = true;
        setHeight(Config.BULLET_HEIGHT);
        setWidth(Config.BULLET_WIDTH);
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
            System.out.println(ex);
        }
    }


    protected abstract void moveMe();

    public void destroy() {
        this.isFired = false;
        bullets.remove(this);
    }

    public static void reset() {
        bullets = new ArrayList<>();
    }

    private static class BulletFactory {

        public static Bullet getBulletType(BulletType type, int x, int y) {
            if(type.equals(BulletType.BULLET_ENEMY)) {
                return new Bullet(type, x, y) {
                    int speed = Config.BULLET_SPEED_ENEMY; // 5
                    @Override
                    protected void moveMe() {
                        if(isFired) {
                            try {
                                setY(getY() + speed);
                            }catch (Exception ex) {
                                this.destroy();
                            }
                        }
                    }
                };
            } else {//type == BulletType.BULLET_SPACESHIP) {
                return new Bullet(type, x, y) {
                    int speed = Config.BULLET_SPEED_SPACESHIP; //10
                    @Override
                    protected void moveMe() {
                        if(isFired) {
                            try {
                                setY(getY() - speed);
                            }catch (Exception ex) {
                                this.destroy();
                            }
                        }
                    }
                };
            }
        }

    }
}
