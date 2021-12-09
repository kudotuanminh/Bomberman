package com.ntm.bomberman.entities.objects;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

/** Held logics for bricks in the game. */
public class Brick extends Entity {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the brick.
     * @param y - y coordinate of the brick.
     * @param img - image of the brick.
     */
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
