package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonConstruirHotelesHandler implements EventHandler<ActionEvent>{
	
	private final AlgoPoly algoPoly;
	private final ContenedorPrincipal contenedorPrincipal;
	private final VBox contenedorVertical;
	
	public BotonConstruirHotelesHandler(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, VBox contenedorVertical) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
		this.contenedorVertical = contenedorVertical;
	}

	@Override
	public void handle(ActionEvent event) {
		this.contenedorPrincipal.setBotoneraConstruirHotel(this.algoPoly,this.contenedorPrincipal, this.contenedorVertical);
	}


}
