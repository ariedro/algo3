package fiuba.algo3.tp2;

import java.util.LinkedList;

public class Jugador {
	
	private static int DINERO_INICIAL = 100000;
	
	private int dinero;
	
	private LinkedList<Comprable> propiedades;
	
	
	public Jugador(){
	
		this.dinero = DINERO_INICIAL;
		
		this.propiedades = new LinkedList<Comprable>();
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void recibirDinero(int unDinero) {
		this.dinero += unDinero;
	}
	
	public int getCantidadPropiedades() {
		
		return this.propiedades.size();
		
	}





}
