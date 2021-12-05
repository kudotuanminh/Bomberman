package com.ntm.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import com.ntm.bomberman.graphics.*;

/** Held logics for every entities of the game. */
public abstract class Entity {
    /** @param x - x coordinate of the entity. */
    protected int x;
    /** @param y - y coordinate of the entity. */
    protected int y;
    /** @param img - image of the entity. */
    protected Image img;
    protected boolean isRemoved = false;

    public Entity(int x, int y) {
        this.x = x * Sprite.SCALED_SIZE;
        this.y = y * Sprite.SCALED_SIZE;
    }

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

    public boolean compareCoordinate(int x, int y) {
        return this.x == x && this.y == y;
    }
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();

    public void remove() {
        isRemoved = true;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
