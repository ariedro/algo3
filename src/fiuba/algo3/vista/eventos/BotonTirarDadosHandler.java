package fiuba.algo3.vista.eventos;


import java.io.File;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;
import fiuba.algo3.excepciones.JugadorYaTiroDadosException;
import fiuba.algo3.vista.VistaAlgoPoly;
import fiuba.algo3.vista.VistaDados;
import fiuba.algo3.vista.VistaInfoJugadores;
import fiuba.algo3.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	
	private final VistaAlgoPoly vistaAlgoPoly;
	private final Button botonFinTurno;
	private final Button botonVender;
	private final Button botonConstruirCasas;
	private final Button botonConstruirHoteles;
	private final Button botonPagarFianza;
	private final Button botonDados;
	
	public BotonTirarDadosHandler(VistaAlgoPoly unaVistaAlgoPoly, Button unBotonFinTurno, 
			Button botonVender, Button botonConstruirCasas, Button botonConstruirHoteles, Button botonPagarFianza, Button unBotonDados) {
	
		this.algoPoly = unaVistaAlgoPoly.getAlgoPoly();
		this.vistaAlgoPoly = unaVistaAlgoPoly;
		this.botonFinTurno = unBotonFinTurno;
		this.botonVender = botonVender;
		this.botonConstruirCasas = botonConstruirCasas;
		this.botonConstruirHoteles = botonConstruirHoteles;
		this.botonPagarFianza = botonPagarFianza;
		this.botonDados = unBotonDados;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = this.algoPoly.getJugadorActual();
		try {
			this.algoPoly.turnar(jugadorActual); 
			new Sonido("res/sonidos/dados.mp3");
		} catch(JugadorYaTiroDadosException e){
			new Alerta("Jugada ilegal","Ya tiraste los dados");
		}
		
		this.vistaAlgoPoly.update();
		this.updateBotonera(jugadorActual);
	}

	
	public void updateBotonera(Jugador jugadorActual) {
		if (jugadorActual.esPerdedor() && algoPoly.sePuedeSeguirJugando()) {
			new Alerta("Lastima","Perdiste");
			this.botonFinTurno.setDisable(true);
		}
		else
			this.botonFinTurno.setDisable(false);
		this.botonVender.setDisable(true);
		this.botonConstruirCasas.setDisable(true);
		this.botonConstruirHoteles.setDisable(true);
		if(this.algoPoly.hayUnGanador()) {
			this.botonFinTurno.setDisable(true);
			this.botonPagarFianza.setDisable(true);
			this.botonDados.setDisable(true);
			new Alerta("FELICITACIONES","Ganaste!");
			new Sonido("res/sonidos/ganador.mp3");
		}
	}

}






