package com.ntm.bomberman.entities;

import com.ntm.bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.awt.*;

public abstract class MovingEntity extends Entity{
    protected int speed = Sprite.SCALED_SIZE;

    public MovingEntity(int x, int y, Image img) {
        super(x, y, img);
    }
}
