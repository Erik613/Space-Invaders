public class DrawableObject {
    private int x;
    private int y;
    private int height;
    private int width;




    public void setX(int x) throws Exception{
        if(x > 0 && x < Screen.dimensionX - 20) {
            this.x = x;
        }
        else {
            throw new Exception("Objekt außerhalb des Bildes");
        }

    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) throws Exception{
        if(y > 0 && y < Screen.dimensionX) {
            this.y = y;
        } else
            throw new Exception("Object außerhalb des Bildes");
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean hit (DrawableObject r) {
        return x < r.getX() + r.getWidth() && x + width > r.getX() && y < r.getY() + r.getHeight() && y + height > r.getY();
    }
}

