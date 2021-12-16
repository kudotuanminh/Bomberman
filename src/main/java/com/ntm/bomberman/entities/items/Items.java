package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

public abstract class Items extends Entity {
    public Items(int x, int y, Image img) {
        super(x, y, img);
    }

    public void checkPlayerCollision() {}

    @Override
    public void update() {
        checkPlayerCollision();
    }
}
