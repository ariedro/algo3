package fiuba.algo3.vista;

import java.util.LinkedList;

import fiuba.algo3.clases.AlgoPoly;
import javafx.scene.canvas.Canvas;

public class VistaAlgoPoly implements Vista {

	private AlgoPoly algoPoly;
	
	private LinkedList<Vista> vistas;
	
	private VistaInfoJugadores vistaInfoJugadores;
	
	private VistaTablero vistaTablero;
	
	public VistaAlgoPoly(AlgoPoly unAlgoPoly, Canvas canvasCentral) {
		
		this.algoPoly = unAlgoPoly;
		this.vistas = new LinkedList<>();
		
		this.vistaInfoJugadores = new VistaInfoJugadores(unAlgoPoly);
		vistas.add(vistaInfoJugadores);
	
		this.vistaTablero = new VistaTablero(canvasCentral, unAlgoPoly);
		vistas.add(vistaTablero);

		vistas.add(new VistaDados(canvasCentral, unAlgoPoly.getDados()));

	}
	
	public AlgoPoly getAlgoPoly() {
		
		return this.algoPoly;
	}
	
	
	public void dibujarTablero() {
		
		this.vistaTablero.dibujar();
	
	}

	public void update() {
		
		for(Vista vista: vistas)
			vista.update();
		
	}

	public VistaInfoJugadores getVistaInfoJugadores() {
	
		return this.vistaInfoJugadores;
		
		
	}






}