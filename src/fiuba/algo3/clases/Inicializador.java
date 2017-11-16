package fiuba.algo3.clases;

public class Inicializador {
	public void inicializarTablero(Tablero unTablero) {
		
		unTablero.setCasillero(inicializarCasillero(new Salida()));
		unTablero.setCasillero(inicializarCasillero(new Quini()));
		
	}
	
	public Casillero inicializarCasillero(Encasillable unEncasillable) {
		return new Casillero(unEncasillable);
	}
}
