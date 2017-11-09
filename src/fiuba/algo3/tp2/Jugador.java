package fiuba.algo3.tp2;

public class Jugador {
	
	private int dinero;
	
	Jugador(){
		this.dinero = 100000;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void recibirDinero(int unDinero) {
		this.dinero += unDinero;
	}
	
}
