import java.util.ArrayList;
import java.util.Iterator;

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
        for (int x = Config.BOARD_BORDER_LEFT; x < (Config.BOARD_WIDTH - Config.BOARD_BORDER_RIGHT); x += 50) {
            for (int y = 25; y < 201; y += 50) {
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

    public void moveAliens(){
        ArrayList<Enemy> aliens = Enemy.getEnemies();
        Iterator iAlien2 = aliens.iterator();
        int direction = 2;
        int counter = 0;

        while(iAlien2.hasNext()){
            Enemy alien = (Enemy)iAlien2.next();
            int x = alien.getX();
            try {
                alien.setX(x += direction);
            }catch(Exception ex){
                System.out.println(ex);
            }
            if(x==475){
                try{
                    //alien.setY(alien.getY()+1);
                    alien.setX(x -=direction);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
            if(x==25){
                try{
                    //alien.setY(alien.getY() +1);
                    alien.setX(x += direction);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }

        }

    }

    @Override
    public void destroy() {
        enemies.remove(this);
    }
}
