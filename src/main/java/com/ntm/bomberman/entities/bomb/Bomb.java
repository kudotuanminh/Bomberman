package com.ntm.bomberman.entities.bomb;

import java.util.*;
import javafx.scene.image.Image;
import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.movingEntities.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.graphics.*;

public class Bomb extends AnimatedEntity {
    private int timeToExplodes = 100; // 100 seconds
    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;
    Entity entity_left;
    Entity entity_right;
    Entity entity_up;
    Entity entity_down;
    Entity entity_center;

    public List<Entity> explosions;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        this.explosions = new ArrayList<>();
    }

    @Override
    public void update() {
        xLeft = x - Sprite.SCALED_SIZE;
        xRight = x + Sprite.SCALED_SIZE;
        yTop = y - Sprite.SCALED_SIZE;
        yBottom = y + Sprite.SCALED_SIZE;
        entity_left = BombermanGame.getEntity(xLeft, y);
        entity_right = BombermanGame.getEntity(xRight, y);
        entity_up = BombermanGame.getEntity(x, yTop);
        entity_down = BombermanGame.getEntity(x, yBottom);
        entity_center = BombermanGame.getEntity(x, y);
        if (timeToExplodes > 0) {
            timeToExplodes--;
        } else {
            addExplosion();
            BombermanGame.bombExplode(explosions);
            bomExplodes();
        }
        if (timeToExplodes < 20) {
            img = Sprites.bomb_2.getFxImage();
        } else if (timeToExplodes < 70) {
            img = Sprites.bomb_1.getFxImage();
        }

    }

    private void bomExplodes() {
        if (entity_left instanceof Brick
                || entity_left instanceof MovingEntity) {
            entity_left.remove();
        }
        if (entity_right instanceof Brick
                || entity_right instanceof MovingEntity) {
            entity_right.remove();
        }
        if (entity_up instanceof Brick || entity_up instanceof MovingEntity) {
            entity_up.remove();
        }
        if (entity_down instanceof Brick
                || entity_down instanceof MovingEntity) {
            entity_down.remove();
        }
        if (entity_center instanceof Brick
                || entity_center instanceof MovingEntity) {
            entity_center.remove();
        }
    }

    private void addExplosion() {
        if (!(entity_left instanceof Wall)) {
            explosions.add(new Explosion(xLeft / 32, y / 32,
                    Sprites.explosion_horizontal_1.getFxImage()));
        }
        if (!(entity_right instanceof Wall)) {
            explosions.add(new Explosion(xRight / 32, y / 32,
                    Sprites.explosion_horizontal_2.getFxImage()));
        }
        if (!(entity_up instanceof Wall)) {
            explosions.add(new Explosion(x / 32, yTop / 32,
                    Sprites.explosion_vertical_2.getFxImage()));
        }
        if (!(entity_down instanceof Wall)) {
            explosions.add(new Explosion(x / 32, yBottom / 32,
                    Sprites.explosion_vertical_1.getFxImage()));
        }
        explosions.add(new Explosion(x / 32, y / 32,
                Sprites.bomb_exploded_2.getFxImage()));
    }
}
