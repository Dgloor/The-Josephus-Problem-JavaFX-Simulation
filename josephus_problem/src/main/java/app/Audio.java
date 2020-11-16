package app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 *
 * @author danny
 */
public class Audio {

    private final MediaPlayer mediaPlayer;

    public Audio() {
        String path = new File("src/main/resources/sound/music.mp3").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            play();
        });
    }

    public void switchState() {
        if (mediaPlayer.getStatus().equals(Status.PLAYING)) {
            pause();
        } else if (mediaPlayer.getStatus().equals(Status.PAUSED)) {
            play();
        }
    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

}
