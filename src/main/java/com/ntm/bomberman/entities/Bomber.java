package com.ntm.bomberman.entities;

import java.util.*;
import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.bomb.Bomb;
import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.input.Direction;
import com.ntm.bomberman.sound.Sound;
import javafx.scene.image.Image;

/**
 * Held logics for bombers in the game.
 */
public class Bomber extends MovingEntity {
    private Direction direction = Direction.NONE;

    public int placedBombs = 0;
    public int maxBombs = 1;

    public List<Bomb> bombs = new ArrayList<>();

    /**
     * Constructor function that takes 2 integers and an image.
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
            handleMove();
        }
        checkAlive();
        recountBombs();
    }

    private void handleMove() {
        // Sound.play(Sound.bomber_move);
        if (direction == Direction.RIGHT) {
            if (isCanMove(x + Sprite.SCALED_SIZE, y)) {
                x += speed;
                img = Sprites.player_right.getFxImage();
            }
        } else if (direction == Direction.LEFT) {
            if (isCanMove(x - Sprite.SCALED_SIZE, y)) {
                x -= speed;
                img = Sprites.player_left.getFxImage();
            }
        } else if (direction == Direction.UP) {
            if (isCanMove(x, y - Sprite.SCALED_SIZE)) {
                y -= speed;
                img = Sprites.player_up.getFxImage();
            }
        } else if (direction == Direction.DOWN) {
            if (isCanMove(x, y + Sprite.SCALED_SIZE)) {
                y += speed;
                img = Sprites.player_down.getFxImage();
            }
        }
        direction = Direction.NONE;
    }

    private boolean isCanMove(int a, int b) {
        Entity entity = BombermanGame.getEntity(a, b);
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
        img = Sprites.player_dead_1.getFxImage();
        Sound.play(Sound.bomber_died);
        super.remove();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void placeBomb() {
        boolean ableToPlaceBomb = true;
        int x_bomb = (BombermanGame.bomberman.getX() / Sprite.SCALED_SIZE);
        int y_bomb = (BombermanGame.bomberman.getY() / Sprite.SCALED_SIZE);
        for (Entity bomb : bombs) {
            if (bomb.getX() == x_bomb && bomb.getY() == y_bomb) {
                ableToPlaceBomb = false;
                break;
            }
        }
        if (placedBombs < maxBombs && ableToPlaceBomb) {
            Bomb bomb = new Bomb(x_bomb, y_bomb, Sprites.bomb.getFxImage());
            bombs.add(bomb);
            Sound.play(Sound.bomb_placed);
        }
        placedBombs++;
    }

    private void recountBombs() {
        placedBombs = bombs.size();
        for (int i = 0; i < bombs.size(); i++) {
            if (bombs.get(i).isRemoved()) {
                bombs.remove(i);
                --i;
            }
        }
    }
}
