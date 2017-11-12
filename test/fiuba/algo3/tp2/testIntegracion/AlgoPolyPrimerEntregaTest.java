package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.*;

public class AlgoPolyPrimerEntregaTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int PRIMER_PREMIO = 50000;
	private static final int SEGUNDO_PREMIO = 30000;
	private static final int TERCER_PREMIO = 0;
	
	@Test
	public void test01JugadorCaeEnQuiniPorPrimeraVezGanaPrimerPremio() {
		Quini unQuini = new Quini();
		Casillero unCasillero = new Casillero(unQuini);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL + PRIMER_PREMIO, unJugador.getDinero());
	}
	
	@Test
	public void test02JugadorCaeEnQuiniPorSegundaVezGanaSegundoPremio() {
		Quini unQuini = new Quini();
		Casillero unCasillero = new Casillero(unQuini);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador);
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL + PRIMER_PREMIO + SEGUNDO_PREMIO, unJugador.getDinero());
	}
	
	@Test
	public void test03JugadorCaeEnQuiniPorTerceraVezNoGanaNada() {
		Quini unQuini = new Quini();
		Casillero unCasillero = new Casillero(unQuini);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador);
		unCasillero.accionarPropiedad(unJugador);
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL + PRIMER_PREMIO + SEGUNDO_PREMIO + TERCER_PREMIO, unJugador.getDinero());
	}

}
