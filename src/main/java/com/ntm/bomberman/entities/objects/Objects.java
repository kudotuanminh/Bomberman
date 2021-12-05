package com.ntm.bomberman.entities.objects;

import javafx.scene.image.Image;
import com.ntm.bomberman.entities.*;

/** Held logics for enemies in the game. */
public class Objects extends Entity {
    boolean destroyable;

    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the object.
     * @param y - y coordinate of the object.
     * @param img - image of the balloon.
     */
    public Objects(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}
}
