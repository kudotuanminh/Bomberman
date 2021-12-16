package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

/** Held logics for oneals in the game. */
public class Oneal extends Enemies {
    /**
     * Constructor function that takes 2 integers and an image.
     *
     * @param x - x coordinate of the oneal.
     * @param y - y coordinate of the oneal.
     * @param img - image of the oneal.
     */
    public Oneal(int x, int y, Image img) {
        super(x, y, img);
        timeCount = 10;
    }

    @Override
    public void update() {
        if (timeCount > 0) {
            timeCount--;
        } else {
            handleMove();
            timeCount = 10;
        }
    }

    private void handleMove() {
        boolean randomPathOrNot = random.nextBoolean();
        if (randomPathOrNot) {
            direction = this.randomDirection();
        } else {
            direction = this.bestDirection();
        }
        switch (direction) {
            case 0 -> { // right
                if (isCanMove(x + speed, y)) {
                    x += speed;
                    img = Sprites.oneal_right_1.getFxImage();
                }
            }
            case 1 -> { // left
                if (isCanMove(x - speed, y)) {
                    x -= speed;
                    img = Sprites.oneal_left_1.getFxImage();
                }
            }
            case 2 -> { // up
                if (isCanMove(x, y - speed)) {
                    y -= speed;
                    img = Sprites.oneal_left_1.getFxImage();
                }
            }
            case 3 -> { // down
                if (isCanMove(x, y + speed)) {
                    y += speed;
                    img = Sprites.oneal_right_1.getFxImage();
                }
            }
        }
    }

    private int bestDirection() {
        int xBomber = BombermanGame.bomberman.getX();
        int yBomber = BombermanGame.bomberman.getY();

        if (xBomber > x) {
            return 0;
        } else if (xBomber < x) {
            return 1;
        } else if (yBomber > y) {
            return 2;
        } else {
            return 3;
        }
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        return this.collide(entity);
    }
}
