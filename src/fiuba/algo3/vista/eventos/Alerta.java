package fiuba.algo3.vista.eventos;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {

	public Alerta(String unTitulo, String unMensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Advertencia");
		alert.setHeaderText(unTitulo);
		alert.setContentText(unMensaje);
	    alert.show();
	}
	
}
