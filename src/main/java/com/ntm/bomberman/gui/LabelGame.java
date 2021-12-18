package com.ntm.bomberman.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import com.ntm.bomberman.graphics.Sprite;
import com.ntm.bomberman.BombermanGame;

public class LabelGame extends Label {
    public LabelGame() {
        setPrefWidth(Sprite.SCALED_SIZE * BombermanGame.WIDTH);
        setPrefHeight(Sprite.SCALED_SIZE * 2);
        setAlignment(Pos.CENTER);
        setStyle("-fx-font: 30 arial;" + " -fx-font-weight: bold;"
                + " -fx-background-color: #96C781;" + " -fx-text-fill: green;");
    }
}
