package fiuba.algo3.tp2.testUnitarios;

import fiuba.algo3.clases.AvanceDinamico;
import fiuba.algo3.tp2.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class AvanceDinamicoTest {
	
	
	@Test
	public void test01CrearUnAvanceDinamicoNoEsNull() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		assertNotNull(unAvanceDinamico);
	}
	
	@Test
	public void test02AvanceDinamicoRecibeUnDosReubicacionEsCero() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(0,unAvanceDinamico.getAvance(unJugador, 2));
	}

	@Test
	public void test03AvanceDinamicoRecibeUnTresReubicacionEsUno() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(1,unAvanceDinamico.getAvance(unJugador, 3));
	}

	@Test
	public void test04AvanceDinamicoRecibeUnCuatroReubicacionEsDos() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(2,unAvanceDinamico.getAvance(unJugador, 4));
	}

	@Test
	public void test05AvanceDinamicoRecibeUnCincoReubicacionEsTres() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(3,unAvanceDinamico.getAvance(unJugador, 5));
	}
	
	
	@Test
	public void test06AvanceDinamicoRecibeUnSeisReubicacionEsCuatro() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(4,unAvanceDinamico.getAvance(unJugador, 6));
	
	}	
	
	
	@Test
	public void test07AvanceDinamicoRecibeSieteReubicacionCorrecta () {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 7, unAvanceDinamico.getAvance(unJugador, 7) );
		
		
		
	}
	
	
	@Test
	public void test08AvanceDinamicoRecibeOchoReubicacionCorrecta () {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 8, unAvanceDinamico.getAvance(unJugador, 8) );
			
	
	}
	
	
	@Test
	public void test09AvanceDinamicoRecibeNueveReubicacionCorrecta () {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 9, unAvanceDinamico.getAvance(unJugador, 9) );
		
	
	}
	
	
	@Test
	public void test10AvanceDinamicoRecibeDiezReubicacionCorrecta () {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 10, unAvanceDinamico.getAvance(unJugador, 10) );
			
	
	 }

	
	@Test
	public void test11AvanceDinamicoRecibeUnOnceYJugadorSinPropiedadesReubicacionCorrecta() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(0);
		
		assertEquals(11 - 0, unAvanceDinamico.getAvance(unJugador, 11));
		
		
		
	}
	

	@Test
	public void test12AvanceDinamicoRecibeUnOnceYJugadorCon3PropiedadesReubicacionCorrecta() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(3);
		
		assertEquals(11 - 3, unAvanceDinamico.getAvance(unJugador, 11));
		
		
		
	}

	@Test
	public void test13AvanceDinamicoRecibeUnDoceYJugadorSinPropiedadesReubicacionCorrecta() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(0);
		
		assertEquals(12 - 0, unAvanceDinamico.getAvance(unJugador, 12));
		
		
		
	}

	@Test
	public void test14AvanceDinamicoRecibeUnDoceYJugadorConSeisPropiedadesReubicacionCorrecta() {
		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(6);
		
		assertEquals(12 - 6, unAvanceDinamico.getAvance(unJugador, 12));
		
		
		
	}



}
