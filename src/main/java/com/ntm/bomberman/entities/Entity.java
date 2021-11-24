package com.ntm.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import com.ntm.bomberman.graphics.*;

/** Held logics for every entities of the game. */
public abstract class Entity {
    /** @param x - x coordinate of the entity. */
    private double x;
    /** @param y - y coordinate of the entity. */
    private double y;
    /** @param img - image of the entity. */
    private Image img;

    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the entity.
     * @param y - y coordinate of the entity.
     * @param img - image of the entity.
     */
    public Entity(int x, int y, Image img) {
        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
