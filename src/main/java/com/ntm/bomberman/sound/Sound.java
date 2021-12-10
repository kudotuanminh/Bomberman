package com.ntm.bomberman.sound;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    public Sound() {}

    public static void play(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
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

    public static String level_start = "src/resources/sounds/level_start.wav";
    public static String level_complete =
            "src/resources/sounds/level_complete.wav";
    public static String stage_theme = "src/resources/sounds/stage_theme.wav";

    public static String bomb_placed = "src/resources/sounds/bomb_placed.wav";
    public static String explosion = "src/resources/sounds/explosion.wav";

    public static String bomber_died = "src/resources/sounds/bomber_died.wav";
}
