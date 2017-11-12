package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.mockito.Mockito.*;

import fiuba.algo3.tp2.Barrio;
import fiuba.algo3.tp2.Jugador;

public class JugadorTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int PRECIO_BARRIO = 10000;
	
	
	
	@Test
	public void test01CrearJugadorNoEsNull() {
	
		Jugador unJugador = new Jugador();
		
		assertNotNull(unJugador);
	
	}
	

	
	@Test
	public void test02JugadorCreadoEmpiezaConValorInicial() {
		
		Jugador unJugador = new Jugador();
		
		assertEquals(DINERO_INICIAL,unJugador.getDinero());
	
	}

	@Test
	public void test03RecibirDineroSumaElValorCorrecto() {
		
		Jugador unJugador = new Jugador();
		
		unJugador.recibirDinero(100);
		
		assertEquals(DINERO_INICIAL+100,unJugador.getDinero());
	
	}
	
	@Test 
	public void test04JugadorCreadoNoPoseePropiedades() {
			
		Jugador unJugador = new Jugador();
		
		assertEquals(0,unJugador.getCantidadPropiedades());
	
	}

	@Test
	public void test05JugadorCompraUnaPropiedadDisminuyeSuDinero() {
		
		Jugador unJugador = new Jugador ();
		
		Barrio unBarrio = mock(Barrio.class);
		when (unBarrio.getPrecio()).thenReturn(PRECIO_BARRIO);
		
		unJugador.comprarPropiedad(unBarrio);
		
		assertEquals(DINERO_INICIAL - PRECIO_BARRIO, unJugador.getDinero());
	
		
	}

	@Test
	public void test06JugadorCompraUnaPropiedadAumentaCantidadPropiedades() {
		
		Jugador unJugador = new Jugador();
		
		Barrio unBarrio = mock(Barrio.class);
		when (unBarrio.getPrecio()).thenReturn(PRECIO_BARRIO);
		
		unJugador.comprarPropiedad(unBarrio);
		
		assertEquals(1 , unJugador.getCantidadPropiedades());
		
	}
	
	
}
