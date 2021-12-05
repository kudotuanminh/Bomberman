package com.ntm.bomberman.entities;

import javafx.scene.image.Image;

public abstract class AnimatedEntity extends Entity {
    protected final int MAX_ANIMATE = 600;
    protected int animationFrame = 0;

    public AnimatedEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    protected void animate() {
        if (animationFrame++ > MAX_ANIMATE) {
            animationFrame = 0;
        }
    }
}
