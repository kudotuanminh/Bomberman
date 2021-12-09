package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.graphics.Sprite;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

/** Held logics for balloons in the game. */
public class Balloon extends Enemies {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the balloon.
     * @param y - y coordinate of the balloon.
     * @param img - image of the balloon.
     */
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
        timeCount = 20;
    }

    @Override
    public void update() {
        if (timeCount > 0) {
            timeCount --;
        } else {
            handleMove();
            timeCount = 20;
        }
    }

    private void handleMove() {
        direct = this.randomDirect();
        if (direct == 0) { // right
            if (isCanMove(x + speed , y)) {
                x += speed;
                img = Sprites.balloom_right_1.getFxImage();
            }
        } else if (direct == 1) { // left
            if (isCanMove(x - speed , y)) {
                x -= speed;
                img = Sprites.balloom_left_1.getFxImage();
            }
        } else if (direct == 2) { // up
            if (isCanMove(x , y - speed)) {
                y -= speed;
                img = Sprites.balloom_left_1.getFxImage();
            }
        } else if (direct == 3) { // down
            if (isCanMove(x , y + speed)) {
                y += speed;
                img = Sprites.balloom_right_1.getFxImage();
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
