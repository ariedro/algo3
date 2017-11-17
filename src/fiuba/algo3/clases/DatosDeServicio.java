package fiuba.algo3.clases;

public class DatosDeServicio {

	private static String[] NOMBRES = {"EDESUR", "AYSA", "SUBTE", "TREN"};
	
	private static String[] SERVICIO_ASOCIADO = {"AYSA", "EDESUR" , "TREN" , "SUBTE"};

	private static int[] PRECIO = {35000, 40000, 30000, 38000};
	
	private static int[] TARIFA_SIMPLE = {500, 600, 300, 450};
	
	private static int[] TARIFA_DOBLE = {1000, 1100, 500, 800};
	
	
	private String nombre;
	private String servicioAsociado;
	private int precio;
	private int tarifaSimple;
	private int tarifaDoble;
	
	public static DatosDeServicio getDatosServicio(Servicios unServicio) {
		
		int numServicio = unServicio.getNumServicio();
			
		DatosDeServicio datosDeUnServicio = new DatosDeServicio();
		
		datosDeUnServicio.llenarDatos(numServicio);
			
		return datosDeUnServicio;
		
	}
	
	
	public void llenarDatos(int numServicio) {
		
		this.nombre = NOMBRES[numServicio];
	
		this.servicioAsociado = SERVICIO_ASOCIADO[numServicio];
	
		this.precio = PRECIO[numServicio];
		
		this.tarifaSimple = TARIFA_SIMPLE[numServicio];
		
		this.tarifaDoble = TARIFA_DOBLE[numServicio];
				
	}
	
}
