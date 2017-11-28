package fiuba.algo3.clases;

import java.util.LinkedList;

import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.encasillables.Servicio;
import fiuba.algo3.estados.EstadoJugador;
import fiuba.algo3.estados.EstadoJugadorEnCana;
import fiuba.algo3.estados.EstadoJugadorEnLibertad;
import fiuba.algo3.excepciones.JugadorNoTieneDineroException;
import fiuba.algo3.excepciones.JugadorYaTiroDadosException;

public class Jugador {
	
	private static int DINERO_INICIAL = 100000;
	
	private int dinero;
	
	private LinkedList<Comprable> propiedades;
	
	private EstadoJugador estado;
	
	private Casillero ubicacion;
	
	private int resultadoDados;
	
	private LinkedList<Barrio> barrios = new LinkedList<Barrio>();
	
	private LinkedList<Servicios> servicios = new LinkedList<Servicios>();
	
	
	private boolean perdedor;
	
	private boolean yaTiroDados;
		
	public Jugador(Casillero ubicacionInicial){
		this.dinero = DINERO_INICIAL;
		this.propiedades = new LinkedList<Comprable>();
		this.estado = new EstadoJugadorEnLibertad(this);
		this.setUbicacion(ubicacionInicial);
		this.perdedor = false;
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
	
	public boolean tienePropiedades() {
		return (this.getCantidadPropiedades() != 0);
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
		this.yaTiroDados = false;
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
	
	
	public void setResultadoDados(int primerNumero, int segundoNumero) {
		this.resultadoDados = primerNumero + segundoNumero;
	}
	
	public int getResultadoDados() {
		return this.resultadoDados;
	}

	public Dados tirarDados(Dados dados) {
		if (this.yaTiroDados)
			throw new JugadorYaTiroDadosException();
		dados.rolarDados();
		this.resultadoDados = dados.getSuma();
		this.yaTiroDados = true;		
		return dados;
		
	}

	public LinkedList<Comprable> getPropiedades() {
		
		return this.propiedades;
		
	}
	
	public boolean tieneSuficienteDinero(int unPrecio) {
		return this.getDinero() > unPrecio;
	}

	public boolean tienePropiedadesConValorSuficiente(int unPrecio) {
		int valorTotal = 0;
		for (Comprable unaPropiedad: this.propiedades) {
			valorTotal += unaPropiedad.getValorVenta();
		}
		return (valorTotal > unPrecio);
	}
	
	public String getPropiedadDeMenorValor() {
		String unNombre = "";
		int valor = 100000;
		for (Comprable unaPropiedad: this.getPropiedades()) {
			if (valor > unaPropiedad.getPrecio()) {
				valor = unaPropiedad.getPrecio();
				unNombre = unaPropiedad.getNombre();
			}
		}
		return unNombre;
	}
	
	public void elegirQuePropiedadesVender() {
		String unNombre = this.getPropiedadDeMenorValor();
		this.venderPropiedad(unNombre);
	}
	
	private void venderTodasLasPropiedades() {
		if (!this.tienePropiedades())
			return;
		Comprable unaPropiedad = this.propiedades.removeFirst();
		for(int i = 0; i < this.propiedades.size(); unaPropiedad = this.propiedades.removeFirst()) {
			this.venderPropiedad(unaPropiedad.getNombre());
		}
	}
	
	public void declararPerdedor(Jugador jugadorAlQueLeDebe) {
		this.venderTodasLasPropiedades();
		jugadorAlQueLeDebe.recibirDinero(this.getDinero());
		this.sacarDinero(this.getDinero());
		this.perdedor = true;
	}
	
	// Metodo alternativo a declararPerdedor sin parametro para que pasen las pruebas
	public void declararPerdedor() {
		this.sacarDinero(this.getDinero());
		this.perdedor = true;
	}

	public boolean esPerdedor() {
		return this.perdedor;
	}
	
}
