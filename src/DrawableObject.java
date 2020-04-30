import javax.swing.*;
import java.awt.*;

/**
 * class represents all drawable Objects
 */
public abstract class DrawableObject {
    private int x;
    private int y;
    private int height;
    private int width;
    protected Image img;

    protected DrawableObject(String imgPath, String imgDesc) {
        img = new ImageIcon(imgPath, imgDesc).getImage();
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
    }
    protected DrawableObject(){

    }

    /**
     * set X Position for a drawable Object
     * @param x X position on screen
     * @throws Exception if X Position is out of the Screen
     */
    public void setX(int x) throws Exception{
        if(x > 0 && x < Screen.dimensionX - 50) {
            this.x = x;
        }
        else {
            throw new Exception("Objekt außerhalb des Bildes");
        }

    }

    /**
     * getter for X Position
     * @return X Position
     */
    public int getX() {
        return this.x;
    }

    /**
     * set Y Position for a drawable Object
     * @param y Y position on screen
     * @throws Exception if Y Position is out of the Screen
     */
    public void setY(int y) throws Exception{
        if(y > 0 && y < Screen.dimensionY - 50) {
            this.y = y;
        } else
            throw new Exception("Object außerhalb des Bildes");
    }

    /**
     * getter for Y Position
     * @return Y Position
     */
    public int getY() {
        return this.y;
    }

    /**
     * getter for height of a Object
     * @return height of a Object
     */
    public int getHeight() {
        return height;
    }

    /**
     * getter for width of a Object
     * @return width of a Object
     */
    public int getWidth() {
        return width;
    }

    /**
     * set height of a Object
     * @param height height of the Object
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * set width of a Object
     * @param width width of the Object
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param r
     * @return
     */
    public boolean hit (DrawableObject r) {
        return x < r.getX() + r.getWidth() && x + width > r.getX() && y < r.getY() + r.getHeight() && y + height > r.getY();
    }

    /**
     *
     */
    public abstract void destroy();
}

