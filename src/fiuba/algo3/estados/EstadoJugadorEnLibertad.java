package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;

public class EstadoJugadorEnLibertad implements EstadoJugador {

	private Jugador jugador;
	
	public EstadoJugadorEnLibertad(Jugador unJugador){
		this.jugador = unJugador;
	}
	
	@Override
	public boolean puedeAccionar() {
		return true;
	}
	

	@Override
	public void mover(Casillero unCasillero) {
		this.jugador.setUbicacion(unCasillero);
	}


	@Override
	public void finalizarTurno() {
	}


	@Override
	public void pagarFianza() {
		throw new JugadorNoPuedePagarFianzaException();
	}

	
}
