package com.ntm.bomberman.entities.enemies;

import javafx.scene.image.Image;

/** Held logics for balloons in the game. */
public class Balloon extends Enemies {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the balloon.
     * @param y - y coordinate of the balloon.
     * @param img - image of the balloon.
     */
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
