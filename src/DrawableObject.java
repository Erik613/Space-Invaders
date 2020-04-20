public class DrawableObject {
    private int x;
    private int y;

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
}

