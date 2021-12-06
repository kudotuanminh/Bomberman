package com.ntm.bomberman.sound;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    public Sound() {
    }

    public static void play(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static Clip getClip(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            return clip;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static String ingame = "sounds/queue.wav";
    public static String bomber_move = "sounds/move.wav";
}
