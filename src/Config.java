import java.awt.*;

/*
 * interface that holds all
 * basic settings for the game
 */

public interface Config {
    //settings for the Board
    int BOARD_WIDTH = 1042;
    int BOARD_HEIGHT = 720;
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
    Color BULLET_COLOR = Color.YELLOW;
}
