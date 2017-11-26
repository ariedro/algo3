package fiuba.algo3.clases;

import java.util.LinkedList;
import java.util.ListIterator;

public class AlgoPoly {

	private static final int JUGADORES_INICIALES = 3;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	private Tablero tablero = new Tablero();
	private ListIterator<Jugador> jugadorActual;
	private Dados dados = new Dados();
	private boolean jugadorHabiaSacadoDobles = false;
	
	
	
	public AlgoPoly() {
		this.crearJugadores();		
		this.jugadorActual = jugadores.listIterator();
	}
	
	public void crearJugadores() {	
		for (int i=1; i <= JUGADORES_INICIALES ; i++ ) {
			Jugador unJugador = new Jugador(tablero.getCasillero(0));
			this.tablero.agregarJugador(unJugador);
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
		
		if (dados.sonDobles() && !jugadorHabiaSacadoDobles) {
			
			this.jugadorHabiaSacadoDobles = true;
		
			return;
		
		}
		
		this.jugadorActual.next();		
		
		if (!this.jugadorActual.hasNext()) {
			
			this.jugadorActual = jugadores.listIterator();
		
		}
		
		this.jugadorHabiaSacadoDobles = false;
	
	
	}
		
	public Casillero turnar(Jugador unJugador) {
			
			dados = unJugador.tirarDados(dados);
			
			tablero.modificarPosicion(unJugador, dados.getSuma());
			
			Casillero unCasillero = tablero.getCasillero(tablero.getPosicion(unJugador));
		
			return unCasillero;
			
	}
			
		
	
	public void accionarCasillero(Casillero unCasillero, Jugador unJugador) {
		
		unCasillero.accionarPropiedad(unJugador);
		
	}
	
	public Dados getDados() {
		return this.dados;
	}
	
}
