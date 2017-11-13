package fiuba.algo3.estados;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;

public interface EstadoJugador {
	
	public abstract boolean puedeAccionar();

	public abstract void mover(Casillero unCasillero);

	public abstract void finalizarTurno();

	public abstract void pagarFianza();
	
}
