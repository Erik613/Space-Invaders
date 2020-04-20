import java.util.ArrayList;

public class Enemy extends DrawableObject {
    private int height;
    private int width;

    private Gun gun;
    private static ArrayList<Enemy> enemies;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    private Enemy() {
        this.height = 25;
        this.width = 15;
        gun = new Gun(15000);
        enemies.add(this);

    }

    public static ArrayList<Enemy> getEnemies() {

        if (enemies != null)
            return enemies;
        enemies = new ArrayList<Enemy>();
        for (int x = 25; x < 475; x += 50) {
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
}