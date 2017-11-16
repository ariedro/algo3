package fiuba.algo3.clases;

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
