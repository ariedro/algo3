package fiuba.algo3.clases;

public class AvanceDinamico implements Encasillable, MovimientoDinamico{

	@Override
	public void accionarCon(Jugador unJugador) {
		int suma = unJugador.getResultadoDados();
		int resultadoDinamico = this.getCantidadDeMovimiento(unJugador,suma);
		unJugador.setResultadoDinamico(resultadoDinamico);
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
