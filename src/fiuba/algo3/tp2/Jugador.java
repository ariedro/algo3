package fiuba.algo3.tp2;

import java.util.LinkedList;

import fiuba.algo3.estados.EstadoJugador;
import fiuba.algo3.estados.EstadoJugadorEnCana;
import fiuba.algo3.estados.EstadoJugadorEnLibertad;

public class Jugador {
	
	private static int DINERO_INICIAL = 100000;
	
	private int dinero;
	
	private LinkedList<Comprable> propiedades;
	
	private EstadoJugador estado;
	
	public Jugador(){
	
		this.dinero = DINERO_INICIAL;
		
		this.propiedades = new LinkedList<Comprable>();
		
		this.estado = new EstadoJugadorEnLibertad();
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

	public void comprarPropiedad(Comprable unaPropiedad) {
		
		this.dinero -= unaPropiedad.getPrecio();
		
		this.propiedades.add(unaPropiedad);
		
	}

	public boolean puedeMover() {
		return estado.puedeMover();
	}

	public void irEnCana() {
		this.estado = new EstadoJugadorEnCana();
	}

	public void salirEnLibertad() {
		this.estado = new EstadoJugadorEnLibertad();
	}





}
