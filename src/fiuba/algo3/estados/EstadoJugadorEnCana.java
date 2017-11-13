package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.JugadorEstaEnCanaException;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianza;

public class EstadoJugadorEnCana implements EstadoJugador {

	private static final int FIANZA = 45000;
	
	private int turno;
	private Jugador jugador;
	
	public EstadoJugadorEnCana(Jugador unJugador){
		this.turno = 3;
		this.jugador = unJugador;
	}
	
	@Override
	public boolean puedeAccionar() {
		return false;
	}
	
	@Override
	public void mover(Casillero unCasillero) {
		throw new JugadorEstaEnCanaException();
	}

	@Override
	public void finalizarTurno() {
		turno--;
		if (turno <= 0)
			this.jugador.salirEnLibertad();
	}

	@Override
	public void pagarFianza() {
		if ((turno == 3) || (this.jugador.getDinero() < FIANZA)) 
			throw new JugadorNoPuedePagarFianza();
		this.jugador.sacarDinero(FIANZA);
		this.jugador.salirEnLibertad();
	}
	
}
