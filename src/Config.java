import java.awt.*;

/*
 * interface that holds all
 * basic settings for the game
 */

public interface Config {
    //settings for the Board
    int BOARD_WIDTH = 500;
    int BOARD_HEIGHT = 500;
    int BOARD_BORDER_LEFT = 25;
    int BOARD_BORDER_RIGHT = 25;
    Color BACKGROUND = Color.BLACK;

    //settings for the players character
    int SPACESHIP_WIDTH = 15;
    int SPACESHIP_HEIGHT = 25;
    Color SPACESHIP_COLOR = Color.BLUE;
    int SPACESHIP_GUN_COOLDOWN = 600;

    //settings for the enemies
    int ENEMY_WIDTH = 15;
    int ENEMY_HEIGHT = 25;
    int ENEMY_SPEED = 20;
    Color ENEMY_COLOR = Color.RED;
    int ENEMY_GUN_COOLDOWN = 15000;
    int ENEMY_ENCOUNTERS = 15;

    //settings for the bullet
    int BULLET_WIDTH = 3;
    int BULLET_HEIGHT = 15;
    int BULLET_SPEED = 20;
    Color BULLET_COLOR = Color.YELLOW;
}
