package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianza;

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


	@Override
	public void pagarFianza(Jugador unJugador) {
		throw new JugadorNoPuedePagarFianza();
	}

	
}
