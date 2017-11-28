package fiuba.algo3.vista.eventos;

import java.io.File;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;
import fiuba.algo3.vista.VistaInfoJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonConstruirHotelHandler implements EventHandler<ActionEvent>{
	
	private final AlgoPoly algoPoly;
	private final Barrio barrio;
	private final Button botonConstruir;
	private final VistaInfoJugadores vistaInfoJugadores;

	public BotonConstruirHotelHandler(Comprable propiedad, AlgoPoly algoPoly, Button botonConstruirHotel, VistaInfoJugadores unaVistaInfo) {
		this.algoPoly = algoPoly;
		this.barrio = (Barrio) propiedad;
		this.botonConstruir = botonConstruirHotel;
		this.vistaInfoJugadores = unaVistaInfo;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = algoPoly.getJugadorActual();
		try {
			jugadorActual.construirHotel(this.barrio.getNombre());
			String musicFile = "res/sonidos/kaching.mp3";     
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
		catch (BarrioNoPuedeConstruirHotelException e) {
			new Alerta("No se puede construir un hotel.");
		}
		vistaInfoJugadores.update();
	}

}
