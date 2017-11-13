package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorEstaEnCanaException;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianza;

public class EstadoJugadorEnCana implements EstadoJugador {

	int turno;
	private static final int FIANZA = 45000;

	
	public EstadoJugadorEnCana() {
		turno = 3;
	}
	
	@Override
	public boolean puedeMover() {
		return false;
	}
	
	@Override
	public void mover(Jugador unJugador, Casillero unCasillero) {
		throw new JugadorEstaEnCanaException();
	}

	@Override
	public void finalizarTurno(Jugador unJugador) {
		turno--;
		if (turno <= 0)
			unJugador.salirEnLibertad();
	}

	@Override
	public void pagarFianza(Jugador unJugador) {
		if ((turno == 3) || (unJugador.getDinero() < FIANZA)) 
			throw new JugadorNoPuedePagarFianza();
		unJugador.sacarDinero(FIANZA);
		unJugador.salirEnLibertad();
	}
	
}
