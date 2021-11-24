package com.ntm.bomberman.entities.enemies;

import javafx.scene.image.Image;
import com.ntm.bomberman.entities.*;

/** Held logics for enemies in the game. */
public class Enemies extends Entity {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the balloon.
     * @param y - y coordinate of the balloon.
     * @param img - image of the balloon.
     */
    public Enemies(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
