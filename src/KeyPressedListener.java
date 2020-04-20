import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyPressedListener extends KeyAdapter{
    public final static int MOVE_LEFT = KeyEvent.VK_LEFT;
    public final static int MOVE_RIGHT = KeyEvent.VK_RIGHT;
    public final static int SHOOT = KeyEvent.VK_SPACE;

    private final Set<Integer> pressedKeys = new HashSet<Integer>();
    private final List<KeyAdapter> controls = new ArrayList<>();


    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == SHOOT)
            pressedKeys.add(keyEvent.getKeyCode());
        if(keyEvent.getKeyCode() == MOVE_RIGHT   &&  !pressedKeys.contains(MOVE_LEFT))
            pressedKeys.add(keyEvent.getKeyCode());
        else if(keyEvent.getKeyCode() == MOVE_LEFT && !pressedKeys.contains(MOVE_RIGHT))
            pressedKeys.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(pressedKeys.contains(keyEvent.getKeyCode()))
            pressedKeys.remove(keyEvent.getKeyCode());
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

/*
    private class MoveAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    moveSpeedX = -5;
                    break;
                case KeyEvent.VK_RIGHT:
                    moveSpeedX = 5;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            moveSpeedX = 0;
        }
    }*/
}
