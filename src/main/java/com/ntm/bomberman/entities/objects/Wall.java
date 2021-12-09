package com.ntm.bomberman.entities.objects;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

/** Held logics for walls in the game. */
public class Wall extends Entity {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the wall.
     * @param y - y coordinate of the wall.
     * @param img - image of the wall.
     */
    public Wall(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
