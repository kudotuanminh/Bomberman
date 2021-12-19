package com.ntm.bomberman.sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import com.ntm.bomberman.BombermanGame;

public class Sound {
    public Sound() {}

    public static void play(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    BombermanGame.class.getClassLoader().getResource(path)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void stop() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.stop();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static String level_start = "sounds/level_start.wav";
    public static String level_complete = "sounds/level_complete.wav";
    public static String stage_theme = "sounds/stage_theme.wav";

    public static String item = "sounds/item.wav";

    public static String bomb_placed = "sounds/bomb_placed.wav";
    public static String explosion = "sounds/explosion.wav";

    public static String bomber_died = "sounds/bomber_died.wav";
    public static String enemy_died = "sounds/enemy_died.wav";
}
