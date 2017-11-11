package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DadosTest {

	private static final int MINIMO = 1;
	private static final int MAXIMO = 12;
	
	@Test
	public void test01CrearDadosNoEsNulo() {
		Dados unosDados = new Dados();
		assertNotNull(unosDados);
	}
	
	@Test
	public void test02TirarLosDadosEstaDentroDeLoRangosPermitidos() {
		Dados unosDados = new Dados();
		boolean verificado = false;
		int numero = unosDados.tirar();
		if (numero >= MINIMO && numero <= MAXIMO) verificado = true;
		assertTrue(verificado);
	}

}
