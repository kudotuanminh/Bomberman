package com.ntm.bomberman.entities.objects;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

/** Held logics for grasses in the game. */
public class Grass extends Entity {
    /**
     * Constructor function that takes 2 integers and an image.
     *
     * @param x - x coordinate of the grass.
     * @param y - y coordinate of the grass.
     * @param img - image of the grass.
     */
    public Grass(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
