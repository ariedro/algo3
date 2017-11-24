package fiuba.algo3.clases;

import fiuba.algo3.encasillables.AvanceDinamico;
import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.encasillables.Carcel;
import fiuba.algo3.encasillables.ImpuestoAlLujo;
import fiuba.algo3.encasillables.Policia;
import fiuba.algo3.encasillables.Quini;
import fiuba.algo3.encasillables.RetrocesoDinamico;
import fiuba.algo3.encasillables.Salida;
import fiuba.algo3.encasillables.Servicio;

public class Inicializador {
	public void inicializarTablero(Tablero unTablero) {
		
		unTablero.agregarCasillero(inicializarCasillero(new Salida()));
		unTablero.agregarCasillero(inicializarCasillero(new Quini()));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.EDESUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE))));
		
		
		unTablero.agregarCasillero(inicializarCasillero(new Carcel()));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new AvanceDinamico(unTablero)));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.SUBTE))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_NORTE))));

		unTablero.agregarCasillero(inicializarCasillero(new ImpuestoAlLujo()));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SANTA_FE))));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.AYSA))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SALTA_NORTE))));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SALTA_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Policia(unTablero)));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.NEUQUEN))));
		unTablero.agregarCasillero(inicializarCasillero(new RetrocesoDinamico(unTablero)));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN))));
		
		
		
	}
	
	public Casillero inicializarCasillero(Encasillable unEncasillable) {
		return new Casillero(unEncasillable);
	}
}
