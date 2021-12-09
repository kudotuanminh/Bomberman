package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

/** Held logics for balloons in the game. */
public class Oneal extends Enemies {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the balloon.
     * @param y - y coordinate of the balloon.
     * @param img - image of the balloon.
     */
    public Oneal(int x, int y, Image img) {
        super(x, y, img);
        timeCount = 10;
    }

    @Override
    public void update() {
        if (timeCount > 0){
            timeCount--;
        }else {
            handleMove();
            timeCount = 10;
        }
    }

    private void handleMove() {
        direct = this.randomDirect();
        if (direct == 0) { // right
            if (isCanMove(x + speed , y)) {
                x += speed;
                img = Sprites.oneal_right_1.getFxImage();
            }
        } else if (direct == 1) { // left
            if (isCanMove(x - speed , y)) {
                x -= speed;
                img = Sprites.oneal_left_1.getFxImage();
            }
        } else if (direct == 2) { // up
            if (isCanMove(x , y - speed)) {
                y -= speed;
                img = Sprites.oneal_left_1.getFxImage();
            }
        } else if (direct == 3) { // down
            if (isCanMove(x , y + speed)) {
                y += speed;
                img = Sprites.oneal_right_1.getFxImage();
            }
        }
    }

    private boolean isCanMove( int x , int y ) {
        Entity entity = BombermanGame.getEntity(x , y);
        if (entity instanceof Enemies) return false;
        if (entity == null) return true;
        return this.collide(entity);
    }
}