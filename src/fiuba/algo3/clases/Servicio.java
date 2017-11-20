package fiuba.algo3.clases;

public class Servicio implements Encasillable,Comprable {

	private DatosDeServicio datosDeServicio;
	private Jugador propietario;
	
	public Servicio(DatosDeServicio datosDeServicio) {
		
		this.datosDeServicio = datosDeServicio;
		this.propietario = null;
	}
	
	@Override
	public void accionarCon(Jugador unJugador) {
		if (!this.tienePropietario() && this.tieneDineroSuficiente(unJugador)) {
			unJugador.comprarPropiedad(this);
			this.setPropietario(unJugador);
		}
		else if (this.tienePropietario() && !this.esPropietario(unJugador)) this.cobrarTarifa(unJugador);
	}

	private boolean tieneDineroSuficiente(Jugador unJugador) {
		return (unJugador.getDinero() > this.getPrecio());
	}

	private void cobrarTarifa(Jugador unJugador) {
		int numeroDados = unJugador.getResultadoDados();
		if(!this.propietario.estaEntreLasPropiedades(this.getServicioAsociado())) {
			unJugador.sacarDinero(numeroDados * this.getTarifaSimple());
		}
		else {
			unJugador.sacarDinero(numeroDados * this.getTarifaDoble());
		}
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public String getNombre() {
		return this.datosDeServicio.getNombre();
	}

	@Override
	public int getPrecio() {
		return this.datosDeServicio.getPrecio();
	}

	@Override
	public int getValorVenta() {
		int valorVenta = this.getPrecio();
		valorVenta -= ((int) (valorVenta * 0.15));
		return valorVenta;
	}
	
	public int getTarifaSimple() {
		return this.datosDeServicio.getTarifaSimple();
	}
	
	public int getTarifaDoble() {
		return this.datosDeServicio.getTarifaDoble();
	}
	
	public String getServicioAsociado() {
		return this.datosDeServicio.getServicioAsociado();
	}
	
	public boolean tienePropietario() {
		return (this.propietario != null);
	}
	
	public boolean esPropietario(Jugador unJugador) {
		return (this.propietario == unJugador);
	}
	
	public void setPropietario(Jugador unJugador) {
		this.propietario = unJugador;
	}
	
	public void darDeBajaPropietario() {
		this.propietario = null;
	}
	

}
