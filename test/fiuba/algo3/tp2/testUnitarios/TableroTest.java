package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.clases.Tablero;

public class TableroTest {

	

	private static final int TAM_TABLERO = 20;

	
	@Test
	public void test01CrearTableroNoEsNull() {
		Tablero unTablero = new Tablero();
		assertNotNull(unTablero);
	}


	@Test
	public void test02TableroCreadoTieneCeroJugadoresUbicados() {
		
		Tablero unTablero = new Tablero();
		
		assertEquals(0, unTablero.getCantidadJugadores());
		
		
	}

	
	@Test
	public void test03AgregarJugadorAlTableroLoAgregaEnLaPosicionDeSalida() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
		
		assertEquals(0, unTablero.getPosicion(unJugador));
		
	}
	

	@Test
	public void test04AdelantarCincoPosicionesUnJugadorModificaCorrectamenteSuPosicion() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
	
		unTablero.agregarJugador(unJugador);
		
		unTablero.modificarPosicion(unJugador,5);
		
		assertEquals(5,unTablero.getPosicion(unJugador));

	}
	
	@Test
	public void test05AvanceMayorQueElTamanioDelTableroLoHaceDarUnaVuelta() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
	
		unTablero.modificarPosicion(unJugador, 28);
		
		assertEquals(28 - TAM_TABLERO, unTablero.getPosicion(unJugador));
		
		
	}
	
	
	
	@Test 
	public void test06ModificacionNegativaLoHaceRetrocederPosiciones() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
	
		unTablero.modificarPosicion(unJugador, 15);
		
		unTablero.modificarPosicion(unJugador, -5);
		
		assertEquals(15 - 5, unTablero.getPosicion(unJugador));
	
	}
	
	@Test
	public void test07ModificacionNegativaATravesDelCeroSeRealizaCorrectamente() {
		
		Tablero unTablero = new Tablero();
		
		Jugador unJugador = new Jugador();
		
		unTablero.agregarJugador(unJugador);
	
		unTablero.modificarPosicion(unJugador, -7);
		
		assertEquals(TAM_TABLERO - 7, unTablero.getPosicion(unJugador));
	
	
	}
	
	
	@Test
	public void test08GetCasilleroConIndiceMenorAlTamanioDevuelveUnCasilleroNoNulo() {
		
		Tablero unTablero = new Tablero();
		
		Casillero unCasillero = unTablero.getCasillero(10);
		
		assertNotNull(unCasillero);

		
		
		
	}
	
	
}
