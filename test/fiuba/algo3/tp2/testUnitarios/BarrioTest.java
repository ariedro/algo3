package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;

public class BarrioTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int PRECIO_BARRIO = 10000;
	private static final int ALQUILER_BASICO = 10000;
	
	@Test
	public void test01CrearBarrioNoEsNulo() {
		Barrio unBarrio = new Barrio();
		assertNotNull(unBarrio);
	}
	
	@Test
	public void test02JugadorEsPropietarioSiCaeEnUnBarrio() {
		Barrio unBarrio = new Barrio();
		Jugador unJugador = new Jugador();
		unBarrio.setPrecio(PRECIO_BARRIO);
		unBarrio.accionarCon(unJugador);
		assertTrue(unBarrio.esPropietario(unJugador));
	}
	
	@Test
	public void test03BarrioNoTienePropietarioCuandoFueCreado() {
		Barrio unBarrio = new Barrio();
		assertTrue(!unBarrio.tienePropietario());
	}
	
	@Test
	public void test04BarrioCobraAlquilerCuandoTienePropietario() {
		Barrio unBarrio = new Barrio();
		Jugador primerJugador = new Jugador();
		Jugador segundoJugador = new Jugador();
		unBarrio.setAlquilerBasico(ALQUILER_BASICO);
		unBarrio.accionarCon(primerJugador);
		unBarrio.accionarCon(segundoJugador);
		assertEquals(DINERO_INICIAL - ALQUILER_BASICO,segundoJugador.getDinero());
	}

}
