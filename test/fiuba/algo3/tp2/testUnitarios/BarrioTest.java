package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.clases.*;
import fiuba.algo3.excepciones.BarrioNoPuedeConstruirHotelException;

public class BarrioTest {

	private static final int DINERO_INICIAL = 100000;
	
	
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
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void test01CrearBarrioNoEsNulo() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		assertNotNull(unBarrio);
	}
	
	@Test
	public void test02BarrioCreadoNoTieneDuenio() {
		
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		
		assertNull(unBarrio.getPropietario());
		
	}
	
	public void test03NoSePuedeConstruirEnBarrioSinPropietario() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		unBarrio.construirCasa();
		assertEquals(0, unBarrio.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test04NoSePuedeConstruirEnBarrioSinPropiedadVecina() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		unBarrio.construirCasa();
		assertEquals(0, unBarrio.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test05SiPropietarioTieneBarrioVecinoSePuedeConstruirUnaCasa() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		assertEquals(1, unBarrioSur.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test06SiPropietarioTieneBarrioVecinoSePuedeConstruirDosCasas() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		assertEquals(2, unBarrioSur.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test07SiBarrioVecinoNoTieneConstruidasDosCasasNoSePuedeConstruirHotel() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		unBarrioSur.construirHotel();
		assertFalse(unBarrioSur.fueConstruidoHotel());
	}
	
	@Test
	public void test08SiBarrioVecinoTieneConstruidasDosCasasSePuedeConstruirHotel() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioSur.construirHotel();
		assertTrue(unBarrioSur.fueConstruidoHotel());
	}
	
	@Test
	public void test09SiBarrioNoPuedeTenerVecinoSePuedeConstruirUnaCasa() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		unBarrio.construirCasa();
		assertEquals(1, unBarrio.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test10SiBarrioNoPuedeTenerVecinoNoSePuedenConstruirDosCasas() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		unBarrio.construirCasa();
		unBarrio.construirCasa();
		assertEquals(1, unBarrio.getNumeroDeCasasConstruidas());
	}
	
	@Test
	public void test11BarrioSinCasasNiHotelCobraAlquilerSimple() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		assertEquals(ALQUILER_SIMPLE, unBarrio.getAlquiler());
	}
	
	@Test
	public void test12BarrioConUnaCasaCobraAlquilerConUnaCasa() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		assertEquals(ALQUILER_UNA_CASA, unBarrioSur.getAlquiler());
	}
	
	@Test
	public void test13BarrioConDosCasasCobraAlquilerConDosCasas() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		assertEquals(ALQUILER_DOS_CASAS, unBarrioSur.getAlquiler());
	}
	
	@Test
	public void test14BarrioConHotelCobraAlquilerConHotel() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioSur.construirHotel();
		assertEquals(ALQUILER_HOTEL, unBarrioSur.getAlquiler());
	}
	
	@Test
	public void test15CuandoJugadorPropietarioVendeSuBarrioYaNoEsMasPropietario() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		unJugador.darDeBajaPropiedad(unBarrio);
		assertTrue(unBarrio.esPropietario(unJugador));
	}
	
	@Test
	public void test16ValorDeVentaEsIgualAValorDeTodoLoQueEstaEnElBarrioMenosEl15Porciento() {
		Barrio unBarrioSur = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Barrio unBarrioNorte = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrioSur.accionarCon(unJugador);
		unBarrioNorte.accionarCon(unJugador);
		unBarrioSur.construirCasa();
		unBarrioSur.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioNorte.construirCasa();
		unBarrioSur.construirHotel();
		assertEquals(((int) ((PRECIO + PRECIO_HOTEL) * 0.85)), unBarrioSur.getValorVenta());
	}
	
	@Test
	public void test17JugadorTrataDeConstruirHotelSinCumplirConLosRequisitosLanzaException() {
		Barrio unBarrio= new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		thrown.expect(BarrioNoPuedeConstruirHotelException.class);
		unBarrio.construirHotel();	
	}
}