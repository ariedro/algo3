package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import fiuba.algo3.encasillables.Carcel;
import fiuba.algo3.encasillables.Policia;
import fiuba.algo3.excepciones.*;

public class PoliciaTest {

	@Test
	public void test01PoliciaCreadaNoEsNula() {
		Policia unPolicia = new Policia(null);
		assertNotNull(unPolicia);
	}
	
	@Test
	public void test02CuandoJugadorCaeEnPoliciaVaALaCarcelYNoPuedeAccionar() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero carcel = new Casillero(unaCarcel);
		Policia unPolicia = new Policia(carcel);
		unPolicia.mandarALaCarcel(unJugador);
		assertFalse(unJugador.puedeAccionar());
	}

}
