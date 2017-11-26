package fiuba.algo3.clases;

import java.util.LinkedList;

import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.estados.EstadoJugador;
import fiuba.algo3.estados.EstadoJugadorEnCana;
import fiuba.algo3.estados.EstadoJugadorEnLibertad;
import fiuba.algo3.excepciones.JugadorNoTieneDineroException;

public class Jugador {
	
	private static int DINERO_INICIAL = 100000;
	
	private int dinero;
	
	private LinkedList<Comprable> propiedades;
	
	private EstadoJugador estado;
	
	private Casillero ubicacion;
	
	private int resultadoDados;
		
	public Jugador(Casillero ubicacionInicial){
		this.dinero = DINERO_INICIAL;
		this.propiedades = new LinkedList<Comprable>();
		this.estado = new EstadoJugadorEnLibertad(this);
		this.setUbicacion(ubicacionInicial);
	}
	
	// Constructor alternativo para las pruebas, este no es el que maneja AlgoPoly
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
		if (this.dinero < unDinero)
			throw new JugadorNoTieneDineroException();
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
	
	public boolean estaEntreLasPropiedades(String unNombre) {
		boolean estaEntreLasPropiedades = false;
		for (Comprable unaPropiedad: this.propiedades) {
			if (unaPropiedad.getNombre().equals(unNombre)) 
				estaEntreLasPropiedades = true;
		}
		return estaEntreLasPropiedades;
	}
	
	public Comprable getPropiedad(String unNombre) {
		Comprable propiedadBuscada = null;
		for (Comprable unaPropiedad: this.propiedades) {
			if (unaPropiedad.getNombre().equals(unNombre)) 
				propiedadBuscada = unaPropiedad;
		}
		return propiedadBuscada;	
	}
	
	public void construirCasa(String unNombre) {
		//Si se le pasa el nombre de un Comprable que no es del tipo Barrio puede saltar un error.
		//Hay que hablarlo.
		if(this.estaEntreLasPropiedades(unNombre)) {
			Barrio unBarrio = (Barrio) this.getPropiedad(unNombre);
			unBarrio.construirCasa();
		}
	}
	
	public void construirHotel(String unNombre) {
		//Si se le pasa el nombre de un Comprable que no es del tipo Barrio puede saltar un error.
		//Hay que hablarlo.
		if(this.estaEntreLasPropiedades(unNombre)) {
			Barrio unBarrio = (Barrio) this.getPropiedad(unNombre);
			unBarrio.construirHotel();
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
		return !this.estado.puedeAccionar();
	}

	public void pagarFianza() {
		this.estado.pagarFianza();
	}

	public boolean tomarDecisionDeComprarPropiedad() {
		// Falta implementar la toma de decision si quiere o no comprar una propiedad.
		return true;
	}

	public void venderPropiedad(String unNombre) {
		if(this.estaEntreLasPropiedades(unNombre)) {
			Comprable unaPropiedad = this.getPropiedad(unNombre);
			this.darDeBajaPropiedad(unaPropiedad);	
			unaPropiedad.darDeBajaPropietario();
			this.recibirDinero(unaPropiedad.getValorVenta());
		}
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

	public Dados tirarDados(Dados dados) {
		
		dados.rolarDados();
		this.resultadoDados = dados.getSuma();
		
		return dados;
		
	}

	public LinkedList<Comprable> getPropiedades() {
		
		return this.propiedades;
		
	}
	
}
