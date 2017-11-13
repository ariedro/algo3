package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;

public interface EstadoJugador {
	
	public abstract boolean puedeMover();

	public abstract void mover(Jugador unJugador, Casillero unCasillero);

	public abstract void finalizarTurno(Jugador unJugador);

	public abstract void pagarFianza(Jugador unJugador);
	
}
