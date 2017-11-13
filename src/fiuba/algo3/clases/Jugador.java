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
	
	private int resultadoDados;
	
	private int resultadoDinamico;
	
	public Jugador(){
	
		this.dinero = DINERO_INICIAL;
		
		this.propiedades = new LinkedList<Comprable>();
		
		this.estado = new EstadoJugadorEnLibertad(this);
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
	
	public void incorporarPropiedad(Comprable unaPropiedad) {
		this.propiedades.add(unaPropiedad);
	}
	
	public void darDeBajaPropiedad(Comprable unaPropiedad) {
		this.propiedades.remove(unaPropiedad);
	}
	
	public void comprarPropiedad(Comprable unaPropiedad) {
		if (this.tomarDecisionDeComprarPropiedad()) {
			this.sacarDinero(unaPropiedad.getPrecio());
			this.incorporarPropiedad(unaPropiedad);
		}
	}
	
	public boolean puedeAccionar() {
		return estado.puedeAccionar();
	}
	
	public void mover(Casillero unCasillero) {
		this.estado.mover(unCasillero);
	}

	public void irEnCana() {
		this.estado = new EstadoJugadorEnCana(this);
	}

	public void salirEnLibertad() {
		this.estado = new EstadoJugadorEnLibertad(this);
	}

	public void finalizarTurno() {
		this.estado.finalizarTurno();
	}

	public void setUbicacion(Casillero unCasillero) {
		ubicacion = unCasillero;
	}
	public Casillero getUbicacion() {
		return this.ubicacion;
	}
	
	public boolean estaEnCana() {
		return this.estado.puedeAccionar();
	}

	public void pagarFianza() {
		this.estado.pagarFianza();
	}

	public boolean tomarDecisionDeComprarPropiedad() {
		// Falta implementar la toma de decision si quiere o no comprar una propiedad.
		return true;
	}

	public void venderPropiedad(Comprable unaPropiedad) {
		
		this.darDeBajaPropiedad(unaPropiedad);
		
		this.recibirDinero(unaPropiedad.getValorVenta());
	}
	
	public int tirarDado(Dado unDado) {
		return unDado.tirar();
	}
	
	public void setResultadoDados(int primerNumero, int segundoNumero) {
		this.resultadoDados = primerNumero + segundoNumero;
	}
	
	public int getResultadoDados() {
		return this.resultadoDados;
	}
	
	// Hay que revisar resultadoDinamico.
	
	public void setResultadoDinamico(int resultadoDinamico) {
		this.resultadoDinamico = resultadoDinamico;
	}
	
	public int getResultadoDinamico() {
		return this.resultadoDinamico;
	}
	
	



}
