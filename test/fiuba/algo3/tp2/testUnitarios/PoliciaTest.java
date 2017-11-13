package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.Policia;

public class PoliciaTest {

	@Test
	public void test01PoliciaCreadaNoEsNula() {
		Policia unPolicia = new Policia();
		assertNotNull(unPolicia);
	}

}
