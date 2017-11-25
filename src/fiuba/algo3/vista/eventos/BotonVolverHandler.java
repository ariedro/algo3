package fiuba.algo3.vista.eventos;

import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonVolverHandler implements EventHandler<ActionEvent> {
	
	private VBox botoneraAnterior;
	
	private ContenedorPrincipal contenedorPrincipal;
	
	public BotonVolverHandler(VBox unaBotonera, ContenedorPrincipal unContenedor) {
		
		this.botoneraAnterior = unaBotonera;
		
		this.contenedorPrincipal = unContenedor;
		
	}
	
	public void handle(ActionEvent actionEvent) {
		
		this.contenedorPrincipal.setLeft(botoneraAnterior);
	}
	
	
}
