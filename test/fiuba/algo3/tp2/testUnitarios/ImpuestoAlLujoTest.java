package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;
import fiuba.algo3.excepciones.*;

public class ImpuestoAlLujoTest {

	private static final int DINERO_INICIAL = 100000;
	private static final int DINERO_PRIMER_TEST = 90000;
	
	@Test
	public void test01CrearImpuestoAlLujoNoEsNulo() {
		ImpuestoAlLujo unImpuesto = new ImpuestoAlLujo();
		assertNotNull(unImpuesto);
	}
	
	@Test
	public void test02CuandoJugadorCaeEnImpuestoAlLujoPierdeEl10PorcientoDeSuDineroInicial() {
		ImpuestoAlLujo unImpuesto = new ImpuestoAlLujo();
		Jugador unJugador = new Jugador();
		unImpuesto.accionarCon(unJugador);
		assertEquals(DINERO_PRIMER_TEST,unJugador.getDinero());
	}
	
	

}
