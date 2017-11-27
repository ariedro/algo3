package fiuba.algo3.vista.eventos;
import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.VistaInfoJugadores;
import fiuba.algo3.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	private VistaTablero vistaTablero;
	private VistaInfoJugadores vistaInfoJugadores;
	private final Button botonFinTurno;
	
	public BotonFinalizarTurnoHandler(VistaTablero unaVistaTablero, VistaInfoJugadores unaVistaInfoJugadores, AlgoPoly algoPoly, Button unBotonFinTurno) {
		this.algoPoly = algoPoly;
		this.vistaTablero = unaVistaTablero;
		this.botonFinTurno = unBotonFinTurno;
		this.vistaInfoJugadores = unaVistaInfoJugadores;
	}

	@Override
	public void handle(ActionEvent event) {
		this.algoPoly.acabarTurno();
		this.vistaTablero.update();
		this.vistaInfoJugadores.update();
		this.botonFinTurno.setDisable(true);
	}

}
