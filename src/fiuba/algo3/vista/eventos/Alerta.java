package fiuba.algo3.vista.eventos;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {

	public Alerta(String unMensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Advertencia");
		alert.setHeaderText("Jugada ilegal");
		alert.setContentText(unMensaje);
	    alert.show();
	}
	
}
