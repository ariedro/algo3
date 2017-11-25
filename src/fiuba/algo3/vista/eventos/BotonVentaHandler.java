package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVentaHandler implements EventHandler<ActionEvent> {

	private Comprable comprable;
	
	private AlgoPoly algoPoly;
	
	public BotonVentaHandler(Comprable unComprable, AlgoPoly unAlgoPoly) {
		
		this.comprable = unComprable;
		
		this.algoPoly = unAlgoPoly;
		
	}
	
	public void handle(ActionEvent actionEvent) {
		
		Jugador jugadorActual = algoPoly.getJugadorActual();
		
		jugadorActual.venderPropiedad(this.comprable.getNombre());
		
	}
	
}
