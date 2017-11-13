package fiuba.algo3.clases;

import java.util.LinkedList;

import fiuba.algo3.estados.EstadoJugador;
import fiuba.algo3.estados.EstadoJugadorEnCana;
import fiuba.algo3.estados.EstadoJugadorEnLibertad;

public class Jugador {
	
	private static int DINERO_INICIAL = 100000;
	
	private int dinero;
	
	private LinkedList<Comprable> propiedades;
	
	private EstadoJugador estado;
	
	private Casillero ubicacion;
	
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
	
	public void sacarDinero(int unDinero) {
		this.dinero -= unDinero;
	}
	
	public int getCantidadPropiedades() {
		
		return this.propiedades.size();
		
	}
	
	private void incorporarPropiedad(Comprable unaPropiedad) {
		this.propiedades.add(unaPropiedad);
	}
	
	public void comprarPropiedad(Comprable unaPropiedad) {
		if (this.tomarDecisionDeComprarPropiedad()) {
			this.sacarDinero(unaPropiedad.getPrecio());
			this.incorporarPropiedad(unaPropiedad);
		}
	}
	
	public boolean puedeMover() {
		return estado.puedeMover();
	}
	
	public void mover(Jugador unJugador, Casillero unCasillero) {
		this.estado.mover(unJugador, unCasillero);
	}

	public void irEnCana() {
		this.estado = new EstadoJugadorEnCana();
	}

	public void salirEnLibertad() {
		this.estado = new EstadoJugadorEnLibertad();
	}

	public void finalizarTurno() {
		this.estado.finalizarTurno(this);
	}

	public void setUbicacion(Casillero unCasillero) {
		ubicacion = unCasillero;
	}
	public Casillero getUbicacion() {
		return this.ubicacion;
	}

	public void pagarFianza() {
		this.estado.pagarFianza(this);
	}

	public boolean tomarDecisionDeComprarPropiedad() {
		return true;
	}

	public void venderPropiedad(Comprable unaPropiedad) {
		
		this.propiedades.remove(unaPropiedad);
		
		this.dinero += unaPropiedad.getValorVenta();
	}



}
