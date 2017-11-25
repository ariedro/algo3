package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.clases.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComprarPropiedadHandler implements EventHandler<ActionEvent>{
	
	private final AlgoPoly algoPoly;
	
	public BotonComprarPropiedadHandler(AlgoPoly algoPoly) {
		// TODO Auto-generated constructor stub
		this.algoPoly = algoPoly;
	}

	@Override
	public void handle(ActionEvent event) {
		//Hay que ver como diferenciar si está entre sus propiedades y si tiene dueño para ver si puede o no comprarla
		//(son comprables y el casillero te devuelve un encasillable)
	}

}
