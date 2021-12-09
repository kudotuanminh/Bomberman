package com.ntm.bomberman.graphics;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** Held logics for the spritesheet of every sprite in the game. */
public class SpriteSheet {
    public static SpriteSheet tiles =
            new SpriteSheet("./src/resources/textures/classic.png", 256);

    private String path;
    private BufferedImage image;
    private final int SIZE;
    private int[] pixels;

    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        this.pixels = new int[SIZE * SIZE];
        load();
    }

    public int getSIZE() {
        return this.SIZE;
    }

    public int[] getPixels() {
        return this.pixels;
    }

    private void load() {
        try {
            image = ImageIO.read(new File(this.path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, this.pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}