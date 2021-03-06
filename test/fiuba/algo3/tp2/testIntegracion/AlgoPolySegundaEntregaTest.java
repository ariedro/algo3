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
	private static DatosDeBarrio CORDOBA_SUR = DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_SUR);
	private static DatosDeBarrio CORDOBA_NORTE = DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_NORTE);
	private static DatosDeBarrio SANTA_FE = DatosDeBarrio.getDatosBarrio(Barrios.SANTA_FE);
	private static DatosDeBarrio SALTA_SUR = DatosDeBarrio.getDatosBarrio(Barrios.SALTA_SUR);
	private static DatosDeBarrio SALTA_NORTE = DatosDeBarrio.getDatosBarrio(Barrios.SALTA_NORTE);
	private static DatosDeBarrio NEUQUEN = DatosDeBarrio.getDatosBarrio(Barrios.NEUQUEN);
	private static DatosDeBarrio TUCUMAN = DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN);
	
	private static DatosDeServicio AYSA = DatosDeServicio.getDatosServicio(Servicios.AYSA);
	private static DatosDeServicio EDESUR = DatosDeServicio.getDatosServicio(Servicios.EDESUR);
	private static DatosDeServicio SUBTE = DatosDeServicio.getDatosServicio(Servicios.SUBTE);
	private static DatosDeServicio TREN = DatosDeServicio.getDatosServicio(Servicios.TREN);
	
	private static final int DINERO_INICIAL = 100000;
	private static final boolean COMPRAR = true;
	private static final boolean NO_COMPRAR = false;
	
	// Punto 1 de la entrega.
	
	@Test
	public void test01CuandoJugadorCaeEnBarrioYLoCompraSeVerificaQueSuDineroSeRedujoElPrecioDelBarrio(){
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio(), unJugador.getDinero());
	}
	
	// Punto 2 de la entrega.
	
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
	
	// Punto 3 de la entrega.
	
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
	
	// Punto 4 de la entrega.
	
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
	
	// Punto 5 de la entrega.
	
	@Test
	public void test05CuandoJugadorCuentaConAmbasBsAsPeroNoTieneCubiertaSuMaximaCapacidadDeCasasYConstruyeHotelSuDineroNoCambia() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		try {
			unJugador.construirHotel("Buenos Aires Sur");
		} catch (BarrioNoPuedeConstruirHotelException e) {};
		int dineroRestante = DINERO_INICIAL - BUENOS_AIRES_SUR.getPrecio() - BUENOS_AIRES_NORTE.getPrecio();
		assertEquals(dineroRestante, unJugador.getDinero());
	}
	
	// Punto 6 de la entrega.
	
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
	
	// Punto 7 de la entrega.
	
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
	
	// Punto 8 de la entrega.
	
	@Test
	public void test08JugadorCuentaConCordobaSuryNorteConstruyeCasaYSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Cordoba Sur");
		int dineroRestante = DINERO_INICIAL - CORDOBA_SUR.getPrecio() - CORDOBA_NORTE.getPrecio();
		assertEquals(dineroRestante - CORDOBA_SUR.getPrecioCasa(), unJugador.getDinero());
	}
	
	@Test
	public void test09CuandoJugadorCuentaConCbaSuryNorteConUnaCasaEnCadaUnaYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - CORDOBA_SUR.getAlquilerUnaCasa(), otroJugador.getDinero());
	}
	
	@Test
	public void test10CuandoJugadorCuentaConAmbasCbaConDosCasasEnSurYUnaEnNorteYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - CORDOBA_SUR.getAlquilerDosCasas(), otroJugador.getDinero());
	}
	
	@Test
	public void test11CuandoJugadorCuentaConAmbasCbaPeroNoTieneCubiertaSuMaximaCapacidadDeCasasYConstruyeHotelSuDineroNoCambia() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		try {
			unJugador.construirHotel("Cordoba Sur");
		} catch (BarrioNoPuedeConstruirHotelException e) {};
		int dineroRestante = DINERO_INICIAL - CORDOBA_SUR.getPrecio() - CORDOBA_NORTE.getPrecio();
		assertEquals(dineroRestante, unJugador.getDinero());
	}
	
	@Test
	public void test12CuandoJugadorCuentaConAmbasCbaConDosCasasYConstruyeUnHotelSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Norte");
		unJugador.construirCasa("Cordoba Norte");
		unJugador.construirHotel("Cordoba Sur");
		int dineroRestante = DINERO_INICIAL - CORDOBA_SUR.getPrecio() - CORDOBA_NORTE.getPrecio()
				- (CORDOBA_SUR.getPrecioCasa() * 2) - (CORDOBA_NORTE.getPrecioCasa() * 2);
		assertEquals(dineroRestante - CORDOBA_SUR.getPrecioHotel(), unJugador.getDinero());
	}
	
	@Test
	public void test13CuandoJugadorCuentaConAmbasCbaConDosCasasYConstruyeUnHotelAlCaerContrincantePierdeDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Cordoba Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Sur");
		unJugador.construirCasa("Cordoba Norte");
		unJugador.construirCasa("Cordoba Norte");
		unJugador.construirHotel("Cordoba Sur");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - CORDOBA_SUR.getAlquilerHotel(), otroJugador.getDinero());
	}
	
	@Test
	public void test14JugadorCuentaConSaltaSuryNorteConstruyeCasaYSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Salta Sur");
		int dineroRestante = DINERO_INICIAL - SALTA_SUR.getPrecio() - SALTA_NORTE.getPrecio();
		assertEquals(dineroRestante - SALTA_SUR.getPrecioCasa(), unJugador.getDinero());
	}
	
	@Test
	public void test15CuandoJugadorCuentaConSaltaSuryNorteConUnaCasaEnCadaUnaYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - SALTA_SUR.getAlquilerUnaCasa(), otroJugador.getDinero());
	}
	
	@Test
	public void test16CuandoJugadorCuentaConAmbasSaltaConDosCasasEnSurYUnaEnNorteYContricanteCaeEnUnaSeDecrementaSuDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Norte");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - SALTA_SUR.getAlquilerDosCasas(), otroJugador.getDinero());
	}
	
	@Test
	public void test17CuandoJugadorCuentaConAmbasSaltaPeroNoTieneCubiertaSuMaximaCapacidadDeCasasYConstruyeHotelSuDineroNoCambia() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		try {
			unJugador.construirHotel("Salta Sur");
		} catch (BarrioNoPuedeConstruirHotelException e) {};
		int dineroRestante = DINERO_INICIAL - SALTA_SUR.getPrecio() - SALTA_NORTE.getPrecio();
		assertEquals(dineroRestante, unJugador.getDinero());
	}
	
	@Test
	public void test18CuandoJugadorCuentaConAmbasSaltaConDosCasasYConstruyeUnHotelSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Norte");
		unJugador.construirCasa("Salta Norte");
		unJugador.construirHotel("Salta Sur");
		int dineroRestante = DINERO_INICIAL - SALTA_SUR.getPrecio() - SALTA_NORTE.getPrecio()
				- (SALTA_SUR.getPrecioCasa() * 2) - (SALTA_NORTE.getPrecioCasa() * 2);
		assertEquals(dineroRestante - SALTA_SUR.getPrecioHotel(), unJugador.getDinero());
	}
	
	@Test
	public void test19CuandoJugadorCuentaConAmbasSaltaConDosCasasYConstruyeUnHotelAlCaerContrincantePierdeDineroCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasilleroSur = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Sur"));
		Casillero unCasilleroNorte = unTablero.getCasillero(unTablero.getIndiceConNombre("Salta Norte"));
		unCasilleroSur.accionarPropiedad(unJugador);
		unCasilleroNorte.accionarPropiedad(unJugador);
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Sur");
		unJugador.construirCasa("Salta Norte");
		unJugador.construirCasa("Salta Norte");
		unJugador.construirHotel("Salta Sur");
		unCasilleroSur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - SALTA_SUR.getAlquilerHotel(), otroJugador.getDinero());
	}
	
	// Punto 9 de la entrega.
	
	@Test
	public void test20CuandoJugadorCuentaConSantaFeYConstruyeUnaCasaSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Santa Fe"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.construirCasa("Santa Fe");
		int dineroRestante = DINERO_INICIAL - SANTA_FE.getPrecio();
		assertEquals(dineroRestante - SANTA_FE.getPrecioCasa(),unJugador.getDinero());
	}
	
	// Punto 10 de la entrega.
	// Pruebas para Buenos Aires (Sur y Norte), Cordoba (Sur y Norte) y Salta (Sur y Norte) ya implementadas
	// en pruebas anteriores. Se prueba ahora para Santa Fe, Neuquen y Tucuman.
	
	@Test
	public void test21JugadorCaeEnSantaFeConConstruccionesYSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Santa Fe"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.construirCasa("Santa Fe");
		unCasillero.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - SANTA_FE.getAlquilerUnaCasa(),otroJugador.getDinero());
	}
	
	@Test
	public void test22JugadorCaeEnNeuquenConConstruccionesYSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Neuquen"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.construirCasa("Neuquen");
		unCasillero.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - NEUQUEN.getAlquilerUnaCasa(),otroJugador.getDinero());
	}
	
	@Test
	public void test23JugadorCaeEnTucumanConConstruccionesYSuDineroSeDecrementaCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Tucuman"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.construirCasa("Tucuman");
		unCasillero.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - TUCUMAN.getAlquilerUnaCasa(),otroJugador.getDinero());
	}
	
	// Punto 11 de la entrega.
	
	@Test
	public void test24JugadorCaeEnTrenAdquiridaPorOtroQueNoTieneSubtesSuDineroSeReduceCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		int unDado = 4; int otroDado = 2;
		otroJugador.setResultadoDados(unDado, otroDado);
		Casillero tren = unTablero.getCasillero(unTablero.getIndiceConNombre("Tren"));
		tren.accionarPropiedad(unJugador);
		tren.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - (unDado + otroDado) * TREN.getTarifaSimple() , otroJugador.getDinero());
	}
	
	// Punto 12 de la entrega.
	
	@Test
	public void test25JugadorCaeEnTrenAdquiridaPorOtroQueTieneSubtesSuDineroSeReduceCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		int unDado = 4; int otroDado = 2;
		otroJugador.setResultadoDados(unDado, otroDado);
		Casillero tren = unTablero.getCasillero(unTablero.getIndiceConNombre("Tren"));
		Casillero subte = unTablero.getCasillero(unTablero.getIndiceConNombre("Subte"));
		tren.accionarPropiedad(unJugador);
		subte.accionarPropiedad(unJugador);
		tren.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - (unDado + otroDado) * TREN.getTarifaDoble() , otroJugador.getDinero());

	}
	
	// Puntos 13 y 14 en la entrega, segun lo sugerido por Fede.
	
	@Test
	public void test26JugadorVendeUnaPropiedadYCuandoOtroJugadorCaeEnEsaPropiedadPuedeComprarla() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Buenos Aires Sur"));
		unCasillero.accionarPropiedad(unJugador);
		unJugador.venderPropiedad("Buenos Aires Sur");
		unCasillero.accionarPropiedad(otroJugador);
		assertTrue(otroJugador.estaEntreLasPropiedades("Buenos Aires Sur"));
	}
	
	// Punto 15 en la entrega.
	
	@Test
	public void test27JugadorCaeEnImpuestoAlLujoYSuDineroSeReduceEn10Porciento() {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Casillero unCasillero = unTablero.getCasillero(unTablero.getIndiceConNombre("Impuesto Al Lujo"));
		unCasillero.accionarPropiedad(unJugador);
		assertEquals(DINERO_INICIAL - ((int) (DINERO_INICIAL * 0.1)), unJugador.getDinero());
	}

	// Punto 16 en la entrega.
	
	@Test
	public void test28JugadorCaeEnEdesurAdquiridaPorOtroQueNoTieneAysaSuDineroSeReduce500VecesSusDados() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		int unDado = 4; int otroDado = 2;
		otroJugador.setResultadoDados(unDado, otroDado);
		Tablero unTablero = new Tablero();
		Casillero edesur = unTablero.getCasillero(unTablero.getIndiceConNombre("Edesur"));
		edesur.accionarPropiedad(unJugador);
		edesur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - (unDado + otroDado) * EDESUR.getTarifaSimple() , otroJugador.getDinero());
	}
	
	// Punto 17 en la entrega.
	
	@Test
	public void test29JugadorCaeEnEdesurAdquiridaPorOtroQueTieneAysaSuDineroSeReduceCorrectamente() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		int unDado = 4; int otroDado = 2;
		otroJugador.setResultadoDados(unDado, otroDado);
		Tablero unTablero = new Tablero();
		Casillero edesur = unTablero.getCasillero(unTablero.getIndiceConNombre("Edesur"));
		Casillero aysa = unTablero.getCasillero(unTablero.getIndiceConNombre("Aysa"));
		edesur.accionarPropiedad(unJugador);
		aysa.accionarPropiedad(unJugador);
		edesur.accionarPropiedad(otroJugador);
		assertEquals(DINERO_INICIAL - (unDado + otroDado) * EDESUR.getTarifaDoble() , otroJugador.getDinero());
	}
	
}