package com.ntm.bomberman.input;

import com.ntm.bomberman.entities.Bomber;
import javafx.scene.input.*;

public class Keyboard {
    private static long THRESHOLD = 300 * 1_000_000L; // 300 ms

    private static long lastMoveNanos;

    public static void handleMovement(KeyEvent event, Bomber bomber) {
        long now = System.nanoTime();
        if (event.getCode() == KeyCode.SPACE) {
            bomber.placeBomb();
        }
        if (lastMoveNanos <= 0L || now - lastMoveNanos >= THRESHOLD) {
            switch (event.getCode()) {
                case UP -> bomber.setDirection(Direction.UP);
                case DOWN -> bomber.setDirection(Direction.DOWN);
                case LEFT -> bomber.setDirection(Direction.LEFT);
                case RIGHT -> bomber.setDirection(Direction.RIGHT);
                default -> {
                }
            }
            lastMoveNanos = now;
        }
    }

    public static void handleSpeedItem() {
        if (THRESHOLD > 100_000_000L) {
            THRESHOLD -= 100_000_000L;
        }
    }
}
