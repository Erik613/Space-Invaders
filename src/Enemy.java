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



    private Enemy () {
        this.height =  25;
        this.width = 15;
        gun = new Gun(15000);
        enemies.add(this);

    }
    //Erster Versuch die Gegner richtig positioniert spawnen zu lassen.
    //TODO muss fertiggestellt werden werden
    public static ArrayList<Enemy> getEnemies() {
        if(enemies!= null)
            return enemies;
        enemies = new ArrayList<>();
        int increaseX = Screen.dimensionX / 7;
        int increaseY = Screen.dimensionY / 5;
        int lastX = 0;
        int lastY = 0;
        for (int i = 24; i >0; i--) {
            Enemy e = new Enemy();
            try {
                if (i == 24) {
                    System.out.println("if");
                    e.setX(50);
                    e.setY(50);
                    lastX = 50;
                    lastY = 50;
                } else if (i % 6 == 0) {
                    System.out.println("else if");
                    System.out.println("add:    " );
                    e.setY(lastY + increaseY);
                    lastY = increaseY;
                } else if(i % 2 != 0) {
                    System.out.println("else if 2");
                    System.out.println("add:    " );
                    e.setX(lastX + increaseX);
                    lastX += increaseX;
                }else {
                    System.out.println("else");
                    System.out.println("add:    " );
                    e.setX(lastX - increaseX);
                    lastX -= increaseX;
                }
            }catch (Exception ex) {
                System.out.println(ex);
            }

            System.out.println("getEnemiesTest");
            System.out.println("x: " + e.getX() + " y: " + e.getY());
            enemies.add(e);
        }
        return enemies;
    }

    public void hit () {
        enemies.remove(this );
    }

    public Gun getGun() {
        return this.gun;
    }

}
