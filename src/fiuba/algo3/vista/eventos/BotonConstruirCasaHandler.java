package fiuba.algo3.vista.eventos;

import java.io.File;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.excepciones.BarrioNecesitaVecinoParaConstruirCasaException;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirCasaException;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;
import fiuba.algo3.excepciones.BarrioYaTieneTodasLasCasasConstruidasException;
import fiuba.algo3.excepciones.JugadorNoTieneDineroException;
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
		} catch (JugadorNoTieneDineroException e1) {
			new Alerta("No tienes dinero para comprar esta casa.");
		} catch (BarrioNoPuedeConstruirCasaException e2) {
			new Alerta("No se puede construir una casa.");
		} catch (BarrioNecesitaVecinoParaConstruirCasaException e3) {
			new Alerta("Necesitas tener la propiedad de " + this.barrio.getVecino() + " para poder construir una casa aca");
		} catch (BarrioYaTieneTodasLasCasasConstruidasException e4) {
			new Alerta(this.barrio.getNombre() + " ya tiene todas las casas construidas");
		}
		vistaInfoJugadores.update();

	}
}