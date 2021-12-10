package com.ntm.bomberman.entities.bomb;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

public class Explosion extends Entity {
    private int time = 20;

    public Explosion(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (time > 0) {
            time--;
        } else {
            this.remove();
        }
    }
}
