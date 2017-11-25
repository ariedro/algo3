package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonVenderPropiedadesHandler implements EventHandler<ActionEvent>{

	private ContenedorPrincipal contenedor;
	
	private AlgoPoly algoPoly;

	private VBox botoneraAnterior;
	
	
	public BotonVenderPropiedadesHandler(AlgoPoly unAlgoPoly, ContenedorPrincipal unContenedor, VBox unaBotonera){ 
		
		this.algoPoly = unAlgoPoly;
		
		this.contenedor = unContenedor;
		
		this.botoneraAnterior = unaBotonera;
	}

	
	public void handle(ActionEvent actionEvent) {
		
		this.contenedor.setBotoneraVenta(this.algoPoly,this.contenedor, this.botoneraAnterior);
	}
	
}
