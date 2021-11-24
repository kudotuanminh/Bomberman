package com.ntm.bomberman.entities.objects;

import javafx.scene.image.Image;

/** Held logics for bricks in the game. */
public class Brick extends Objects {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the brick.
     * @param y - y coordinate of the brick.
     * @param img - image of the brick.
     */
    public Brick(int x, int y, Image img) {
        super(x, y, img);
        this.destroyable = true;
    }

    @Override
    public void update() {}
}
