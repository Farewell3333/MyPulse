package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Method {
    static Integer addFromField(String text, JLabel label) {
        int number = 0;
        label.setVisible(false);
        try {
            number = Integer.parseInt(text);
            label.setText("Wprowadzono liczbe "+text);
            label.setVisible(true);

        } catch (NumberFormatException ex) {
            label.setText("BLAD WPISU!!!!");
            label.setVisible(true);
        }
        return number;
    }
    static void playSound(File file){
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }
}
