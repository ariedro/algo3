package fiuba.algo3.vista.eventos;


import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;
import fiuba.algo3.excepciones.JugadorYaTiroDadosException;
import fiuba.algo3.vista.VistaDados;
import fiuba.algo3.vista.VistaTablero;
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
	private final VistaTablero vistaTablero;
	private final VistaDados vistaDados;
	
	public BotonTirarDadosHandler(VistaTablero unaVistaTablero, VistaDados unaVistaDados, AlgoPoly juego) {
		this.algoPoly = juego;
		this.vistaTablero = unaVistaTablero;
		this.vistaDados = unaVistaDados;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = this.algoPoly.getJugadorActual();
		try {
			this.algoPoly.turnar(jugadorActual);			
		} catch(JugadorYaTiroDadosException e){
			tirarAlertaQueYaTiroDados();
		}
		this.vistaTablero.update();
		this.vistaDados.update();
		//Acá tira error cuando quiere reubicar en el tablero al jugador, no 
		//entiendo por qué devuelve un casillero(pero eso no seria el problema)
		//el problema esta cuando llama a reubicarlo en el tablero
	}
	
	public void tirarAlertaQueYaTiroDados() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Jugada ilegal");
        String mensaje = "Ya tiraste los dados";
        alert.setContentText(mensaje);
        
        alert.show();
	}
	
}






