package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;
import fiuba.algo3.vista.VistaAlgoPoly;
import fiuba.algo3.vista.VistaInfoJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	private final VistaInfoJugadores vistaInfoJugadores;
	
	public BotonPagarFianzaHandler(VistaAlgoPoly vistaAlgoPoly) {
		this.algoPoly = vistaAlgoPoly.getAlgoPoly();
		this.vistaInfoJugadores = vistaAlgoPoly.getVistaInfoJugadores();
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugador = this.algoPoly.getJugadorActual();
		try {
			jugador.pagarFianza();
		} catch(JugadorNoPuedePagarFianzaException e) {
			tirarAlertaQueNoPuedePagarFianza();
		}
		this.vistaInfoJugadores.update();
	}
	
	public void tirarAlertaQueNoPuedePagarFianza() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Jugada ilegal");
        String mensaje = "No podes pagar la fianza";
        alert.setContentText(mensaje);
        
        alert.show();
	}
	
}