import java.util.Timer;
import java.util.TimerTask;

public class Gun {
    public final int COOLDOWN;
    private boolean isReady;
    private Timer timer;


    public Gun(final int COOLDOWN) {
        this.COOLDOWN = COOLDOWN;
        isReady = true;
        timer = new Timer();

    }
    public void shoot(int x) {
        if(isReady) {
            new Bullet(x);
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
