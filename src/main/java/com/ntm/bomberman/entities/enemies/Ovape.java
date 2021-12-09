package com.ntm.bomberman.entities.enemies;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.entities.objects.Brick;
import com.ntm.bomberman.graphics.Sprites;
import javafx.scene.image.Image;

public class Ovape extends Enemies {
    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the oneal.
     * @param y - y coordinate of the oneal.
     * @param img - image of the oneal.
     */
    public Ovape(int x, int y, Image img) {
        super(x, y, img);
        timeCountDown = 10;
    }

    @Override
    public void update() {
        if (timeCountDown > 0) {
            timeCountDown--;
        } else {
            handleMove();
            timeCountDown = 10;
        }
    }

    private void handleMove() {
        direction = this.randomDirection();
        switch (direction) {
            case 0: // right
                if (isCanMove(x + speed, y)) {
                    x += speed;
                    img = Sprites.ovape_right_1.getFxImage();
                }
                break;
            case 1: // left
                if (isCanMove(x - speed, y)) {
                    x -= speed;
                    img = Sprites.ovape_left_1.getFxImage();
                }
                break;
            case 2: // up
                if (isCanMove(x, y - speed)) {
                    y -= speed;
                    img = Sprites.ovape_left_2.getFxImage();
                }
                break;
            case 3: // down
                if (isCanMove(x, y + speed)) {
                    y += speed;
                    img = Sprites.ovape_right_2.getFxImage();
                }
                break;
        }
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        if (entity instanceof Enemies)
            return true;
        if (entity instanceof Brick)
            return true;
        if (entity == null)
            return false;
        return this.collide(entity);
    }
}
