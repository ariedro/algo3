package fiuba.algo3.vista.eventos;

import java.io.File;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirCasaException;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;
import fiuba.algo3.vista.ContenedorPrincipal;
import fiuba.algo3.vista.VistaInfoJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonConstruirCasaHandler implements EventHandler<ActionEvent>{
	
	private final AlgoPoly algoPoly;
	private final Barrio barrio;
	private final Button botonConstruir;
	private final VistaInfoJugadores vistaInfoJugadores;

	public BotonConstruirCasaHandler(Comprable propiedad, AlgoPoly algoPoly, Button botonConstruirCasa, VistaInfoJugadores unaVistaInfo) {
		this.algoPoly = algoPoly;
		this.barrio = (Barrio) propiedad;
		this.botonConstruir = botonConstruirCasa;
		this.vistaInfoJugadores = unaVistaInfo;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = algoPoly.getJugadorActual();
		try {
			jugadorActual.construirCasa(this.barrio.getNombre());
			String musicFile = "res/sonidos/kaching.mp3";     
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		} catch (BarrioNoPuedeConstruirCasaException e) {
			tirarAlerta();
		}
		vistaInfoJugadores.update();
	}
		
		public void tirarAlerta() {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Advertencia");
	        alert.setHeaderText("Jugada ilegal");
	        String mensaje = "No se puede construir un Casa.";
	        alert.setContentText(mensaje);
	        
	        alert.show();
		}

}
