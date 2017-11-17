package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.Tablero;

public class TableroTest {

	@Test
	public void test01CrearTableroNoEsNull() {
		Tablero unTablero = new Tablero();
		assertNotNull(unTablero);
	}

}
