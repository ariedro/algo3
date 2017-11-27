package fiuba.algo3.vista;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaInfoJugadores {

	private AlgoPoly algoPoly;
	private Label label;
	private String texto;
	
	public VistaInfoJugadores(AlgoPoly unAlgoPoly) {
		this.algoPoly = unAlgoPoly;
        this.label = new Label();
        this.label.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        this.label.setTextFill(Color.BLACK);
        this.escribir();
		
	}
	
	
	public void escribir() {
		Jugador jugador = algoPoly.getJugadorActual();
		texto = "";
		texto += "Jugador: " + algoPoly.getIndiceJugadorActual() + "\n";
		texto += "Dinero: " + jugador.getDinero() + "\n";
		texto += "Estado: " + (jugador.estaEnCana() ? "En cana" : "En libertad") + "\n";
		texto += "Propiedades: ";
		for(int i = 0; i < jugador.getPropiedades().size(); i++) {
			texto += jugador.getPropiedades().get(i).getNombre();
			texto += ", ";
		}
		texto += "\n\n";
        this.label.setText(texto);			
	}
	
	public void update() {
		this.escribir();
	}


	public Label getLabel() {
		return this.label;
	}
}
