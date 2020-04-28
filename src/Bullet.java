import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public abstract class Bullet extends DrawableObject {
    protected int speed;
    protected boolean isFired;
    private BulletType type;
    private static BulletFactory bulletFactory = new BulletFactory();
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
        bulletFactory.getBulletType(type, x, y);
    }

    private Bullet(BulletType type, int x, int y){
        super();
        try {
            setX(x + Config.BULLET_POSITION_CORRECTION);
            setY(y);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        this.type = type;
        setHeight(15);
        setWidth(2);
        this.speed = 5;
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


    protected abstract void moveMe();

    public void destroy() {
        this.isFired = false;
        bullets.remove(this);
    }

    public static void reset() {
        bullets = new ArrayList<>();
    }

    private static class BulletFactory {

        public Bullet getBulletType(BulletType type, int x, int y) {
            if(type.equals(BulletType.BULLET_ENEMY)) {
                return new Bullet(type, x, y) {
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
