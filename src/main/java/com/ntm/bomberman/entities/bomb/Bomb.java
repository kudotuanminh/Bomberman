package com.ntm.bomberman.entities.bomb;

import java.util.*;
import javafx.scene.image.Image;
import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.objects.*;
import com.ntm.bomberman.graphics.*;
import com.ntm.bomberman.sound.Sound;

public class Bomb extends AnimatedEntity {
    private int timeToExplodes = 90;

    public static int bombSize = 1;

    private int xLeft = x;
    private int xRight = x;
    private int yTop = y;
    private int yBottom = y;

    boolean leftWalled = false;
    boolean rightWalled = false;
    boolean topWalled = false;
    boolean bottomWalled = false;

    Entity entity_left;
    Entity entity_right;
    Entity entity_top;
    Entity entity_bottom;

    Entity entity_center;
    List<Entity> entities_left;
    List<Entity> entities_right;
    List<Entity> entities_top;
    List<Entity> entities_bottom;

    List<Entity> explosions;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
        explosions = new ArrayList<>();
    }

    @Override
    public void update() {
        if (timeToExplodes > 0) {
            timeToExplodes--;
        } else {
            checkEntities();
            addExplosion();
            BombermanGame.bombExplode(explosions);
            bombExplodes();
        }
        if (timeToExplodes < 20) {
            img = Sprites.bomb_2.getFxImage();
        } else if (timeToExplodes < 70) {
            img = Sprites.bomb_1.getFxImage();
        }
    }

    private void checkEntities() {
        entity_center = BombermanGame.getEntity(x, y);

        entities_left = new ArrayList<>();
        entities_right = new ArrayList<>();
        entities_top = new ArrayList<>();
        entities_bottom = new ArrayList<>();

        for (int i = 0; i < bombSize; i++) {
            xLeft -= Sprite.SCALED_SIZE;
            xRight += Sprite.SCALED_SIZE;
            yTop -= Sprite.SCALED_SIZE;
            yBottom += Sprite.SCALED_SIZE;

            if (!leftWalled) {
                entity_left = BombermanGame.getEntity(xLeft, y);
                if (entity_left instanceof Wall) {
                    leftWalled = true;
                } else {
                    entities_left.add(entity_left);
                    if (entity_left instanceof Brick) {
                        leftWalled = true;
                    }
                }
            }
            if (!rightWalled) {
                entity_right = BombermanGame.getEntity(xRight, y);
                if (entity_right instanceof Wall) {
                    rightWalled = true;

                } else {
                    entities_right.add(entity_right);
                    if (entity_right instanceof Brick) {
                        rightWalled = true;
                    }
                }
            }
            if (!topWalled) {
                entity_top = BombermanGame.getEntity(x, yTop);
                if (entity_top instanceof Wall) {
                    topWalled = true;
                } else {
                    entities_top.add(entity_top);
                    if (entity_top instanceof Brick) {
                        topWalled = true;
                    }
                }
            }
            if (!bottomWalled) {
                entity_bottom = BombermanGame.getEntity(x, yBottom);
                if (entity_bottom instanceof Wall) {
                    bottomWalled = true;
                } else {
                    entities_bottom.add(entity_bottom);
                    if (entity_bottom instanceof Brick) {
                        bottomWalled = true;
                    }
                }
            }
        }
    }

    private void bombExplodes() {
        Sound.play(Sound.explosion);
        if (entity_center instanceof Brick
                || entity_center instanceof MovingEntity) {
            entity_center.remove();
        }
        for (int i = 0; i < entities_left.size(); i++) {
            if (entities_left.get(i) instanceof Brick
                    || entities_left.get(i) instanceof MovingEntity) {
                entities_left.get(i).remove();
            }
        }
        for (int i = 0; i < entities_right.size(); i++) {
            if (entities_right.get(i) instanceof Brick
                    || entities_right.get(i) instanceof MovingEntity) {
                entities_right.get(i).remove();
            }
        }
        for (int i = 0; i < entities_top.size(); i++) {
            if (entities_top.get(i) instanceof Brick
                    || entities_top.get(i) instanceof MovingEntity) {
                entities_top.get(i).remove();
            }
        }
        for (int i = 0; i < entities_bottom.size(); i++) {
            if (entities_bottom.get(i) instanceof Brick
                    || entities_bottom.get(i) instanceof MovingEntity) {
                entities_bottom.get(i).remove();
            }
        }
    }

    private void addExplosion() {
        int a = x / Sprite.SCALED_SIZE;
        int b = y / Sprite.SCALED_SIZE;
        explosions.add(new Explosion(a, b, Sprites.bomb_exploded.getFxImage()));

        for (int i = 0; i < entities_left.size(); i++) {
            a = (x - ((i + 1) * Sprite.SCALED_SIZE)) / Sprite.SCALED_SIZE;
            b = y / Sprite.SCALED_SIZE;
            if (i == entities_left.size() - 1) {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_horizontal_left_last.getFxImage()));
            } else {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_horizontal.getFxImage()));
            }
        }
        for (int i = 0; i < entities_right.size(); i++) {
            a = (x + ((i + 1) * Sprite.SCALED_SIZE)) / Sprite.SCALED_SIZE;
            b = y / Sprite.SCALED_SIZE;
            if (i == entities_right.size() - 1) {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_horizontal_right_last.getFxImage()));
            } else {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_horizontal.getFxImage()));
            }
        }
        for (int i = 0; i < entities_top.size(); i++) {
            a = x / Sprite.SCALED_SIZE;
            b = (y - ((i + 1) * Sprite.SCALED_SIZE)) / Sprite.SCALED_SIZE;
            if (i == entities_top.size() - 1) {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_vertical_top_last.getFxImage()));
            } else {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_vertical.getFxImage()));
            }
        }
        for (int i = 0; i < entities_bottom.size(); i++) {
            a = x / Sprite.SCALED_SIZE;
            b = (y + ((i + 1) * Sprite.SCALED_SIZE)) / Sprite.SCALED_SIZE;
            if (i == entities_bottom.size() - 1) {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_vertical_bottom_last.getFxImage()));
            } else {
                explosions.add(new Explosion(a, b,
                        Sprites.explosion_vertical.getFxImage()));
            }
        }
    }
}
