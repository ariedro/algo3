package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.*;

public class CasilleroTest {

	@Test
	public void test01CasilleroCreadoNoEsNulo() {
		Casillero casillero = new Casillero(null);
		assertNotNull(casillero);
	}
	
}
