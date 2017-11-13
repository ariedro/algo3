package fiuba.algo3.clases;

public class Policia implements Encasillable {
	private Carcel carcel;
	
	public Policia(Carcel unaCarcel) {
		this.carcel = unaCarcel;
	}
	
	public void accionarCon(Jugador unJugador) {
		this.mandarALaCarcel(unJugador);
	}
	
	public void mandarALaCarcel(Jugador unJugador) {
		this.carcel.aprisionar(unJugador);
	}
	
}
