package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.*;

public class ServicioTest {

	@Test
	public void test01CrearServicioNoEsNulo() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.AYSA));
		assertNotNull(unServicio);
	}
	
	@Test
	public void test02ServicioCreadoNoTieneDuenio() {
		Servicio unServicio = new Servicio(DatosDeServicio.getDatosServicio(Servicios.AYSA));
		assertNull(unServicio.getPropietario());
	}

}
