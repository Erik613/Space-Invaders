import java.awt.*;

public interface Config {
    int BOARD_WIDTH = 500;
    int BOARD_HEIGHT = 500;
    int BOARD_BORDER_LEFT = 10;
    int BOARD_BORDER_RIGHT = 10;
    Color BACKGROUND = Color.BLACK;

    int SPACESHIP_WIDTH = 15;
    int SPACESHIP_HEIGHT = 25;
    Color SPACESHIP_COLOR = Color.BLUE;

    int ENEMY_WIDTH = 15;
    int ENEMY_HEIGHT = 25;
    int ENEMY_SPEED = 20;
    Color ENEMY_COLOR = Color.RED;
    int ENEMY_ENTCOUNTERS = 15;

    int BULLET_WIDTH = 3;
    int BULLET_HEIGHT = 15;
    int BULLET_SPEED = 20;
    Color BULLET_COLOR = Color.YELLOW;
}
