package fiuba.algo3.encasillables;

import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.DatosDeBarrio;
import fiuba.algo3.clases.Encasillable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirCasaException;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;

public class Barrio implements Encasillable, Comprable{
	
	private Jugador propietario = null;
	private DatosDeBarrio datosDeBarrio;
	private int numeroDeCasasConstruidas;
	private boolean hotelConstruido;

	
	
	public Barrio() {
		/*solo para pruebas unitarias*/
	}
	
	public Barrio(DatosDeBarrio unosDatosDeBarrio) {
		
		this.datosDeBarrio = unosDatosDeBarrio;
		this.numeroDeCasasConstruidas = 0;
		this.hotelConstruido = false;
	}
	
	
	public void accionarCon(Jugador unJugador) {
		if (!this.tienePropietario() && this.tieneDineroSuficiente(unJugador)) {
			unJugador.comprarPropiedad(this);
			this.setPropietario(unJugador);
		}
		else if (this.tienePropietario() && !this.esPropietario(unJugador)) {
			if (unJugador.tieneSuficienteDinero(this.getPrecio())) this.cobrarAlquiler(unJugador);
			else if (unJugador.tienePropiedadesConValorSuficiente(this.getAlquiler())) {
				while (unJugador.getDinero() < this.getAlquiler()) 
					unJugador.elegirQuePropiedadesVender();
				this.cobrarAlquiler(unJugador);
			}
			else unJugador.declararPerdedor();
		}
	}

	public boolean tienePropietario() {
		return (this.propietario != null);
	}
	
	public boolean esPropietario(Jugador unJugador) {
		return (this.propietario == unJugador);
	}

	public String getNombre() {
		return this.datosDeBarrio.getNombre();
	}

	public Jugador getPropietario() {
		
		return this.propietario;
	}
	
	public int getPrecio() {
		return this.datosDeBarrio.getPrecio(); 
	}
	
	private boolean tieneDineroSuficiente(Jugador unJugador) {
		return (unJugador.getDinero() > this.getPrecio());
	}

	public int getAlquiler() {
		int valor = 0;
		if(this.numeroDeCasasConstruidas == 0) valor = this.datosDeBarrio.getAlquilerSimple();
		if(this.numeroDeCasasConstruidas == 1) valor = this.datosDeBarrio.getAlquilerUnaCasa();
		if(this.numeroDeCasasConstruidas == 2) valor = this.datosDeBarrio.getAlquilerDosCasas();
		if(this.numeroDeCasasConstruidas == 2 && this.fueConstruidoHotel()) valor = this.datosDeBarrio.getAlquilerHotel();
		return valor;
	}
	
	private void cobrarAlquiler(Jugador unJugador) {
		unJugador.sacarDinero(this.getAlquiler());
	}
	
	public String getVecino() {
		return this.datosDeBarrio.getVecino();	
	}
	
	public int getNumeroDeCasasConstruidas() {
		return this.numeroDeCasasConstruidas;
	}
	
	public boolean fueConstruidoHotel() {
		return this.hotelConstruido;
	}
	
	public int getMaximoCasas() {
		return this.datosDeBarrio.getMaximoCasas();
	}
	
	public void construirCasa() {
		if (this.tienePropietario()) {
			if (this.getMaximoCasas() > 1 && (!this.fueConstruidoHotel())) this.construirConVecino();
			else this.construirConSoloUnaCasa();
		}
	}
	
	private void construirConSoloUnaCasa() {
		if(this.getMaximoCasas() > this.numeroDeCasasConstruidas) {
			this.propietario.sacarDinero(this.datosDeBarrio.getPrecioCasa());
			this.numeroDeCasasConstruidas++;
		}
		else throw new BarrioNoPuedeConstruirCasaException();
	}
	
	public void construirHotel() {
		if (this.puedeTenerHotel() && this.tienePropietario() && (this.getMaximoCasas() > 1 && (!this.fueConstruidoHotel()))) {
			if (this.propietario.estaEntreLasPropiedades(this.getVecino()) && 
				(this.getMaximoCasas() <= this.numeroDeCasasConstruidas)) {
					Barrio unVecino = (Barrio) this.propietario.getPropiedad(this.getVecino());
					this.propietario.sacarDinero(this.datosDeBarrio.getPrecioHotel());
					this.hotelConstruido = (unVecino.getNumeroDeCasasConstruidas() == this.numeroDeCasasConstruidas);
					return;
			}
		}
		throw new BarrioNoPuedeConstruirHotelException();
	}
	
	private boolean puedeTenerHotel() {
		return this.datosDeBarrio.puedeTenerHotel();
	}

	private void construirConVecino() {
		if (this.propietario.estaEntreLasPropiedades(this.getVecino())) {
			 construirConSoloUnaCasa();
		}
		else throw new BarrioNoPuedeConstruirCasaException();
	}
	


	public int getValorVenta() {
		int valorVenta = this.getPrecio();
		if (this.getNumeroDeCasasConstruidas() > 0) {
			if (this.fueConstruidoHotel()) valorVenta += this.datosDeBarrio.getPrecioHotel();
			else valorVenta += this.getNumeroDeCasasConstruidas() * this.datosDeBarrio.getPrecioCasa();
		}
		valorVenta -= ((int) (valorVenta * 0.15));
		return valorVenta;
	}
	
	public void setPropietario(Jugador unJugador) {
		this.propietario = unJugador;
	}
	
	public void darDeBajaPropietario() {
		this.propietario = null;
	}

	
}
