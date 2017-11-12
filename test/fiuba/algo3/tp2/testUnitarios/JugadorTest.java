package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.*;


public class JugadorTest {

	private static final int DINERO_INICIAL = 100000;
	
	@Test
	public void test01CrearJugadorNoEsNull() {
		Jugador unJugador = new Jugador();
		assertNotNull(unJugador);
	}
	
	@Test
	public void test02JugadorCreadoEmpiezaConValorInicial() {
		Jugador unJugador = new Jugador();
		assertEquals(DINERO_INICIAL,unJugador.getDinero());
	}

	@Test
	public void test03RecibirDineroSumaElValorCorrecto() {
		Jugador unJugador = new Jugador();
		unJugador.recibirDinero(100);
		assertEquals(DINERO_INICIAL+100,unJugador.getDinero());
	}
	
	@Test 
	public void test04JugadorCreadoNoPoseePropiedades() {
			
		Jugador unJugador = new Jugador();
		
		assertEquals(0,unJugador.getCantidadPropiedades());
	
	}

}
