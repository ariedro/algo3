package fiuba.algo3.vista;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.DatosDeBarrio;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.encasillables.Barrio;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaInfoJugadores {

	private static final String JUGADOR1 = "Azul";
	private static final String JUGADOR2 = "Marron";
	private static final String JUGADOR3 = "Fucsia";
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
		texto += "Jugador: " + consultarColor(algoPoly) + "\n";
		texto += "Dinero: " + jugador.getDinero() + "\n";
		texto += "Estado: " + (jugador.estaEnCana() ? "En cana" : "En libertad") + "\n";
		texto += "Propiedades: ";
		for(int i = 0; i < jugador.getPropiedades().size(); i++) {
			texto += (i + 1) + ") ";
			texto += jugador.getPropiedades().get(i).getNombre();
			texto += " ";
		}
		texto += "\n";
		texto += "Cantidad de casas por barrio: ";
		for(int i = 0; i < jugador.getPropiedades().size(); i++) {
			if(DatosDeBarrio.esBarrio(jugador.getPropiedades().get(i).getNombre())) {
				//texto += (i + 1) + ") ";
				Barrio unBarrio = (Barrio)jugador.getPropiedades().get(i);
				texto += unBarrio.getNombre();
				texto += ": ";
				texto += unBarrio.getNumeroDeCasasConstruidas();
				texto += " | ";
			}
		}
		texto += "\n";
		//texto += "Barrios con hotel: ";
		for(int i = 0; i < jugador.getPropiedades().size(); i++) {
			if(DatosDeBarrio.esBarrio(jugador.getPropiedades().get(i).getNombre())) {
				Barrio unBarrio = (Barrio)jugador.getPropiedades().get(i);
				//texto += (i + 1) + ") ";
				texto += unBarrio.getNombre();
				texto += ": ";
				texto += this.fueConstruidoHotel(unBarrio);
				texto += " | ";
			}
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
	
	public String consultarColor(AlgoPoly algoPoly) {
		String color = "";
		if (algoPoly.getIndiceJugadorActual() == 1) color = JUGADOR1;
		else if (algoPoly.getIndiceJugadorActual() == 2) color = JUGADOR2;
		else color = JUGADOR3;
		return color;
	}
	
	public String fueConstruidoHotel(Barrio unBarrio) {
		if (unBarrio.fueConstruidoHotel()) return "Tiene Hotel";
		return "No tiene Hotel";
	}
}
