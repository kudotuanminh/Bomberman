package com.ntm.bomberman.entities.movingEntities;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.Entity;
import com.ntm.bomberman.entities.bomb.Bomb;
import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.input.Direction;
import javafx.scene.image.Image;

/**
 * Held logics for bombers in the game.
 */
public class Bomber extends MovingEntity {
    private Direction direction = Direction.NONE;
    protected Bomb bomb;

    protected int numOfBomb = 1;
    protected int range = 1;

    /**
     * Constructor function that takes 2 intergers and an image.
     *
     * @param x - x coordinate of the bomber.
     * @param y - y coordinate of the bomber.
     * @param img - image of the bomber.
     */
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (direction != Direction.NONE) {
            if (direction != Direction.NONE) {
                handleMove();
            }
        }
        // checkAlive();
    }

    private void handleMove() {
        if (direction == Direction.UP) {
            if (isCanMove(x, y - speed)) {
                y -= speed;
                img = Sprites.player_up.getFxImage();
            }
        } else if (direction == Direction.DOWN) {
            if (isCanMove(x, y + speed)) {
                y += speed;
                img = Sprites.player_down.getFxImage();
            }
        } else if (direction == Direction.RIGHT) {
            if (isCanMove(x + speed, y)) {
                x += speed;
                img = Sprites.player_right.getFxImage();
            }
        } else if (direction == Direction.LEFT) {
            if (isCanMove(x - speed, y)) {
                x -= speed;
                img = Sprites.player_left.getFxImage();
            }
        }
        direction = Direction.NONE;
    }

    private boolean isCanMove(int x, int y) {
        Entity entity = BombermanGame.getEntity(x, y);
        if (entity == null)
            return true;
        return this.collide(entity);
    }

    private void checkAlive() {
        Entity enemy = BombermanGame.getEnemy(x, y);
        if (enemy != null) {
            remove();
        }
    }

    @Override
    public void remove() {
        super.remove();
        // SoundEffect.play("res/sound/5.wav");
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setBomb() {
        bomb = new Bomb(x / Sprite.SCALED_SIZE, y / Sprite.SCALED_SIZE,
                Sprites.bomb.getFxImage());
        BombermanGame.addBomb(bomb);
    }
}
