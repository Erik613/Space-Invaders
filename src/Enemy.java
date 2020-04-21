import java.util.ArrayList;

public class Enemy extends DrawableObject {


    private Gun gun;
    private static ArrayList<Enemy> enemies;


    private Enemy () {
        gun = new Gun(15000);
        setHeight(Config.ENEMY_HEIGHT);
        setWidth(Config.ENEMY_WIDTH);
        gun = new Gun(Config.ENEMY_GUN_COOLDOWN);
        enemies.add(this);
    }

    public static ArrayList<Enemy> getEnemies() {

        if (enemies != null)
            return enemies;
        enemies = new ArrayList<Enemy>();
        for (int x = Config.BOARD_BORDER_LEFT; x < (Config.BOARD_WIDTH - Config.BOARD_BORDER_RIGHT); x += Config.BOARD_WIDTH/9) {
            for (int y = Config.BOARD_BORDER_RIGHT; y < Config.BOARD_HEIGHT/2; y += Config.BOARD_WIDTH/9) {
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

    @Override
    public void destroy() {
        enemies.remove(this);
    }
}
