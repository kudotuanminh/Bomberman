package com.ntm.bomberman.entities.enemies;

import javafx.scene.image.Image;
import com.ntm.bomberman.entities.*;

import java.util.Random;

/** Held logics for enemies in the game. */
public abstract class Enemies extends MovingEntity {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the balloon.
     * @param y - y coordinate of the balloon.
     * @param img - image of the balloon.
     */

    protected Random random = new Random();
    protected int direct = -1;
    protected int timeCount;
    public Enemies(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {}

    protected int randomDirect() {
        return random.nextInt(4);
    }
}
