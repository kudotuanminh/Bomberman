package com.ntm.bomberman.entities.objects;

import com.ntm.bomberman.entities.Entity;
import javafx.scene.image.Image;

/** Held logics for portals in the game. */
public class Portal extends Entity {
    /**
     * Constructor function that takes 2 integers and an image.
     *
     * @param x - x coordinate of the portal.
     * @param y - y coordinate of the portal.
     * @param img - image of the portal.
     */
    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
