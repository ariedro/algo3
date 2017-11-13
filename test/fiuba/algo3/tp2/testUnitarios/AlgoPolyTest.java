package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import fiuba.algo3.clases.AlgoPoly;


public class AlgoPolyTest {


	private static final int CANTIDAD_JUGADORES = 3;

	@Test
	public void test01CrearAlgoPolyNoEsNull() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertNotNull(unAlgoPoly);
		
	}

	@Test
	public void test02AlgoPolyCreadoTieneTresJugadores() {
		
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		assertEquals(CANTIDAD_JUGADORES, unAlgoPoly.getCantidadJugadores());
		
	}


}
