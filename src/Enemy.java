import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * class represents the Enemy
 * each enemy has to be defeated by player
 * to win game
 */
public class Enemy extends DrawableObject {

    private Gun gun;
    private static boolean canShoot = true;         //are enemies able to shoot
    private static boolean moveRight = true;        //indication if they should move right
    private static ArrayList<Enemy> enemies;        //list that stores all enemies


    /**
     * constructor for enemy
     * set an icon, create new gun & add enemy to list
     */
    private Enemy () {
        super(Config.ENEMY_ICON, "alien");
        gun = new Gun(Config.ENEMY_GUN_COOLDOWN, Bullet.BulletType.BULLET_ENEMY);
        enemies.add(this);
    }

    /**
     * get enemies, if none exist create new ones
     * @return ArrayList of enemies
     */
    public static ArrayList<Enemy> getEnemies() {

        if(enemies != null) {       //if enemies exist, return list
            return enemies;
        } else {                    //no enemies exist
            enemies = new ArrayList<Enemy>();
            //for each 1/9 of the Board width
            for (int x = Config.BOARD_BORDER_LEFT; x < (Config.BOARD_WIDTH - Config.BOARD_BORDER_RIGHT); x += Config.BOARD_WIDTH / 9) {
                //for each 1/9 of the board height in the upper half
                for (int y = Config.BOARD_BORDER_UP; y < Config.BOARD_HEIGHT / 2; y += Config.BOARD_WIDTH / 9) {
                    Enemy e = new Enemy();                  //create new enemy
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
     * chooses random enemy to shoot
     */
    public static void randomShoot() {
        if(enemies == null || !canShoot)        //if no enemies exist or can not shoot, leave method
            return;
        Timer t = new Timer();
        int index = (int)(Math.random() * enemies.size());      //choose random index
        enemies.get(index).gun.shoot(enemies.get(index).getX(), enemies.get(index).getY());
        canShoot = false;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                canShoot = true;
            }
        }, 1000);       //wait till enemies can shoot again
    }

    /**
     * deletes all enemies
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
     * method that returns indication if enemies should move to right side
     * @return if enemies should move right
     */
    public static boolean shouldMoveRight() {
        return moveRight;
    }

    /**
     * set new X coordinate
     * @param x X position on screen
     * @throws Exception if X Position is out of Screen
     */
    @Override
    public void setX(int x) throws Exception {
        try {               //try setting new x coordinate
            super.setX(x);
        }catch (Exception e) {      //new position is out of screen
            Enemy.moveRight = !moveRight;   //change value of moveRight
            throw new Exception(e);
        }

    }
}
