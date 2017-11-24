package fiuba.algo3.clases;

import java.util.HashMap;
import java.util.LinkedList;

public class Tablero {
	
	private LinkedList<Casillero> listaCasilleros = new LinkedList<Casillero>();
	private IndiceDeTablero unIndice;
	private HashMap<Jugador,Integer> posiciones = new HashMap<Jugador,Integer>();
	
	
	public Tablero(){
		Inicializador unInicializador = new Inicializador();
		unInicializador.inicializarTablero(this);
		this.unIndice = new IndiceDeTablero();
	}
	
	public void agregarJugador(Jugador unJugador) {
		
		posiciones.put(unJugador,0);
		
	}
	
	public void agregarCasillero(Casillero unCasillero) {
		this.listaCasilleros.add(unCasillero);
	}
	
	public Casillero getCasillero(int unIndice) {
		return this.listaCasilleros.get(unIndice);
	}
	
	public int getIndiceConCasillero(Casillero casillero) {
		return listaCasilleros.indexOf(casillero);
	}
	
	public int getIndiceConNombre(String unNombre) {
		return this.unIndice.getIndice(unNombre);
	}

	public int getCantidadJugadores() {
	
		return posiciones.size();
		
	}

	public int getPosicion(Jugador unJugador) {
		
		return this.posiciones.get(unJugador);
		
	}

	public void modificarPosicion(Jugador unJugador, int posiciones) {
		
		int posicionActual = this.posiciones.get(unJugador);
		
		int posicionFinal;
		
		if (posicionActual + posiciones >= listaCasilleros.size()) {
			
			posicionFinal = posicionActual+posiciones-listaCasilleros.size();
			
			
		} else if (posicionActual + posiciones < 0) {
				
			posicionFinal = posicionActual + posiciones + listaCasilleros.size();
			
		} else {
		
			posicionFinal = posicionActual + posiciones;
		
		}
	
		this.posiciones.put(unJugador, posicionFinal);
		
	}

	public Casillero getCarcel() {
		
		return this.listaCasilleros.get(5);
		
	}
	
	
}