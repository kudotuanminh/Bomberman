package com.ntm.bomberman.entities.objects;

import javafx.scene.image.Image;

/** Held logics for grasses in the game. */
public class Portal extends Objects {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the grass.
     * @param y - y coordinate of the grass.
     * @param img - image of the grass.
     */
    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}