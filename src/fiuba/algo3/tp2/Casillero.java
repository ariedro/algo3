package fiuba.algo3.tp2;

public class Casillero {
	
	private Tipo unaPropiedad;
	

	Casillero (Tipo propiedad) {
		
		this.unaPropiedad = propiedad;
		
	}
	
	public void accionarPropiedad(Jugador unJugador) {
		
		this.unaPropiedad.activar(unJugador);	
	
	}
	
}



