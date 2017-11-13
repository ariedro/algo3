package fiuba.algo3.clases;

public class Barrio implements Encasillable, Comprable{
	
	private Jugador propietario;
	private int precio;
	private int alquilerBasico;
	
	public void accionarCon(Jugador unJugador) {
		if (!this.tienePropietario() && this.tieneDineroSuficiente(unJugador)) {
			unJugador.comprarPropiedad(this);
			this.propietario = unJugador;
		}
		else this.cobrarAlquiler(unJugador);
	}

	public boolean tienePropietario() {
		return (this.propietario != null);
	}
	
	public boolean esPropietario(Jugador unJugador) {
		return (this.propietario == unJugador);
	}

	public void setPrecio(int unPrecio) {
		this.precio = unPrecio;
	}
	
	public void setAlquilerBasico(int alquilerBasico) {
		this.alquilerBasico = alquilerBasico;
	}

	public int getPrecio() {
		return this.precio; 
	}
	
	private boolean tieneDineroSuficiente(Jugador unJugador) {
		return (unJugador.getDinero() > this.getPrecio());
	}

	private void cobrarAlquiler(Jugador unJugador) {
		unJugador.sacarDinero(this.getAlquiler());
	}

	private int getAlquiler() {
		// Hay que modificar este codigo en caso de que tenga casas y hotel.
		return this.alquilerBasico;
	}

	public int getValorVenta() {
		
		// hay que implementar
		return 0;
	}

	
}
