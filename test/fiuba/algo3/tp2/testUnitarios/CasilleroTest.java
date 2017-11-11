package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasilleroTest {

	@Test
	public void test01CasilleroCreadoNoEsNulo() {
		Casillero casillero = new Casillero(null);
		assertNotNull(casillero);
	}
	
}
