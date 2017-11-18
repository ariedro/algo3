package fiuba.algo3.clases;

public class Inicializador {
	public void inicializarTablero(Tablero unTablero) {
		
		unTablero.agregarCasillero(inicializarCasillero(new Salida()));
		unTablero.agregarCasillero(inicializarCasillero(new Quini()));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.EDESUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.BUENOS_AIRES_NORTE))));
		
		
		Casillero casilleroCarcel = new Casillero (new Carcel());
		unTablero.agregarCasillero(casilleroCarcel);
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new AvanceDinamico()));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.SUBTE))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.CORDOBA_NORTE))));

		unTablero.agregarCasillero(inicializarCasillero(new ImpuestoAlLujo()));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SANTA_FE))));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.AYSA))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SALTA_NORTE))));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.SALTA_SUR))));
		unTablero.agregarCasillero(inicializarCasillero(new Policia(casilleroCarcel)));
		unTablero.agregarCasillero(inicializarCasillero(new Servicio(DatosDeServicio.getDatosServicio(Servicios.TREN))));
		
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.NEUQUEN))));
		unTablero.agregarCasillero(inicializarCasillero(new RetrocesoDinamico()));
		unTablero.agregarCasillero(inicializarCasillero(new Barrio(DatosDeBarrio.getDatosBarrio(Barrios.TUCUMAN))));
		
		
		
	}
	
	public Casillero inicializarCasillero(Encasillable unEncasillable) {
		return new Casillero(unEncasillable);
	}
}
