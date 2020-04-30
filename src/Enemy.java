import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * class represents the Enemy
 */
public class Enemy extends DrawableObject {


    private Gun gun;
    private static boolean canShoot = true;
    private static boolean moveRight = true;
    private static ArrayList<Enemy> enemies;


    /**
     *
     */
    private Enemy () {
        super(Config.ENEMY_ICON, "alien");
        gun = new Gun(Config.ENEMY_GUN_COOLDOWN, Bullet.BulletType.BULLET_ENEMY);
        enemies.add(this);
    }

    /**
     *
     * @return ArrayList of enemies
     */
    public static ArrayList<Enemy> getEnemies() {

        if(enemies != null) {
            return enemies;
        }else {
            enemies = new ArrayList<Enemy>();
            for (int x = Config.BOARD_BORDER_LEFT; x < (Config.BOARD_WIDTH - Config.BOARD_BORDER_RIGHT); x += Config.BOARD_WIDTH / 9) {
                for (int y = Config.BOARD_BORDER_UP; y < Config.BOARD_HEIGHT / 2; y += Config.BOARD_WIDTH / 9) {
                    Enemy e = new Enemy();
                    try {
                        e.setX(x);
                        e.setY(y);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
            return enemies;
        }
    }

    /**
     * random shoots for the enemies
     */
    public static void randomShoot() {
        if(enemies == null || !canShoot)
            return;
        Timer t = new Timer();
        int index = (int)(Math.random() * enemies.size());
        enemies.get(index).gun.shoot(enemies.get(index).getX(), enemies.get(index).getY());
        canShoot = false;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                canShoot = true;
            }
        }, 1000);
    }

    /**
     *
     */
    public static void reset() {
        enemies = null;
    }

    /**
     *
     */
    @Override
    public void destroy() {
        enemies.remove(this);
    }

    /**
     * @return
     */
    public static boolean shouldMoveRight() {
        return moveRight;
    }

    /**
     * @param x X position on screen
     * @throws Exception if X Position is out of Screen
     */
    @Override
    public void setX(int x) throws Exception {
        try {
            super.setX(x);
        }catch (Exception e) {
            Enemy.moveRight = !moveRight;
            throw new Exception(e);
        }

    }
}
