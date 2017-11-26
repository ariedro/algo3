package fiuba.algo3.vista.eventos;


import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	
	public BotonTirarDadosHandler(AlgoPoly juego) {
		this.algoPoly = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = this.algoPoly.getJugadorActual();
		this.algoPoly.turnar(jugadorActual); 
		//Acá tira error cuando quiere reubicar en el tablero al jugador, no 
		//entiendo por qué devuelve un casillero(pero eso no seria el problema)
		//el problema esta cuando llama a reubicarlo en el tablero
	}

}






