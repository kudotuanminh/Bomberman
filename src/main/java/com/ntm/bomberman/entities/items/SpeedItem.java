package com.ntm.bomberman.entities.items;

import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.entities.bomb.Bomb;
import com.ntm.bomberman.entities.movingEntities.Bomber;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

public class SpeedItem extends Items {

    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }
    @Override
    public void update(Bomber bomber) {
        bomber.setSpeed(bomber.speed * 2);
    }

    @Override
    public void pickUp(Entity e) {
    }
}
