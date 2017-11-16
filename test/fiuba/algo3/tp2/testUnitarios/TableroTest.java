package fiuba.algo3.clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void test01CrearTableroNoEsNull() {
		Tablero unTablero = new Tablero();
		assertNotNull(unTablero);
	}

}
