package fiuba.algo3.encasillables;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Encasillable;
import fiuba.algo3.clases.Jugador;

public class Policia implements Encasillable {
	private Casillero casilleroCarcel;
	
	public Policia(Casillero casillero) {
		this.casilleroCarcel = casillero;
	}
	
	public void accionarCon(Jugador unJugador) {
		unJugador.mover(casilleroCarcel);
		this.mandarALaCarcel(unJugador);
	}
	
	public void mandarALaCarcel(Jugador unJugador) {
		casilleroCarcel.accionarPropiedad(unJugador);
	}
	
}
