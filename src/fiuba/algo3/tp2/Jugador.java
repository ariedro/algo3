package fiuba.algo3.tp2;

public class Jugador {
	
	private int dinero;
	private boolean estaEnLaCarcel;
	
	Jugador(){
		this.dinero = 100000;
		this.estaEnLaCarcel = false;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void recibirDinero(int unDinero) {
		this.dinero += unDinero;
	}
	
	public boolean estaEnLaCarcel() {
		return this.estaEnLaCarcel;
	}
	
}
