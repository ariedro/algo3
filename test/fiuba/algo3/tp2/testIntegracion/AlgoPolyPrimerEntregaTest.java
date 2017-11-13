package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import static org.mockito.Mockito.*;

public class AlgoPolyPrimerEntregaTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int PRIMER_PREMIO = 50000;
	private static final int SEGUNDO_PREMIO = 30000;
	private static final int TERCER_PREMIO = 0;
	private static final boolean COMPRAR = true;
	private static final boolean NO_COMPRAR = false;
	
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
	
	@Test
	public void test04JugadorCaeEnUnBarrioYSeAdueniaDeEsteVerificandoQueEsPropietario() {
		Barrio unBarrio = new Barrio();
		Casillero unCasillero = new Casillero(unBarrio);
		Jugador unJugador = mock(Jugador.class);
		when (unJugador.getDinero()).thenReturn(DINERO_INICIAL);
		when (unJugador.tomarDecisionDeComprarPropiedad()).thenReturn(COMPRAR);
		unCasillero.accionarPropiedad(unJugador);
		assertTrue(unBarrio.esPropietario(unJugador));
	}

	@Test
	public void test05JugadorCaeEnAvanceDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
		AvanceDinamico unAvance = new AvanceDinamico();
		Casillero unCasillero = new Casillero(unAvance);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroSumado = 12;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		while (numeroSumado > 6) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(numeroRandom - 2, unJugador.getResultadoDinamico());
	}
	
	@Test
	public void test06JugadorCaeEnAvanceDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
		AvanceDinamico unAvance = new AvanceDinamico();
		Casillero unCasillero = new Casillero(unAvance);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroSumado = 12;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		while (numeroSumado < 7 || numeroSumado > 10) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(unJugador.getDinero() % numeroRandom, unJugador.getResultadoDinamico());
	}
	
	@Test
	public void test07JugadorCaeEnAvanceDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
		AvanceDinamico unAvance = new AvanceDinamico();
		Casillero unCasillero = new Casillero(unAvance);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		Barrio unBarrio = new Barrio();
		int numeroSumado = 1;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		unJugador.incorporarPropiedad(unBarrio);
		while (numeroSumado < 11) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(numeroRandom - unJugador.getCantidadPropiedades(), unJugador.getResultadoDinamico());
	}
	
	@Test
	public void test08JugadorCaeEnRetrocesoDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		Casillero unCasillero = new Casillero(unRetroceso);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		Barrio unBarrio = new Barrio();
		int numeroSumado = 12;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		unJugador.incorporarPropiedad(unBarrio);
		while (numeroSumado > 6) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(numeroRandom - unJugador.getCantidadPropiedades(), unJugador.getResultadoDinamico());
	}
	
	 void test09JugadorCaeEnRetrocesoDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		Casillero unCasillero = new Casillero(unRetroceso);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroSumado = 12;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		while (numeroSumado < 7 || numeroSumado > 10) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(unJugador.getDinero() % numeroRandom, unJugador.getResultadoDinamico());
	}
	 
	@Test
	public void test10JugadorCaeEnRetrocesoDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		Casillero unCasillero = new Casillero(unRetroceso);
			Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroSumado = 1;
		int resultadoPrimerDado = 0;
		int resultadoSegundoDado = 0;
		while (numeroSumado < 11) {
			resultadoPrimerDado = unJugador.tirarDado(unDado);
			resultadoSegundoDado = unJugador.tirarDado(unDado);
			numeroSumado = resultadoPrimerDado + resultadoSegundoDado;
		}
		unJugador.setResultadoDados(resultadoPrimerDado,resultadoSegundoDado);
		int numeroRandom = unJugador.getResultadoDados();
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(numeroRandom - 2, unJugador.getResultadoDinamico());
	}
	
	
	
}
