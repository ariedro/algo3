package fiuba.algo3.tp2;

public class Casillero {
	
	private Encasillable unaPropiedad;
	

	public Casillero (Encasillable propiedad) {
		
		this.unaPropiedad = propiedad;
		
	}
	
	public void accionarPropiedad(Jugador unJugador) {
		
		this.unaPropiedad.accionarCon(unJugador);	
	
	}
	
}



