package fiuba.algo3.encasillables;

import fiuba.algo3.clases.Encasillable;
import fiuba.algo3.clases.Jugador;

public class ImpuestoAlLujo implements Encasillable {

	@Override
	public void accionarCon(Jugador unJugador) {
		this.cobrarImpuesto(unJugador);
	}

	public void cobrarImpuesto(Jugador unJugador) {
		int unImpuesto = (int) (unJugador.getDinero() * 0.1);
		unJugador.sacarDinero(unImpuesto);
	}
	
}
