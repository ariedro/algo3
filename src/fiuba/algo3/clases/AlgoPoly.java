package fiuba.algo3.clases;

import java.util.LinkedList;
import java.util.ListIterator;

public class AlgoPoly {

	private static final int JUGADORES_INICIALES = 3;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	private Tablero tablero = new Tablero();
	private ListIterator<Jugador> jugadorActual;
	private Dados dados;
	
	
	public AlgoPoly() {
		this.crearJugadores();		
		this.jugadorActual = jugadores.listIterator();
	}
	
	public void crearJugadores() {	
		for (int i=1; i <= JUGADORES_INICIALES ; i++ ) {
			Jugador unJugador = new Jugador();
			this.jugadores.add(unJugador);
		}	
	}
	
	public Object getCantidadJugadores() {	
		return (this.jugadores.size());
	}

	public Tablero getTablero() {
		
		return this.tablero;
	
	}
	
	public Jugador getJugadorActual() {
		
		
		Jugador unJugador = this.jugadorActual.next();
		
		this.jugadorActual.previous();
		
		return unJugador;
		
	}

	public void acabarTurno() {
	
		this.getJugadorActual().finalizarTurno();
		
		this.jugadorActual.next();		
		
		if (!this.jugadorActual.hasNext()) {
			
			this.jugadorActual = jugadores.listIterator();
		
		}
		
		
	
		
	
	
	
	}

	
	
}
