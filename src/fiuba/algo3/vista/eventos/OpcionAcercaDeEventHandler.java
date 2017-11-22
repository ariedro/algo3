package fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Acerca de...");
        String mensaje = "- Trabajo Práctico 2 de Algoritmos y  programación III.\n"
        		+ "- Grupo 10";
        alert.setContentText(mensaje);
        
        alert.show();
    }
}
