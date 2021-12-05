package com.ntm.bomberman.entities.movingEntities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
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
        timeCountDown = 30;
    }

    @Override
    public void update() {
        if (timeCountDown > 0) {
            timeCountDown--;
        } else {
            handleMove();
            timeCountDown = 30;
        }
    }

    private void handleMove() {
        direction = this.randomDirection();
        switch (direction) {
            case 0: // right
                if (isCanMove(x + speed, y)) {
                    x += speed;
                    img = Sprites.balloom_right_1.getFxImage();
                }
                break;
            case 1: // left
                if (isCanMove(x - speed, y)) {
                    x -= speed;
                    img = Sprites.balloom_left_1.getFxImage();
                }
                break;
            case 2: // up
                if (isCanMove(x, y - speed)) {
                    y -= speed;
                    img = Sprites.balloom_left_1.getFxImage();
                }
                break;
            case 3: // down
                if (isCanMove(x, y + speed)) {
                    y += speed;
                    img = Sprites.balloom_right_1.getFxImage();
                }
                break;
        }
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        if (entity instanceof Enemies)
            return false;
        if (entity == null)
            return true;
        return this.collide(entity);
    }
}
