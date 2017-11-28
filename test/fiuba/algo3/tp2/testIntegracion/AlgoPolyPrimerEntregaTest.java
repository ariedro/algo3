package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.excepciones.*;
import fiuba.algo3.clases.*;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.encasillables.Carcel;
import fiuba.algo3.encasillables.Policia;
import fiuba.algo3.encasillables.Quini;

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
	
	private static int INDICE_AVANCE_DINAMICO = 7;
	private static int INDICE_RETROCESO_DINAMICO = 18;
	
	
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
		catch (JugadorNoPuedePagarFianzaException e) { }
		assertFalse(unJugador.puedeAccionar());
	}
	
	
	
	@Test
	public void test08JugadorCaeEnAvanceDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
		Tablero unTablero = new Tablero();
		Jugador unJugador = new Jugador();
		unTablero.agregarJugador(unJugador);
		unTablero.modificarPosicion(unJugador, INDICE_AVANCE_DINAMICO);
		
		Dados unosDados = new Dados();
		unJugador.tirarDados(unosDados);
		
		while (unosDados.getSuma() > 6) {
			unJugador.finalizarTurno();
			unJugador.tirarDados(unosDados);
			
		}
		
		Casillero casilleroAvanceDinamico = unTablero.getCasillero(INDICE_AVANCE_DINAMICO);
		
		casilleroAvanceDinamico.accionarPropiedad(unJugador);
		
		assertEquals(INDICE_AVANCE_DINAMICO + unosDados.getSuma() - 2, unTablero.getPosicion(unJugador));
	
	
	}
	
	
	
	
	@Test
	public void test09JugadorCaeEnAvanceDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador, INDICE_AVANCE_DINAMICO);
		
		Dados unosDados = new Dados();
		
		unJugador.tirarDados(unosDados);
		
		while (unosDados.getSuma() < 7 || unosDados.getSuma() > 10) {
		
			unJugador.finalizarTurno();
			unJugador.tirarDados(unosDados);
		
		}
		
		Casillero casilleroAvanceDinamico = unTablero.getCasillero(INDICE_AVANCE_DINAMICO);
		
		casilleroAvanceDinamico.accionarPropiedad(unJugador);
		
		assertEquals(INDICE_AVANCE_DINAMICO + (DINERO_INICIAL % unosDados.getSuma()), 
				
				unTablero.getPosicion(unJugador));
		
	}
	
	@Test
	/*Si la prueba se hace sacando 12, la nueva posicion es RetrocesoDinamico, que me reubica nuevamente*/
	public void test10JugadorCaeEnAvanceDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
		
		
		Tablero unTablero = new Tablero();
	
		Jugador unJugador = new Jugador();
	
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador, INDICE_AVANCE_DINAMICO);
	
		int propiedadesAlCaerEnMovDinamico = 1;
		
		Dados unosDados = new Dados();
	
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		
		unJugador.incorporarPropiedad(unBarrio);
		
		unJugador.tirarDados(unosDados);
		
		while (unosDados.getSuma() != 11) {
			unJugador.finalizarTurno();
			unJugador.tirarDados(unosDados);
		}
		
		Casillero casilleroAvanceDinamico = unTablero.getCasillero(INDICE_AVANCE_DINAMICO);
		
		casilleroAvanceDinamico.accionarPropiedad(unJugador);
	
		assertEquals(INDICE_AVANCE_DINAMICO + unosDados.getSuma() - propiedadesAlCaerEnMovDinamico,
					
				unTablero.getPosicion(unJugador));
	
	}
	
	@Test
	public void test11JugadorCaeEnRetrocesoDinamicoSumandoEntre2Y6SuNuevaPosicionEsLoQueLeCorresponde() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		int propiedadesAlCaerEnMovDinamico = 1;
		
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador, INDICE_RETROCESO_DINAMICO);
		
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		
		unJugador.incorporarPropiedad(unBarrio);
		
		Dados unosDados = new Dados();
		
		unJugador.tirarDados(unosDados);
		
		/*Si sale 4 me manda a Policia, que vuelve a modificar mi posicion*/
		while (unosDados.getSuma() > 6 || unosDados.getSuma() == 4) {
			unJugador.finalizarTurno();
			unJugador.tirarDados(unosDados);
		}
		
		Casillero casilleroRetrocesoDinamico = unTablero.getCasillero(INDICE_RETROCESO_DINAMICO);
		
		casilleroRetrocesoDinamico.accionarPropiedad(unJugador);
		
		assertEquals(INDICE_RETROCESO_DINAMICO - unosDados.getSuma() + propiedadesAlCaerEnMovDinamico,
				
				unTablero.getPosicion(unJugador));
	}
	
	@Test
	public void test12JugadorCaeEnRetrocesoDinamicoSumandoEntre7Y10SuNuevaPosicionEsLoQueLeCorresponde() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador, INDICE_RETROCESO_DINAMICO);
		
		Dados unosDados = new Dados();
		
		unJugador.tirarDados(unosDados);
		
		while (( unosDados.getSuma() < 7 ) || ( unosDados.getSuma() > 10 )) {
			
			unJugador.finalizarTurno();
			
			unJugador.tirarDados(unosDados);
			
		}

		Casillero casilleroRetrocesoDinamico = unTablero.getCasillero(INDICE_RETROCESO_DINAMICO);
		
		casilleroRetrocesoDinamico.accionarPropiedad(unJugador);
		
		assertEquals(INDICE_RETROCESO_DINAMICO - ( DINERO_INICIAL % unosDados.getSuma()), 
				
				unTablero.getPosicion(unJugador));
	}
	 
	@Test
	public void test13JugadorCaeEnRetrocesoDinamicoSumandoEntre11Y12SuNuevaPosicionEsLoQueLeCorresponde() {
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
	
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador, INDICE_RETROCESO_DINAMICO);
		
		Dados unosDados = new Dados();
		
		unJugador.tirarDados(unosDados);
		
		while (unosDados.getSuma() < 11) {
			unJugador.finalizarTurno();
			unJugador.tirarDados(unosDados);
		}

		Casillero casilleroRetrocesoDinamico = unTablero.getCasillero(INDICE_RETROCESO_DINAMICO);
		
		casilleroRetrocesoDinamico.accionarPropiedad(unJugador);
		
		assertEquals(INDICE_RETROCESO_DINAMICO - (unosDados.getSuma() - 2),
				
				unTablero.getPosicion(unJugador));
	}
	
	@Test
	public void test14CuandoJugadorCaeEnPoliciaVaALaCarcelYNoPuedeAccionar() {
		Tablero unTablero = new Tablero();
		Jugador unJugador = new Jugador();
		unTablero.agregarJugador(unJugador);
		
		Policia unPolicia = new Policia(unTablero);
		Casillero unCasillero = new Casillero(unPolicia);
		unCasillero.accionarPropiedad(unJugador);
		assertFalse(unJugador.puedeAccionar());
	}
	
	/*@Test
	public void test15CuandoJugadorCaeEnPoliciaSuUbicacionEsLaCarcel() {

		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		unTablero.agregarJugador(unJugador);
		Casillero casilleroCarcel = unTablero.getCarcel();
		

		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Policia"));
		unCasillero.accionarPropiedad(unJugador);
				
		
		assertEquals(casilleroCarcel, unJugador.getUbicacion());
	}*/	
	
}
