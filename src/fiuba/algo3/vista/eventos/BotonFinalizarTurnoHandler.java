package fiuba.algo3.vista.eventos;
import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.VistaAlgoPoly;
import fiuba.algo3.vista.VistaInfoJugadores;
import fiuba.algo3.vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent>{

	
	
	private final AlgoPoly algoPoly;
	private VistaAlgoPoly vistaAlgoPoly;
	
	private final Button botonFinTurno;
	private final Button botonDados;
	private final Button botonVender;
	private final Button botonConstruirCasas;
	private final Button botonConstruirHoteles;
	
	public BotonFinalizarTurnoHandler(VistaAlgoPoly unaVistaAlgoPoly, Button unBotonFinTurno, Button botonDados, Button botonVender, 
			Button botonConstruirCasas, Button botonConstruirHoteles) {
		
		
		
		this.algoPoly = unaVistaAlgoPoly.getAlgoPoly();
		this.vistaAlgoPoly = unaVistaAlgoPoly;
		this.botonFinTurno = unBotonFinTurno;
		this.botonDados = botonDados;
		this.botonVender = botonVender;
		this.botonConstruirCasas = botonConstruirCasas;
		this.botonConstruirHoteles = botonConstruirHoteles;
	}

	@Override
	public void handle(ActionEvent event) {
		this.algoPoly.acabarTurno();
		this.vistaAlgoPoly.update();
		this.botonFinTurno.setDisable(true);
		this.considerarLosDemasBotones();
	}

	public void considerarLosDemasBotones() {
		if (this.algoPoly.getJugadorActual().estaEnCana()) {
			this.botonFinTurno.setDisable(false);
			this.botonDados.setDisable(true);
			this.botonVender.setDisable(true);
			this.botonConstruirCasas.setDisable(true);
			this.botonConstruirHoteles.setDisable(true);
		}
		else {
			this.botonDados.setDisable(false);
			this.botonVender.setDisable(false);
			this.botonConstruirCasas.setDisable(false);
			this.botonConstruirHoteles.setDisable(false);
		}
	}
	
}