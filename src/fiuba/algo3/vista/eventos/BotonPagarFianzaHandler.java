package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	
	public BotonPagarFianzaHandler(AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugador = this.algoPoly.getJugadorActual();
		if(!jugador.puedeAccionar()) {
			jugador.pagarFianza();
		}
	}
}
