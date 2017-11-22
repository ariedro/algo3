package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.encasillables.Servicio;

public class ServicioTest {

	private static final int DINERO_INICIAL = 100000;
	
	//Los datos corresponden al servicio TREN
	private static int TARIFA_SIMPLE = 450;
	private static int TARIFA_DOBLE = 800;
	
	@Test
	public void test01CrearServicioNoEsNulo() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN));
		assertNotNull(unServicio);
	}
	
	@Test
	public void test02ServicioCreadoNoTieneDuenio() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN));
		assertNull(unServicio.getPropietario());
	}
	
	@Test
	public void test03SiJugadorCaeEnServicioConDuenioPeroSinServicioAsociadoPierdeDineroSegunDadosConTarifaSimple() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN));
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroDado1 = 0;
		int numeroDado2 = 0;
		unServicio.accionarCon(unJugador);
		numeroDado1 = otroJugador.tirarDado(unDado);
		numeroDado2 = otroJugador.tirarDado(unDado);
		otroJugador.setResultadoDados(numeroDado1,numeroDado2);
		unServicio.accionarCon(otroJugador);
		assertEquals(DINERO_INICIAL - (otroJugador.getResultadoDados() * TARIFA_SIMPLE), otroJugador.getDinero());	
	}

	@Test
	public void test04SiJugadorCaeEnServicioConDuenioyConServicioAsociadoPierdeDineroSegunDadosConTarifaDoble() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN));
		Servicio otroServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.SUBTE));
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Dado unDado = new Dado();
		int numeroDado1 = 0;
		int numeroDado2 = 0;
		unServicio.accionarCon(unJugador);
		otroServicio.accionarCon(unJugador);
		numeroDado1 = otroJugador.tirarDado(unDado);
		numeroDado2 = otroJugador.tirarDado(unDado);
		otroJugador.setResultadoDados(numeroDado1,numeroDado2);
		unServicio.accionarCon(otroJugador);
		assertEquals(DINERO_INICIAL - (otroJugador.getResultadoDados() * TARIFA_DOBLE), otroJugador.getDinero());	
	}
	
	@Test
	public void test05CuandoJugadorPropietarioVendeSuBarrioYaNoEsMasPropietario() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		Jugador unJugador = new Jugador();
		unBarrio.accionarCon(unJugador);
		unJugador.darDeBajaPropiedad(unBarrio);
		assertTrue(unBarrio.esPropietario(unJugador));
	}
	
	@Test
	public void test06ValorDeVentaEsIgualAValorDeTodoLoQueEstaEnElServicioMenosEl15Porciento() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN));
		Jugador unJugador = new Jugador();
		unServicio.accionarCon(unJugador);
		assertEquals(((int) ((unServicio.getPrecio()) * 0.85)), unServicio.getValorVenta());
	}
	
	
}
