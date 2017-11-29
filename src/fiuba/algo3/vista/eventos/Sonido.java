package fiuba.algo3.vista.eventos;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sonido {

	public Sonido(String unaDireccion) {
		Media sound = new Media(new File(unaDireccion).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
}
