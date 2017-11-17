package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;

public class BarrioTest {

	private static final int DINERO_INICIAL = 100000;
	
	//Los datos corresponden al barrio BUENOS_AIRES_SUR
	private static String NOMBRE = "Buenos Aires Sur";
	private static String VECINO = "Buenos Aires Norte";
	private static int PRECIO = 20000;
	private static int PRECIO_CASA = 5000;
	private static int PRECIO_HOTEL = 8000;
	private static int MAXIMO_CASAS = 2;
	private static int ALQUILER_SIMPLE = 2000;
	private static int ALQUILER_UNA_CASA = 3000;
	private static int ALQUILER_DOS_CASAS = 3500;
	private static int ALQUILER_HOTEL = 5000;
	
	
	
	@Test
	public void test01CrearBarrioNoEsNulo() {
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		assertNotNull(unBarrio);
	}
	
	@Test
	public void test02BarrioCreadoNoTieneDuenio() {
		
		Barrio unBarrio = new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR));
		
		assertNull(unBarrio.getPropietario());
		
	}
	

	
}

