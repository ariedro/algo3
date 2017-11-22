package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import fiuba.algo3.encasillables.Carcel;


public class CarcelTest {

	@Test
	public void test01CarcelCreadaNoEsNula() {
		Carcel unaCarcel = new Carcel();
		assertNotNull(unaCarcel);
	}

	@Test
	public void test02JugadorEnCanaNoPuedeMoverse() {
		Carcel unaCarcel = new Carcel();
		Jugador unJugador = new Jugador();
		unaCarcel.aprisionar(unJugador);
		assertFalse(unJugador.puedeAccionar());
	}
	
	@Test
	public void test03JugadorQueFueLiberadoPuedeMoverse() {
		Carcel unaCarcel = new Carcel();
		Jugador unJugador = new Jugador();
		unaCarcel.aprisionar(unJugador);
		unaCarcel.liberar(unJugador);
		assertTrue(unJugador.puedeAccionar());
	}
	
}
