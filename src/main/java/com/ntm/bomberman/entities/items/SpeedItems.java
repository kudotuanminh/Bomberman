package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.input.Keyboard;
import javafx.scene.image.Image;

public class SpeedItems extends Items {
    public SpeedItems(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void checkPlayerCollision() {
        if (BombermanGame.bomberman.getX() == this.getX()
                && BombermanGame.bomberman.getY() == this.getY()) {
            Keyboard.handleSpeedItem();
            remove();
        }
    }
}
