package com.ntm.bomberman.entities.movingEntities.enemies;

import java.util.Random;
import com.ntm.bomberman.entities.movingEntities.*;
import javafx.scene.image.Image;

/** Held logics for enemies in the game. */
public abstract class Enemies extends MovingEntity {
    protected Random random = new Random();
    protected int direction = -1;
    protected int timeCountDown;

    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the enemy.
     * @param y - y coordinate of the enemy.
     * @param img - image of the enemy.
     */
    public Enemies(int x, int y, Image img) {
        super(x, y, img);
    }

    protected int randomDirection() {
        return random.nextInt(4);
    }
}
