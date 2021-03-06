import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  class
 */
public class KeyPressedListener extends KeyAdapter{
    public final static int MOVE_LEFT = KeyEvent.VK_LEFT;
    public final static int MOVE_RIGHT = KeyEvent.VK_RIGHT;
    public final static int SHOOT = KeyEvent.VK_SPACE;

    private final Set<Integer> pressedKeys = new HashSet<Integer>();
    //private final List<KeyAdapter> controls = new ArrayList<>();


    /**
     * checks witch key is pressed
     * @param keyEvent what event is triggered
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == SHOOT)
            pressedKeys.add(keyEvent.getKeyCode());
        if(keyEvent.getKeyCode() == MOVE_RIGHT   &&  !pressedKeys.contains(MOVE_LEFT))
            pressedKeys.add(keyEvent.getKeyCode());
        else if(keyEvent.getKeyCode() == MOVE_LEFT && !pressedKeys.contains(MOVE_RIGHT))
            pressedKeys.add(keyEvent.getKeyCode());
    }

    /**
     * checks if key is released
     * @param keyEvent resets key event
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(pressedKeys.contains(keyEvent.getKeyCode()))
            pressedKeys.remove(keyEvent.getKeyCode());
    }

    /**
     * @return
     */
    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

}
