import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameSound {
    AudioInputStream audio;
    String path;
    File file;
    Clip player;
    public GameSound(String path){
        this.path=path;
        play();
    }

    void play() {
        try {
            file=new File(path);
            audio= AudioSystem.getAudioInputStream(file);
            player=AudioSystem.getClip();
            player.open(audio);
            player.start();
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}
