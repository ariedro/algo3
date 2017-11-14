package fiuba.algo3.clases;

public class Carcel implements Encasillable{

	
	public void accionarCon(Jugador unJugador) {
		if(unJugador.puedeAccionar()) {
			this.aprisionar(unJugador);
		}
		else {
			this.liberar(unJugador);
		}
	}
		
	public void aprisionar(Jugador unJugador) {
		unJugador.irEnCana();
	}

	public void liberar(Jugador unJugador) {
		unJugador.salirEnLibertad();
	}

}
