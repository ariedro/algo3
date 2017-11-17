package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.clases.*;


public class DatosDeBarrioTest {

	
	@Test
	public void test01getDatosBuenosAiresSurChequearNombre() {
		
		DatosDeBarrio datosBuenosAiresSur = DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR);
		
		assertEquals("Buenos Aires Sur", datosBuenosAiresSur.getNombre());
		
	}
	

	@Test
	public void test02getDatosBuenosAiresNorteChequearNombre() {
		
		DatosDeBarrio datosBuenosAiresNorte = DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE);
		
		assertEquals("Buenos Aires Norte", datosBuenosAiresNorte.getNombre());
		
	}

	@Test
	public void test03getDatosCordobaSurChequearPrecioTerreno() {
		
		DatosDeBarrio datosCordobaSur = DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_SUR);
		
		assertEquals(18000, datosCordobaSur.getPrecio());
		
		
		
	}
	
	@Test
	public void test04getDatosCordobaNorteChequearPrecioCasa() {
		
		DatosDeBarrio datosCordobaNorte = DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_NORTE);
		
		assertEquals(2200, datosCordobaNorte.getPrecioCasa());
		
	}
	
	@Test
	public void test05getDatosSantaFeChequearMaximoCasas() {
		
		DatosDeBarrio datosSantaFe = DatosDeBarrio.getDatosBarrio(Barrios.SANTA_FE);
		
		assertEquals(1 , datosSantaFe.getMaximoCasas());
		
	}

	@Test
	public void test06getDatosSaltaNorteChequearPrecioHotel() {
		
		DatosDeBarrio datosSaltaNorte = DatosDeBarrio.getDatosBarrio(Barrios.SALTA_NORTE);
		
		assertEquals(7500, datosSaltaNorte.getPrecioHotel());
		
	}
	
	@Test
	public void test07getDatosSaltaSurChequearVecino() {
		
		DatosDeBarrio datosSaltaSur = DatosDeBarrio.getDatosBarrio(Barrios.SALTA_SUR);
		
		assertEquals("Salta Norte", datosSaltaSur.getVecino());
		
	}
	
	@Test
	public void test08getDatosTucumanChequearAlquilerSimple() {
		
		DatosDeBarrio datosTucuman = DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN);
		
		assertEquals(2500 , datosTucuman.getAlquilerSimple());
		
	}
	
}
