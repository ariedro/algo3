package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Barrios;
import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.DatosDeBarrio;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.clases.Tablero;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;
import fiuba.algo3.excepciones.JugadorNoPuedePagarFianzaException;
import fiuba.algo3.excepciones.JugadorYaTiroDadosException;

public class AlgoPolyTerceraEntregaTest {

	//Los datos corresponden a los Barrios y Servicios utilizados
	private static DatosDeBarrio SANTA_FE = DatosDeBarrio.getDatosBarrio(Barrios.SANTA_FE);
	private static DatosDeBarrio NEUQUEN = DatosDeBarrio.getDatosBarrio(Barrios.NEUQUEN);
	private static DatosDeBarrio TUCUMAN = DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN);
	
	private static final int DINERO_INICIAL = 100000;
	private static final int DINERO_A_SACAR = 99999 - 15000;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	
	// Punto 1
	@Test
	public void test01JugadorTiraDadosYSiTienenMismoValorVuelveAJugar() {
		AlgoPoly aPoly = new AlgoPoly();
		Jugador unJugador = aPoly.getJugadorActual();

		aPoly.turnar(unJugador);
		int resDado1 = aPoly.getDados().getValorPrimerDado();
		int resDado2 = aPoly.getDados().getValorSegundoDado();
		while (resDado1 != resDado2) {
			aPoly.acabarTurno();
			unJugador = aPoly.getJugadorActual();
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();

		assertEquals(unJugador, aPoly.getJugadorActual());
	}
	
	// Punto 2
	@Test
	public void test02JugadorTiraDadosYSiTienenMismoValorDosVecesNoVuelveAJugar() {
		AlgoPoly aPoly = new AlgoPoly();
		Jugador unJugador = aPoly.getJugadorActual();
		aPoly.turnar(unJugador);
		int resDado1 = aPoly.getDados().getValorPrimerDado();
		int resDado2 = aPoly.getDados().getValorSegundoDado();
		while (resDado1 != resDado2) {
			aPoly.acabarTurno();
			unJugador = aPoly.getJugadorActual();
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();
		while (resDado1 != resDado2) {
			aPoly.acabarTurno();
			unJugador = aPoly.getJugadorActual();
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();

		assertNotEquals(unJugador, aPoly.getJugadorActual());
	}
	
	// Punto 3
	@Test
	public void test03JugadorNoCuentaConEfectivoYCaeEnUnAreaQueGeneraGastoVendeSuPropiedadParaPagarYUnTercerJugadorCompraEsaPropiedad(){Jugador primerJugador = new Jugador();
		Jugador segundoJugador = new Jugador();
		Jugador tercerJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero primerCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Tucuman"));
		primerCasillero.accionarPropiedad(primerJugador);
		Casillero segundoCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Santa Fe"));
		segundoCasillero.accionarPropiedad(segundoJugador);
		segundoJugador.sacarDinero(DINERO_A_SACAR);
		primerCasillero.accionarPropiedad(segundoJugador);
		segundoCasillero.accionarPropiedad(tercerJugador);
		assertTrue(tercerJugador.estaEntreLasPropiedades("Santa Fe"));
	}
	
	// Punto 4
	@Test
	public void test04JugadorTiraDadosYSeMueveEnLaPosicionQueIndicabanLosDados() {
		/*
		 * El while es para que cuando saque 7(avance dinamico) no tire error,
		 * porque el casillero al que cae no es el mismo que el nro de dados que saca
		 */
		AlgoPoly aPoly = new AlgoPoly(); 
		Jugador unJugador = null;
		int suma = 7;
		while (suma == 7) {
			aPoly = new AlgoPoly();
			unJugador = aPoly.getJugadorActual();
			aPoly.turnar(unJugador);
			suma = aPoly.getDados().getSuma();
		}
		assertEquals(aPoly.getTablero().getCasillero(suma), unJugador.getUbicacion());
	}
	
	// Punto 5
	@Test
	public void test05NoSePuedeConstruirHotelesEnSantaFe() {
		Tablero unTablero = new Tablero();
		Jugador unJugador = new Jugador();
		Casillero casilleroSantaFe = unTablero.getCasillero(unTablero.getIndiceConNombre("Santa Fe"));
		casilleroSantaFe.accionarPropiedad(unJugador);

		thrown.expect(BarrioNoPuedeConstruirHotelException.class);
		unJugador.construirHotel("Santa Fe");		
	}
	
	@Test
	public void test06NoSePuedeConstruirHotelesEnNeuquen() {
		Tablero unTablero = new Tablero();
		Jugador unJugador = new Jugador();
		Casillero casilleroSantaFe = unTablero.getCasillero(unTablero.getIndiceConNombre("Neuquen"));
		
		casilleroSantaFe.accionarPropiedad(unJugador);

		thrown.expect(BarrioNoPuedeConstruirHotelException.class);
		unJugador.construirHotel("Neuquen");		
	}

	@Test
	public void test07NoSePuedeConstruirHotelesEnTucuman() {
		Tablero unTablero = new Tablero();
		Jugador unJugador = new Jugador();
		Casillero casilleroSantaFe = unTablero.getCasillero(unTablero.getIndiceConNombre("Tucuman"));
		casilleroSantaFe.accionarPropiedad(unJugador);

		thrown.expect(BarrioNoPuedeConstruirHotelException.class);
		unJugador.construirHotel("Tucuman");		
	}
	@Test
	public void test08jugadorSinPlataNiPropiedadesCaeEnUnCasilleroQueGeneraGastoYQuedaEliminado() {
		AlgoPoly algoPoly = new AlgoPoly(); 
		Jugador unJugador = null;
		while (algoPoly.getCantidadJugadores() != 2) {
			unJugador = algoPoly.getJugadorActual();
			algoPoly.turnar(unJugador);
			algoPoly.acabarTurno();
		}
		assertTrue(algoPoly.hayPerdedores());		
	}

	@Test
	public void test09HayUnGanador() {
		AlgoPoly algoPoly = new AlgoPoly(); 
		Jugador unJugador = null;
		while (algoPoly.sePuedeSeguirJugando()) {
			unJugador = algoPoly.getJugadorActual();
			algoPoly.turnar(unJugador);
			algoPoly.acabarTurno();
		}
		assertTrue(algoPoly.hayUnGanador());		
	}
	
	
}
