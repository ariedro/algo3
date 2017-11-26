package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Jugador;


public class AlgoPolyTest {


	private static final int CANTIDAD_JUGADORES = 3;

	@Test
	public void test01CrearAlgoPolyNoEsNull() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertNotNull(unAlgoPoly);
		
	}

	@Test
	public void test02AlgoPolyCreadoTieneTresJugadores() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertEquals(CANTIDAD_JUGADORES, unAlgoPoly.getCantidadJugadores());
		
	}


	@Test
	public void test03AlgoPolyCreadoTieneUnTableroNoNulo() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertNotNull(unAlgoPoly.getTablero());
		
		}
		

	@Test
	public void test04GetJugadorActualDevuelveUnJugadorNoNulo() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertNotNull(unAlgoPoly.getJugadorActual());
		
	}
	
	@Test
	public void test05GetDosVecesElJugadorActualDevuelveElMismoJugador() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		Jugador unJugador = unAlgoPoly.getJugadorActual();
		
		Jugador otroJugador = unAlgoPoly.getJugadorActual();
		
		assertEquals(unJugador, otroJugador);
		
	}
	
	@Test
	public void test06GetJugadorDespuesDeTerminarTurnoDevuelveUnJugadorNoNulo() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		unAlgoPoly.acabarTurno();
		
		assertNotNull(unAlgoPoly.getJugadorActual());
		
	}
	

	@Test
	public void test07GetJugadorDespuesDeTerminarTurnoDevuelveUnJugadorDistintoAlAnterior() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		Jugador primerJugador = unAlgoPoly.getJugadorActual();
		
		unAlgoPoly.acabarTurno();
		
		Jugador segundoJugador = unAlgoPoly.getJugadorActual();
		
		assertFalse(primerJugador == segundoJugador);
		
	}
	
	@Test
	public void test08AlAcabarTresTurnosGetJugadorDevuelveElPrimerJugador() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		Jugador primerJugador = unAlgoPoly.getJugadorActual();
		
		unAlgoPoly.acabarTurno();
		unAlgoPoly.acabarTurno();
		unAlgoPoly.acabarTurno();
		
		
		assertEquals(primerJugador, unAlgoPoly.getJugadorActual());
		
		
	}
	
	@Test
	public void test09JugadorTiraDadosYSiTienenMismoValorVuelveAJugar() {
		AlgoPoly aPoly = new AlgoPoly();
		
		Jugador unJugador = aPoly.getJugadorActual();
		aPoly.turnar(unJugador);
		int resDado1 = aPoly.getDados().getValorPrimerDado();
		int resDado2 = aPoly.getDados().getValorSegundoDado();
		while (resDado1 != resDado2) {
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();

		assertEquals(unJugador, aPoly.getJugadorActual());
	}
	
	@Test
	public void test10JugadorTiraDadosYSiTienenMismoValorDosVecesNoVuelveAJugar() {
		AlgoPoly aPoly = new AlgoPoly();
		
		Jugador unJugador = aPoly.getJugadorActual();
		aPoly.turnar(unJugador);
		int resDado1 = aPoly.getDados().getValorPrimerDado();
		int resDado2 = aPoly.getDados().getValorSegundoDado();
		while (resDado1 != resDado2) {
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();
		while (resDado1 != resDado2) {
			aPoly.turnar(unJugador);
			resDado1 = aPoly.getDados().getValorPrimerDado();
			resDado2 = aPoly.getDados().getValorSegundoDado();
		}
		aPoly.acabarTurno();

		assertNotEquals(unJugador, aPoly.getJugadorActual());
	}
	
	

}



