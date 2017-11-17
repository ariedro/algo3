package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.excepciones.*;
import fiuba.algo3.clases.*;
import static org.mockito.Mockito.*;

public class AlgoPolyPrimerEntregaTest {

	//Los datos corresponden al barrio BUENOS_AIRES_SUR
	private static String NOMBRE = "Buenos Aires Sur";
	private static String VECINO = "Buenos Aires Norte";
	private static int PRECIO = 20000;
	private static int PRECIO_CASA = 5000;
	private static int PRECIO_HOTEL = 8000;
	private static int MAXIMO_CASAS = 2;
	private static int ALQUILER_SIMPLE = 2000;
	private static int ALQUILER_UNA_CASA = 3000;
	private static int ALQUILER_DOS_CASAS = 3500;
	private static int ALQUILER_HOTEL = 5000;
	
	
	
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
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Casillero unCasillero = new Casillero(unBarrio);
		Jugador unJugador = mock(Jugador.class);
		when (unJugador.getDinero()).thenReturn(DINERO_INICIAL);
		when (unJugador.tomarDecisionDeComprarPropiedad()).thenReturn(COMPRAR);
		unCasillero.accionarPropiedad(unJugador);
		assertTrue(unBarrio.esPropietario(unJugador));
	}

	@Test
	public void test05JugadorCaeEnLaCarcelNoPuedeDesplazarse() {
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(unaCarcel);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador);
		assertFalse(unJugador.puedeAccionar());
		
	}
	
	@Test
	public void test06JugadorPagaFianzaFueLiberadoPuedeMoverse() {
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(unaCarcel);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador); 
		unJugador.finalizarTurno(); //Pasa el primer turno.
		unJugador.finalizarTurno(); //Pasa el segundo turno.
		unJugador.pagarFianza(); // Paga fianza en tercer turno.
		assertTrue(unJugador.puedeAccionar());
	}
	
	@Test
	public void test07JugadorNoPuedePagarFianzaNoPuedeMoverse() {
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(unaCarcel);
		Jugador unJugador = new Jugador();
		unCasillero.accionarPropiedad(unJugador); 
		unJugador.finalizarTurno(); //Pasa el primer turno.
		unJugador.finalizarTurno(); //Pasa el segundo turno.
		unJugador.sacarDinero(DINERO_INICIAL);
		try {
			unJugador.pagarFianza(); // Paga fianza en tercer turno.
		}
		catch (JugadorNoPuedePagarFianza e) { }
		assertFalse(unJugador.puedeAccionar());
	}
	
	@Test
	public void test08JugadorCaeEnAvanceDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
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
	public void test09JugadorCaeEnAvanceDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
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
	public void test10JugadorCaeEnAvanceDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
		AvanceDinamico unAvance = new AvanceDinamico();
		Casillero unCasillero = new Casillero(unAvance);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
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
	public void test11JugadorCaeEnRetrocesoDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		Casillero unCasillero = new Casillero(unRetroceso);
		Jugador unJugador = new Jugador();
		Dado unDado = new Dado();
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
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
	
	 void test12JugadorCaeEnRetrocesoDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
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
	public void test13JugadorCaeEnRetrocesoDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
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
	
	@Test
	public void test14CuandoJugadorCaeEnPoliciaVaALaCarcelYNoPuedeAccionar() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero casilleroCarcel = new Casillero(unaCarcel);
		Policia unPolicia = new Policia(casilleroCarcel);
		Casillero unCasillero = new Casillero(unPolicia);
		unCasillero.accionarPropiedad(unJugador);
		assertFalse(unJugador.puedeAccionar());
	}
	
	@Test
	public void test15CuandoJugadorCaeEnPoliciaSuUbicacionEsLaCarcel() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero casilleroCarcel = new Casillero(unaCarcel);
		Policia unPolicia = new Policia(casilleroCarcel);
		Casillero unCasillero = new Casillero(unPolicia);
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(casilleroCarcel, unJugador.getUbicacion());
	}	
	
}
