package com.ntm.bomberman.input;

import com.ntm.bomberman.entities.movingEntities.Bomber;
import com.ntm.bomberman.sound.Sound;
import javafx.scene.input.*;

public class Keyboard {
    public static void handleMovement(KeyEvent event, Bomber bomber) {
        if (event.getCode() == KeyCode.RIGHT) {
            bomber.setDirection(Direction.RIGHT);
        }
        if (event.getCode() == KeyCode.LEFT) {
            bomber.setDirection(Direction.LEFT);
        }
        if (event.getCode() == KeyCode.UP) {
            bomber.setDirection(Direction.UP);
        }
        if (event.getCode() == KeyCode.DOWN) {
            bomber.setDirection(Direction.DOWN);
        }
        if (event.getCode() == KeyCode.SPACE) {
            bomber.setBomb();
        }
    }
}
