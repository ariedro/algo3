package fiuba.algo3.tp2.testIntegracion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.excepciones.*;
import fiuba.algo3.clases.*;
import static org.mockito.Mockito.*;

public class AlgoPolySegundaEntregaTest {

	//Los datos corresponden a los Barrios y Servicios utilizados
	private static DatosDeBarrio BUENOS_AIRES_SUR = DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR);
	private static DatosDeBarrio BUENOS_AIRES_NORTE = DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE);
	
	private static final int DINERO_INICIAL = 100000;
	private static final boolean COMPRAR = true;
	private static final boolean NO_COMPRAR = false;
	
	@Test
	public void test01CuandoJugadorCaeEnBarrioYLoCompraSeVerificaQueSuDineroSeRedujoElPrecioDelBarrio(){
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio(), unJugador.getDinero());
	}
	
	@Test
	public void test02JugadorCuentaConBuenosAiresSuryNorteConstruyeCasaYSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Buenos Aires Sur");
		int dineroRestante = DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio() - BUENOS_AIRES_NORTE.getPrecio();
		assertEquals(dineroRestante - BUENOS_AIRES_SUR.getPrecioCasa(), unJugador.getDinero());
	}
	
	@Test
	public void test03CuandoJugadorCuentaConBsAsSuryNorteConUnaCasaEnCadaUnaYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - BUENOS_AIRES_SUR.getAlquilerUnaCasa(), otroJugador.getDinero());
	}
	
	@Test
	public void test04CuandoJugadorCuentaConAmbasBsAsConDosCasasEnSurYUnaEnNorteYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - BUENOS_AIRES_SUR.getAlquilerDosCasas(), otroJugador.getDinero());
	}
	
	@Test
	public void test05CuandoJugadorCuentaConAmbasBsAsPeroNoTieneCubiertaSuMaximaCapacidadDeCasasYConstruyeHotelSuDineroNoCambia() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirHotel("Buenos Aires Sur");
		int dineroRestante = DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio() - BUENOS_AIRES_NORTE.getPrecio();
		assertEquals(dineroRestante, unJugador.getDinero());
	}
	
	@Test
	public void test06CuandoJugadorCuentaConAmbasBsAsConDosCasasYConstruyeUnHotelSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Norte");
		unJugador.construirCasa("Buenos Aires Norte");
		unJugador.construirHotel("Buenos Aires Sur");
		int dineroRestante = DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio() - BUENOS_AIRES_NORTE.getPrecio()
				- (BUENOS_AIRES_SUR.getPrecioCasa() * 2) - (BUENOS_AIRES_NORTE.getPrecioCasa() * 2);
		assertEquals(dineroRestante - BUENOS_AIRES_SUR.getPrecioHotel(), unJugador.getDinero());
	}
	
	@Test
	public void test07CuandoJugadorCuentaConAmbasBsAsConDosCasasYConstruyeUnHotelAlCaerContrincantePierdeDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Sur");
		unJugador.construirCasa("Buenos Aires Norte");
		unJugador.construirCasa("Buenos Aires Norte");
		unJugador.construirHotel("Buenos Aires Sur");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - BUENOS_AIRES_SUR.getAlquilerHotel(), otroJugador.getDinero());
	}
	
	//PRUEBAS NUMERO 13 y 14 en la entrega, segun lo sugerido por Fede.
	
	@Test
	public void test08JugadorVendeUnaPropiedadYCuandoOtroJugadorCaeEnEsaPropiedadPuedeComprarla() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.venderPropiedad("Buenos Aires Sur");
		unCasillero.accionarPropiedad(otroJugador);
		assertTrue(otroJugador.estaEntreLasPropiedades("Buenos Aires Sur"));
	}
	
	//PRUEBA NUMERO 15 en la entrega.
	
	@Test
	public void test09JugadorCaeEnImpuestoAlLujoYSuDineroSeReduceEn10Porciento() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Impuesto Al Lujo"));
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL - ((int) (DINERO_INICIAL * 0.1)), unJugador.getDinero());
	}
	
}