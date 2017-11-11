package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BarrioTest {

	@Test
	public void test01CrearBarrioNoEsNulo() {
		Barrio unBarrio = new Barrio();
		assertNotNull(unBarrio);
	}
	
	@Test
	public void test02JugadorEsPropietarioSiCaeEnUnBarrio() {
		Barrio unBarrio = new Barrio();
		Jugador unJugador = new Jugador();
		unBarrio.activar(unJugador);
		assertTrue(unBarrio.esPropietario(unJugador));
	}

}
