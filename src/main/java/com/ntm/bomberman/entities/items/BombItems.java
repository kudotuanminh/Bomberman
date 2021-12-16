package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.BombermanGame;
import javafx.scene.image.Image;

public class BombItems extends Items {
    public BombItems(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void checkPlayerCollision() {
        if (BombermanGame.bomberman.getX() == this.getX()
                && BombermanGame.bomberman.getY() == this.getY()) {
            BombermanGame.bomberman.maxBombs++;
            remove();
        }
    }
}
