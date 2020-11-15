package app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author danny
 */
public class Audio {

    private final MediaPlayer mediaPlayer;

    public Audio() {
        String path = "./src/main/resources/sound/sound.mp3";
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(null);
        mediaPlayer.setAutoPlay(true);
    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

}
