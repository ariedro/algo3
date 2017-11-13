package fiuba.algo3.clases;

import java.util.LinkedList;

public class AlgoPoly {

	private static final int JUGADORES_INICIALES = 3;
	
	
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	
	
	public AlgoPoly() {
		
		this.crearJugadores();	
		
		
		
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
	
	




}
