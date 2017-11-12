package fiuba.algo3.tp2;

import java.util.HashMap;

public class Quini implements Tipo{

	private static final int PRIMER_PREMIO = 50000;
	private static final int SEGUNDO_PREMIO = 30000;
	private HashMap<Jugador, Integer> cantidadDePasadas;
	
	public Quini(){
		this.cantidadDePasadas = new HashMap<Jugador, Integer>();
	}
	
	public void activar(Jugador unJugador) {
		unJugador.recibirDinero(this.getPremio(unJugador));
	}
	
	public int getPremio(Jugador unJugador) {
		if (!this.estaEntreLosGanadores(unJugador)) this.setGanador(unJugador);
		int premioLocal = 0;
		this.aumentarPasadas(unJugador);
		if (this.getPasadas(unJugador) == 1) premioLocal = PRIMER_PREMIO;
		if (this.getPasadas(unJugador) == 2) premioLocal = SEGUNDO_PREMIO;
		return premioLocal;
	}
	
	public boolean estaEntreLosGanadores(Jugador unJugador) {
		return this.cantidadDePasadas.containsKey(unJugador);
	}
	
	private void setGanador(Jugador unJugador) {
		this.cantidadDePasadas.put(unJugador, 0);
	}
	
	private int getPasadas(Jugador unJugador) {
		return this.cantidadDePasadas.get(unJugador);
	}
	
	private void aumentarPasadas(Jugador unJugador) {
		int pasadas = this.cantidadDePasadas.get(unJugador);
		this.cantidadDePasadas.put(unJugador, pasadas + 1);
	}
	
	
}
