package fiuba.algo3.tp2.testUnitarios;

import fiuba.algo3.clases.Jugador;
import fiuba.algo3.clases.RetrocesoDinamico;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class RetrocesoDinamicoTest {

	@Test
	public void test01RetrocesoDinamicoCreadoNoEsNull(){
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		assertNotNull(unRetroceso);

	
	}
	
	@Test 
	public void test02RetrocesoRecibeUnDosYJugadorSinPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(0);
		
		assertEquals(2 - 0 , unRetroceso.getRetroceso(unJugador,2));
		
		
	}
	
	@Test 
	public void test03RetrocesoRecibeUnDosYJugadorConDosPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(2);
		
		assertEquals(2 - 2 , unRetroceso.getRetroceso(unJugador,2));
		
		
	}
	
	@Test
	public void test04RetrocesoRecibeUnTresYJugadorSinPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(0);
		
		assertEquals(3 - 0 , unRetroceso.getRetroceso(unJugador,3));
		
	}
	
	
	@Test 
	public void test05RetrocesoRecibeUnTresYJugadorConDosPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(2);
		
		assertEquals(3 - 2 , unRetroceso.getRetroceso(unJugador,3));
		
		
	}


	@Test
	public void test06RetrocesoRecibeUnSeisYJugadorSinPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(0);
		
		assertEquals(6 - 0 , unRetroceso.getRetroceso(unJugador,6));
		
	}

	@Test
	public void test07RetrocesoRecibeUnSeisYJugadorConTresPropiedadesRetrocesoCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = mock(Jugador.class);
		when(unJugador.getCantidadPropiedades()).thenReturn(3);
		
		assertEquals(6 - 3 , unRetroceso.getRetroceso(unJugador,6));
		
		
	}

	
	@Test
	public void test08RetrocesoRecibeUnSieteRetrocesoEsCorrecto() {
	
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 7 , unRetroceso.getRetroceso(unJugador, 7));
	

	}
	
	
	@Test 
	public void test09RetrocesoRecibeUnDiezYRetrocesoEsCorrecto() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(unJugador.getDinero() % 10, unRetroceso.getRetroceso(unJugador, 10));
	
	}
	
	
	@Test
	public void test10RetrocesoRecibeUnOnceRetrocesoEsNueve() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(11 - 2 , unRetroceso.getRetroceso(unJugador, 11));
		
	}
	
	@Test
	public void test11RetrocesoRecibeUnDoceRetrocesoEsDiez() {
		
		RetrocesoDinamico unRetroceso = new RetrocesoDinamico();
		
		Jugador unJugador = new Jugador();
		
		assertEquals(12 - 2 , unRetroceso.getRetroceso(unJugador, 12));
		
	}
	
	
	
	
	
	
	
	
}
