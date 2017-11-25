package fiuba.algo3.vista.eventos;
import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVenderPropiedadHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	
	public BotonVenderPropiedadHandler(AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// Hay que reveer como podemos darle de baja una propiedad Comprable
		Jugador unJugador = this.algoPoly.getJugadorActual();
		//unJugador.darDeBajaPropiedad(unaPropiedad);
	}
}
