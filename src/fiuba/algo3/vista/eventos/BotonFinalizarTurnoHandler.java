package fiuba.algo3.vista.eventos;
import fiuba.algo3.clases.AlgoPoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent>{

	private final AlgoPoly algoPoly;
	
	public BotonFinalizarTurnoHandler(AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
	}

	@Override
	public void handle(ActionEvent event) {
		this.algoPoly.acabarTurno();
	}

}
