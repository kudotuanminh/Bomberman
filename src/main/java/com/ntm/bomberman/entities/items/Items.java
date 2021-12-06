package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.entities.movingEntities.Bomber;
import javafx.scene.image.Image;

public abstract class Items extends Entity {
    public Items(int x, int y, Image img) {
        super(x, y, img);
    }

    public abstract void update(Bomber bomber);

    public abstract void pickUp(Entity e);
}
