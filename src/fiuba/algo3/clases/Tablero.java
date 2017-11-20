package fiuba.algo3.clases;

import java.util.LinkedList;

public class Tablero {
	private LinkedList<Casillero> listaCasilleros = new LinkedList<Casillero>();
	private IndiceDeTablero unIndice;
	
	public Tablero(){
		Inicializador unInicializador = new Inicializador();
		unInicializador.inicializarTablero(this);
		this.unIndice = new IndiceDeTablero();
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

}
