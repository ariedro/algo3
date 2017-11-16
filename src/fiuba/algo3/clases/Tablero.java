package fiuba.algo3.clases;

import java.util.LinkedList;

public class Tablero {
	private LinkedList<Casillero> listaCasilleros = new LinkedList<Casillero>();
	
	Tablero(){
		Inicializador unInicializador = new Inicializador();
		unInicializador.inicializarTablero(this);
	}
	
	public void setCasillero(Casillero unCasillero) {
		listaCasilleros.add(unCasillero);
	}
	
	public Casillero getCasillero(int unIndice) {
		return listaCasilleros.get(unIndice);
	}
}
