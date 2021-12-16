package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

/** Held logics for balloons in the game. */
public class Dall extends Enemies {
    public Dall(int x, int y, Image img) {
        super(x, y, img);
        timeCount = 5;
    }

    @Override
    public void update() {
        if (timeCount > 0) {
            timeCount--;
        } else {
            handleMove();
            timeCount = 5;
        }
    }

    private void handleMove() {
        direction = random.nextInt(2);
        int upAndDown = random.nextInt(7);
        if (upAndDown < 6) {
            switch (direction) {
                case 0: // right
                    if (isCanMove(x + speed, y)) {
                        x += speed;
                        img = Sprites.dall_right_1.getFxImage();
                    }
                    break;
                case 1: // left
                    if (isCanMove(x - speed, y)) {
                        x -= speed;
                        img = Sprites.dall_left_1.getFxImage();
                    }
                    break;
            }
        } else {

            switch (direction) {
                case 0: // up
                    if (isCanMove(x, y - speed)) {
                        y -= speed;
                        img = Sprites.dall_left_2.getFxImage();
                    }
                    break;
                case 1: // down
                    if (isCanMove(x, y + speed)) {
                        y += speed;
                        img = Sprites.dall_right_2.getFxImage();
                    }
                    break;
            }
        }
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        return this.collide(entity);
    }
}
