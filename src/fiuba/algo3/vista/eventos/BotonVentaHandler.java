package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.vista.VistaInfoJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonVentaHandler implements EventHandler<ActionEvent> {

	private Comprable comprable;
	
	private AlgoPoly algoPoly;
	
	private Button botonVender;
	
	private VistaInfoJugadores vistaInfoJugadores;
	
	public BotonVentaHandler(Comprable unComprable, AlgoPoly unAlgoPoly, Button unBoton, VistaInfoJugadores unaVista) {
		
		this.comprable = unComprable;
		
		this.algoPoly = unAlgoPoly;
		
		this.botonVender = unBoton;
	
		this.vistaInfoJugadores = unaVista;
	}
	
	public void handle(ActionEvent actionEvent) {
		
		Jugador jugadorActual = algoPoly.getJugadorActual();
		
		jugadorActual.venderPropiedad(this.comprable.getNombre());
		
		this.botonVender.setDisable(true);
		
		this.vistaInfoJugadores.update();
	}
	
}
