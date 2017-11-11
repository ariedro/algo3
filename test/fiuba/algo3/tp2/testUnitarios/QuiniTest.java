package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuiniTest {
	
	private static final int DINERO_INICIAL = 100000;
	private static final int PRIMER_PREMIO = 50000;
	private static final int SEGUNDO_PREMIO = 30000;
	private static final int TERCER_PREMIO = 0;
	
	@Test
	public void test01CrearQuiniNoEsNulo() {
		Quini unQuini = new Quini();
		assertNotNull(unQuini);
	}
	
	@Test
	public void test02JugadorGanaQuiniPorPrimeraVezGanaElPrimerValor() {
		Quini unQuini = new Quini();
		Jugador unJugador = new Jugador();
		assertEquals(PRIMER_PREMIO,unQuini.getPremio(unJugador));
	}
	
	@Test
	public void test03JugadorGanaQuiniPorSegundaVezGanaElSegundoValor() {
		Quini unQuini = new Quini();
		Jugador unJugador = new Jugador();
		unQuini.getPremio(unJugador);
		assertEquals(SEGUNDO_PREMIO,unQuini.getPremio(unJugador));
	}
	
	@Test
	public void test04JugadorGanaQuiniPorTercerVezNoGanaNada() {
		Quini unQuini = new Quini();
		Jugador unJugador = new Jugador();
		unQuini.getPremio(unJugador);
		unQuini.getPremio(unJugador);
		assertEquals(TERCER_PREMIO,unQuini.getPremio(unJugador));
	}
	
	@Test
	public void test05JugadorFueGanadorSiGanoElPremioUnaVez() {
		Quini unQuini = new Quini();
		Jugador unJugador = new Jugador();
		unQuini.getPremio(unJugador);
		assertTrue(unQuini.estaEntreLosGanadores(unJugador));
	}
	
	@Test
	public void test06JugadorFueGanadorRecibeDineroSiCorresponde() {
		Quini unQuini = new Quini();
		Jugador unJugador = new Jugador();
		unQuini.activar(unJugador);
		assertEquals(DINERO_INICIAL+PRIMER_PREMIO, unJugador.getDinero());
	}
	
}	
	
	
	
