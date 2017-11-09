package fiuba.algo3.tp2;

public class Quini {

	private static final int PRIMER_PREMIO = 50000;
	private static final int SEGUNDO_PREMIO = 30000;
	private int cantidadDePasadas;
	
	Quini(){
		this.cantidadDePasadas = 0;
	}
	
	public int getPremio(Jugador unJugador) {
		int premioLocal = 0;
		this.cantidadDePasadas++;
		if (this.cantidadDePasadas == 1) premioLocal = PRIMER_PREMIO;
		if (this.cantidadDePasadas == 2) premioLocal = SEGUNDO_PREMIO;
		return premioLocal;
	}
	
	
}
