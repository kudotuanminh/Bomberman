package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.bomb.Bomb;
import javafx.scene.image.Image;

public class FlameItems extends Items {
    public FlameItems(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void checkPlayerCollision() {
        if (BombermanGame.bomberman.getX() == this.getX()
                && BombermanGame.bomberman.getY() == this.getY()) {
            Bomb.bombSize++;
            remove();
        }
    }
}
