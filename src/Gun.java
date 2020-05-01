
import java.util.Timer;
import java.util.TimerTask;
/**
 * gun class
 * enables game characters
 * to shoot bullets
 */
public class Gun {
    /* gun attributes */
    public final int COOLDOWN;      //time after which next bullet can be shot
    private boolean isReady;        //indication if gun can shoot
    private Timer timer;
    private Bullet.BulletType type; //indication if gun belongs to player/enemy


    /**
     * constructor for gun
     * @param COOLDOWN after which time can be shot again
     * @param type if Gun is for enemy or player
     */
    public Gun(final int COOLDOWN, Bullet.BulletType type) {
        this.COOLDOWN = COOLDOWN;
        isReady = true;
        timer = new Timer();
        this.type = type;

    }

    /**
     * shoot bullet if able
     * @param x X Position for the Bullet
     * @param y Y Position for the Bullet
     */
    public void shoot(int x, int y) {
        if(isReady) {           //if gun can fire
            Bullet.newBullet(type, x, y);   //create new Bullet
            isReady = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isReady = true;
                }
            }, COOLDOWN);   //only after timer reaches 0, gun can shoot again
        }
    }
}
