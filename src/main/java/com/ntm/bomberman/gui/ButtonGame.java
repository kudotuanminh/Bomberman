package com.ntm.bomberman.gui;

import com.ntm.bomberman.BombermanGame;
import com.ntm.bomberman.graphics.Sprite;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import com.ntm.bomberman.BombermanGame;

public class ButtonGame extends Button {
	public ButtonGame( String text ) {
		setText(text);
		setDisable(true);
		setPrefHeight(40);
		setPrefWidth(BombermanGame.WIDTH * Sprite.SCALED_SIZE);
		setAlignment(Pos.CENTER);
		setStyle("-fx-font: 24 arial;" +
				" -fx-background-color: #50a000;" +
				" -fx-text-fill: #ffbe76;");
	}
}
