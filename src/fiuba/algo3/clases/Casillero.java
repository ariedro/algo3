package fiuba.algo3.clases;

public class Casillero {
	
	private Encasillable unaPropiedad;
	

	public Casillero (Encasillable propiedad) {
		
		this.unaPropiedad = propiedad;
		
	}
	
	public void accionarPropiedad(Jugador unJugador) {
		
		this.unaPropiedad.accionarCon(unJugador);	
	
	}
	
}



