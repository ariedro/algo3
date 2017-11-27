package fiuba.algo3.encasillables;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Encasillable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.clases.Tablero;

public class Policia implements Encasillable {
	
	private static int DISTANCIA_A_LA_CARCEL = 10;
	
	private Casillero casilleroCarcel;
	
	private Tablero tablero;
	
	
	
	public Policia(Tablero unTablero) {
		
		this.tablero = unTablero;
		
		casilleroCarcel = unTablero.getCarcel();
	}
	
	public void accionarCon(Jugador unJugador) {
		
		this.tablero.modificarPosicion(unJugador, DISTANCIA_A_LA_CARCEL);
		
		unJugador.mover(casilleroCarcel);
		
		this.mandarALaCarcel(unJugador);
		
	}
	
	public void mandarALaCarcel(Jugador unJugador) {
	
		casilleroCarcel.accionarPropiedad(unJugador);		
	
	
	}
	
}
