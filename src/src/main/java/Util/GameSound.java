package Util;

import com.sun.jdi.FloatType;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class GameSound {
    AudioInputStream audio;
    String path;
    File file;
    Clip player;
    FloatControl volume;
    BooleanControl boo;
    public GameSound(String path) {
        this.path = path;
        try {
            file = new File(path);
            audio = AudioSystem.getAudioInputStream(file);
            player = AudioSystem.getClip();
            player.open(audio);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    public void play() {
        player.start();
    }
    public void stop() {
        player.stop();
        player.setFramePosition(0);
    }
    public void loop() {
        player.loop(20);
    }
    float getVolume() {
        volume = (FloatControl) player.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10, volume.getValue());
    }
    public void setVolume(float value) {
        volume = (FloatControl) player.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(value);
    }
    void muteVolume() {
        boo = (BooleanControl) player.getControl(BooleanControl.Type.MUTE);
        boo.setValue(true);
    }
    void unmuteVolume() {
        boo = (BooleanControl) player.getControl(BooleanControl.Type.MUTE);
        boo.setValue(false);
    }
}















