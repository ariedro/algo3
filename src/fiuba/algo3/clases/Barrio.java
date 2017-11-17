package fiuba.algo3.clases;

public class Barrio implements Encasillable, Comprable{
	
	private Jugador propietario = null;
	private DatosDeBarrio datosDeBarrio;

	
	
	public Barrio() {
		/*solo para pruebas unitarias*/
	}
	
	public Barrio(DatosDeBarrio unosDatosDeBarrio) {
		
		this.datosDeBarrio = unosDatosDeBarrio;
	}
	
	
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

	

	public Jugador getPropietario() {
		
		return this.propietario;
	}
	
	public int getPrecio() {
		return this.datosDeBarrio.getPrecio(); 
	}
	
	private boolean tieneDineroSuficiente(Jugador unJugador) {
		return (unJugador.getDinero() > this.getPrecio());
	}

	private void cobrarAlquiler(Jugador unJugador) {
		unJugador.sacarDinero(this.datosDeBarrio.getAlquilerSimple());
	}


	public int getValorVenta() {
		
		// hay que implementar
		return 0;
	}

	
}
