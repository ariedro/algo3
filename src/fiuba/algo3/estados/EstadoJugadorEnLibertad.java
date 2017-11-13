package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;

public class EstadoJugadorEnLibertad implements EstadoJugador {

	@Override
	public boolean puedeMover() {
		return true;
	}
	

	@Override
	public void mover(Jugador unJugador, Casillero unCasillero) {
		unJugador.setUbicacion(unCasillero);
	}


	@Override
	public void finalizarTurno(Jugador unJugador) {
	}

	
}
