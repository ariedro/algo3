package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.IndiceDeTablero;

public class IndiceDeTableroTest {

	@Test
	public void testGetIndiceDevuelvePrimerIndiceCorrecto() {
		IndiceDeTablero indice = new IndiceDeTablero();
		assertEquals(0,indice.getIndice("Salida"));
	}
	
	@Test
	public void testGetIndiceDevuelveUltimoIndiceCorrecto() {
		IndiceDeTablero indice = new IndiceDeTablero();
		assertEquals(19,indice.getIndice("Tucuman"));
	}
	
	@Test
	public void testGetNombreDevuelvePrimerNombreCorrecto() {
		IndiceDeTablero indice = new IndiceDeTablero();
		assertEquals("Salida",indice.getNombre(0));
	}
	
	@Test
	public void testGetNombreDevuelveUltimoNombreCorrecto() {
		IndiceDeTablero indice = new IndiceDeTablero();
		assertEquals("Tucuman",indice.getNombre(19));
	}

}
