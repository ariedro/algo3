package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoliciaTest {

	@Test
	public void test01PoliciaCreadaNoEsNula() {
		Policia unPolicia = new Policia();
		assertNotNull(unPolicia);
	}

}
