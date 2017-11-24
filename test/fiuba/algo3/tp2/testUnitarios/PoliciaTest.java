package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import fiuba.algo3.encasillables.Carcel;
import fiuba.algo3.encasillables.Policia;
import fiuba.algo3.excepciones.*;

public class PoliciaTest {

	private static final int POS_POLICIA_EN_TABLERO = 15;
	private static final int POS_CARCEL_EN_TABLERO = 5;
	
	
	@Test
	public void test01PoliciaCreadaNoEsNula() {
		Tablero unTablero = new Tablero();

		Policia unPolicia = new Policia(unTablero);
		
		assertNotNull(unPolicia);
	}
	
	@Test
	public void test02CuandoJugadorCaeEnPoliciaVaALaCarcelYNoPuedeAccionar() {
		
		Jugador unJugador = new Jugador();
		
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);
		
		Policia unPolicia = new Policia(unTablero);
		
		unPolicia.accionarCon(unJugador);
		
		assertFalse(unJugador.puedeAccionar());
	}

	
	@Test
	public void test03UnJugadorCaeEnCasilleroPoliciaSuNuevaPosicionEsCarcel() {
		
		Jugador unJugador = new Jugador();
		
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);
		
		Policia unPolicia = new Policia(unTablero);
		
		unTablero.modificarPosicion(unJugador, POS_POLICIA_EN_TABLERO);
		
		unPolicia.accionarCon(unJugador);
		
		assertEquals(POS_CARCEL_EN_TABLERO, unTablero.getPosicion(unJugador));
		
		
	}
	
	
}
