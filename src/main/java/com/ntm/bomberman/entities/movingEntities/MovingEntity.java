package com.ntm.bomberman.entities.movingEntities;

import com.ntm.bomberman.entities.*;
import com.ntm.bomberman.entities.objects.Grass;
import com.ntm.bomberman.graphics.Sprite;
import javafx.scene.image.Image;

public abstract class MovingEntity extends AnimatedEntity {
    public int speed = Sprite.SCALED_SIZE;

    public void setSpeed(int speed) {
        this.speed = Sprite.SCALED_SIZE;
    }

    public int getSpeed() {
        return speed;
    }

    public MovingEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    protected boolean collide(Entity entity) {
        return (entity instanceof Grass || entity instanceof MovingEntity);
    }
}
