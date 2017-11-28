package fiuba.algo3.vista;

import fiuba.algo3.clases.AlgoPoly;
import javafx.scene.canvas.Canvas;

public class VistaAlgoPoly {

	private AlgoPoly algoPoly;
	
	private VistaDados vistaDados;
	
	private VistaInfoJugadores vistaInfoJugadores;
	
	private VistaTablero vistaTablero;
	
	public VistaAlgoPoly(AlgoPoly unAlgoPoly, Canvas canvasCentral) {
		
		this.algoPoly = unAlgoPoly;

		this.vistaDados = new VistaDados(canvasCentral, unAlgoPoly.getDados());
	
		this.vistaInfoJugadores = new VistaInfoJugadores(unAlgoPoly);
	
		this.vistaTablero = new VistaTablero(canvasCentral, unAlgoPoly);

	}
	
	public AlgoPoly getAlgoPoly() {
		
		return this.algoPoly;
	}
	
	
	public void dibujarTablero() {
		
		this.vistaTablero.dibujar();
	
	}

	public void update() {
		
		this.vistaTablero.update();
		
		this.vistaDados.update();
		
		this.vistaInfoJugadores.update();
		
		
	}

	public VistaInfoJugadores getVistaInfoJugadores() {
	
		return this.vistaInfoJugadores;
		
		
	}






}