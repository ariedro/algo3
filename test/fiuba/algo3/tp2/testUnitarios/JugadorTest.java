package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
//import static org.mockito.Mockito.*;
import org.junit.rules.ExpectedException;

import fiuba.algo3.clases.*;
import fiuba.algo3.excepciones.*;
import jdk.internal.util.xml.PropertiesDefaultHandler;

public class JugadorTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int PRECIO_BARRIO = 10000;
	private static final double PROPORCION_VALOR_VENTA = 0.85;

	@Rule
    public ExpectedException thrown = ExpectedException.none();

		
	
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


	@Test 
	public void test07JugadorVendeUnaPropiedadJugadorRecupera85PorCientoDelDinero() {
		
		Jugador unJugador = new Jugador();
		
		Barrio unBarrio = mock(Barrio.class);
		when(unBarrio.getPrecio()).thenReturn(PRECIO_BARRIO);
		when(unBarrio.getValorVenta()).thenReturn((int)(PRECIO_BARRIO * PROPORCION_VALOR_VENTA));
		
		unJugador.comprarPropiedad(unBarrio);
		
		unJugador.venderPropiedad(unBarrio);
		
		assertEquals((int) (DINERO_INICIAL - PRECIO_BARRIO + (int) (PRECIO_BARRIO * PROPORCION_VALOR_VENTA)),
						unJugador.getDinero() );
	
	
	}

	@Test
	public void test08JugadorVendeUnaPropiedadSuCantidadDePropiedadesDisminuye() {
		
		Jugador unJugador = new Jugador();
		
		Barrio unBarrio = mock(Barrio.class);
		when(unBarrio.getPrecio()).thenReturn(PRECIO_BARRIO);
		when(unBarrio.getValorVenta()).thenReturn((int)(PRECIO_BARRIO * PROPORCION_VALOR_VENTA));
		
		unJugador.comprarPropiedad(unBarrio);
		
		unJugador.venderPropiedad(unBarrio);
		
		assertEquals(0, unJugador.getCantidadPropiedades());
		
		
		
	}

	@Test
	public void test09JugadorMoviendoseEstandoPresoLanzaExcepcion() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(null);
		unaCarcel.aprisionar(unJugador);
		thrown.expect(JugadorEstaEnCanaException.class);
		unJugador.mover(unJugador, unCasillero);
	}	
	
	@Test
	public void test10JugadorQueFueEnCanaPuedeMoverseDespuesDe3Turnos() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(null);
		unaCarcel.aprisionar(unJugador);
		unJugador.finalizarTurno();
		unJugador.finalizarTurno();
		unJugador.finalizarTurno();
		unJugador.mover(unJugador, unCasillero);		
		assertEquals(unCasillero,unJugador.getUbicacion());
	}
	
	@Test
	public void test11JugadorNoPuedePagarFianzaEnPrimerTurno() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		unaCarcel.aprisionar(unJugador);
		thrown.expect(JugadorNoPuedePagarFianza.class);
		unJugador.pagarFianza();
	}
	
	@Test
	public void test12JugadorPuedePagarFianzaEnSegundoTurno() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		Casillero unCasillero = new Casillero(null);
		unaCarcel.aprisionar(unJugador);
		unJugador.finalizarTurno();
		unJugador.pagarFianza();
		unJugador.mover(unJugador, unCasillero);		
		assertEquals(unCasillero,unJugador.getUbicacion());
	}
	
	@Test
	public void test13JugadorNoPuedePagarFianzaSiNoLeAlcanzaLaPlata() {
		Jugador unJugador = new Jugador();
		Carcel unaCarcel = new Carcel();
		unJugador.sacarDinero(DINERO_INICIAL - 1); //Se queda con 1 peso
		unaCarcel.aprisionar(unJugador);
		unJugador.finalizarTurno();
		thrown.expect(JugadorNoPuedePagarFianza.class);
		unJugador.pagarFianza();
	}
	
	@Test
	public void test14JugadorNoPuedePagarFianzaSiEstaEnLibertad() {
		Jugador unJugador = new Jugador();
		thrown.expect(JugadorNoPuedePagarFianza.class);
		unJugador.pagarFianza();
	}
}
