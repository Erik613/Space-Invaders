import java.awt.*;

/*
 * interface that holds all
 * basic settings for the game
 */

public interface Config {
    //settings for the Board
    int BOARD_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int BOARD_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    int BOARD_BORDER_LEFT = 25;
    int BOARD_BORDER_RIGHT = 25;

    //settings for the players character
    int SPACESHIP_GUN_COOLDOWN = 600;
    int SPACESHIP_POSITIONY = BOARD_HEIGHT - (BOARD_HEIGHT / 8);
    int SPACESHIP_POSITIONX = BOARD_WIDTH / 2;

    //settings for the enemies
    int ENEMY_SPEED = 1;
    int ENEMY_GUN_COOLDOWN = 0;

    //settings for the bullet
    int BULLET_POSITION_CORRECTION = 25;
    int BULLET_HEIGHT = 15;
    int BULLET_WIDTH = 5;
    int BULLET_SPEED_SPACESHIP = 10;
    int BULLET_SPEED_ENEMY = 5;
    Color BULLET_COLOR = Color.YELLOW;
}
