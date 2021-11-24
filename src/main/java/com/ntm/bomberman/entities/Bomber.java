package com.ntm.bomberman.entities;

import javafx.scene.image.Image;

/** Held logics for bombers in the game. */
public class Bomber extends Entity {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the bomber.
     * @param y - y coordinate of the bomber.
     * @param img - image of the bomber.
     */
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
