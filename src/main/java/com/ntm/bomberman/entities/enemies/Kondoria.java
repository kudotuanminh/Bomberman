package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.entities.objects.Brick;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

public class Kondoria extends Enemies {
    /**
     * Constructor function that takes 2 integers and an image.
     *
     * @param x - x coordinate of the kondoria.
     * @param y - y coordinate of the kondoria.
     * @param img - image of the kondoria.
     */
    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
        timeCount = 50;
    }

    @Override
    public void update() {
        if (timeCount > 0) {
            timeCount--;
        } else {
            handleMove();
            timeCount = 50;
        }
    }

    private void handleMove() {
        direction = this.randomDirection();
        switch (direction) {
            case 0: // right
                if (isCanMove(x + speed, y)) {
                    x += speed;
                    img = Sprites.kondoria_right_1.getFxImage();
                }
                break;
            case 1: // left
                if (isCanMove(x - speed, y)) {
                    x -= speed;
                    img = Sprites.kondoria_left_1.getFxImage();
                }
                break;
            case 2: // up
                if (isCanMove(x, y - speed)) {
                    y -= speed;
                    img = Sprites.kondoria_left_2.getFxImage();
                }
                break;
            case 3: // down
                if (isCanMove(x, y + speed)) {
                    y += speed;
                    img = Sprites.kondoria_right_2.getFxImage();
                }
                break;
        }
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        if (entity instanceof Brick)
            return true;
        return this.collide(entity);
    }
}