import java.awt.*;

/**
 * interface that contains all settings
 * all basic settings for the game
 * are stored here
 */
public interface Config {

    /* settings for the Board */
    int BOARD_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int BOARD_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    int BOARD_BORDER_LEFT = 25;
    int BOARD_BORDER_RIGHT = 25;
    int BOARD_BORDER_UP = 25;
    String BOARD_LOGO = "ressources/img/logo.jpg";
    String BOARD_BUTTON = "ressources/img/start_button.png";
    String BOARD_BACKGROUND = "ressources/img/background.png";
    String ICON_WON = "ressources/img/you_win.png";
    String ICON_LOST = "ressources/img/game_over.png";

    /* settings for the players character */
    int SPACESHIP_GUN_COOLDOWN = 600;
    int SPACESHIP_POSITIONY = BOARD_HEIGHT - (BOARD_HEIGHT / 8);
    int SPACESHIP_POSITIONX = BOARD_WIDTH / 2;
    String SPACESHIP_ICON = "ressources/img/baseshipa.png";

    /* settings for the enemies */
    int ENEMY_SPEED = 1;
    int ENEMY_GUN_COOLDOWN = 0;
    String ENEMY_ICON = "ressources/img/alien.png";

    /* settings for the bullet */
    int BULLET_POSITION_CORRECTION = 25;
    int BULLET_HEIGHT = 15;
    int BULLET_WIDTH = 5;
    int BULLET_SPEED_SPACESHIP = 10;
    int BULLET_SPEED_ENEMY = 5;
    Color BULLET_COLOR = Color.YELLOW;
}
