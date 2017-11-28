package fiuba.algo3.vista.eventos;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class BotonConstruirHotelHandler implements EventHandler<ActionEvent>{
	
	private final AlgoPoly algoPoly;
	private final Barrio barrio;
	private final Button botonConstruir;

	public BotonConstruirHotelHandler(Comprable propiedad, AlgoPoly algoPoly, Button botonConstruirHotel) {
		this.algoPoly = algoPoly;
		this.barrio = (Barrio) propiedad;
		this.botonConstruir = botonConstruirHotel;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorActual = algoPoly.getJugadorActual();
		try {
		jugadorActual.construirHotel(this.barrio.getNombre());
		}
		catch (BarrioNoPuedeConstruirHotelException e) {
			tirarAlerta();
		}
	}
	
	public void tirarAlerta() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Jugada ilegal");
        String mensaje = "No se puede construir un Hotel.";
        alert.setContentText(mensaje);
        
        alert.show();
	}

}
