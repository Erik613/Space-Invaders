import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
/*
 * gun class, enabeles game characters
 * to shoot bullets
 */
public class Gun {
    /* gun attributes */
    public final int COOLDOWN;
    private boolean isReady;
    private Timer timer;
    private Bullet.BulletType type;


    public Gun(final int COOLDOWN, Bullet.BulletType type) {
        this.COOLDOWN = COOLDOWN;
        isReady = true;
        timer = new Timer();
        this.type = type;

    }
    public void shoot(int x, int y) {
        if(isReady) {
            Bullet.newBullet(type, x, y);
            isReady = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isReady = true;
                }
            }, COOLDOWN);
        }
    }
}
