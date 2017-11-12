package fiuba.algo3.tp2;

public class Barrio implements Tipo, Comprable{
	
	private Jugador propietario;
	
	public void activar(Jugador unJugador) {
		if (this.propietario == null) this.propietario = unJugador;
	}
	
	public boolean esPropietario(Jugador unJugador) {
		return (this.propietario == unJugador);
	}

	
	/*implementacion solo para que compile*/
	public int getPrecio() {
		return 0; 
	}


	
}
