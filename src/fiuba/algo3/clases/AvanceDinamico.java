package fiuba.algo3.clases;

public class AvanceDinamico implements Encasillable, MovimientoDinamico{

	Tablero tablero;
	
	public AvanceDinamico(Tablero unTablero) {
		this.tablero = unTablero;
	}
	
	@Override
	public void accionarCon(Jugador unJugador) {
		int suma = unJugador.getResultadoDados();
		int resultadoDinamico = this.getCantidadDeMovimiento(unJugador,suma);
		int indiceJugador = tablero.getIndiceConCasillero(unJugador.getUbicacion());
		unJugador.mover(tablero.getCasillero(indiceJugador + resultadoDinamico));
	}

	public int getCantidadDeMovimiento(Jugador unJugador, int suma) {
		if (suma < 7) {
			return (suma - 2);
		}
		else if (suma < 11) {
			return (unJugador.getDinero() % suma);
		}
		return (suma - unJugador.getCantidadPropiedades());
	}

}
