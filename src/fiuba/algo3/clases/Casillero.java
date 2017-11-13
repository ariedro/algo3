package fiuba.algo3.clases;

public class Casillero {
	
	private Tipo unaPropiedad;
	

	public Casillero (Tipo propiedad) {
		
		this.unaPropiedad = propiedad;
		
	}
	
	public void accionarPropiedad(Jugador unJugador) {
		
		this.unaPropiedad.activar(unJugador);	
	
	}
	
}



