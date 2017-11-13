package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;

public class DadoTest {

	private static final int MINIMO = 1;
	private static final int MAXIMO = 6;
	
	@Test
	public void test01CrearDadoNoEsNulo() {
		Dado unDado = new Dado();
		assertNotNull(unDado);
	}
	
	@Test
	public void test02TirarElDadoEstaDentroDelRangoPermitido() {
		Dado unDado = new Dado();
		boolean verificado = false;
		int numero = unDado.tirar();
		if (numero >= MINIMO && numero <= MAXIMO) verificado = true;
		assertTrue(verificado);
	}
	
}
