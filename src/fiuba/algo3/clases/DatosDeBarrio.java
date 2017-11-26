package fiuba.algo3.clases;

import fiuba.algo3.clases.DatosDeBarrio;


public class DatosDeBarrio {

	private static String[] NOMBRES = { "Buenos Aires Sur", "Buenos Aires Norte", "Cordoba Sur" , "Cordoba Norte",
										"Santa Fe", "Salta Norte" , "Salta Sur" , "Neuquen" , "Tucuman" };
	
	private static String[] VECINOS = {"Buenos Aires Norte","Buenos Aires Sur", "Cordoba Norte", "Cordoba Sur",
										 	null, "Salta Sur" , "Salta Norte", null, null };
	
	private static int [] PRECIO = { 20000, 25000, 18000, 20000, 15000, 23000, 23000, 17000, 25000}; 
	
	private static int[] PRECIO_CASA = { 5000, 5500, 2000, 2200, 4000, 4500, 4500, 4800, 7000};
	
	private static int[] PRECIO_HOTEL = { 8000, 9000, 3000, 3500, 0, 7500, 7500, 0, 0};
	
	private static int[] MAX_CASAS = { 2, 2, 2, 2, 1, 2, 2, 1, 1};

	private static int [] ALQUILER_SIMPLE = { 2000, 2500, 1000, 1300, 1500, 2000, 2000, 1800, 2500};

	private static int[] ALQUILER_UNA_CASA = { 3000, 3500, 1500, 1800, 3500, 3250, 3250, 3800, 4500};
	
	private static int[] ALQUILER_DOS_CASAS = { 3500, 4000, 2500, 2900, 0, 3850, 3850, 0, 0};

	private static int[] ALQUILER_HOTEL = { 5000, 6000, 3000, 3500, 0, 5500, 5500, 0, 0};

	
	private String nombre;
	private String vecino;
	private int precio;
	private int precioCasa;
	private int precioHotel;
	private int maximoCasas;
	private int alquilerSimple;
	private int alquilerUnaCasa;
	private int alquilerDosCasas;
	private int alquilerHotel;
	
	
	public static DatosDeBarrio getDatosBarrio(Barrios unBarrio) {
		
		int numBarrio = unBarrio.getNumBarrio();
		
		DatosDeBarrio datosDeUnBarrio = new DatosDeBarrio();
			
		datosDeUnBarrio.llenarDatos(numBarrio);
			
		return datosDeUnBarrio;
		
	}


	private void llenarDatos(int numBarrio) {
		
		this.nombre = NOMBRES[numBarrio];
		
		this.vecino = (VECINOS[numBarrio]);
		
		this.precio = PRECIO[numBarrio];
	
		this.precioCasa = PRECIO_CASA[numBarrio];
		
		this.precioHotel = PRECIO_HOTEL[numBarrio];
		
		this.maximoCasas = MAX_CASAS[numBarrio];
		
		this.alquilerSimple = ALQUILER_SIMPLE[numBarrio];
		
		this.alquilerUnaCasa = ALQUILER_UNA_CASA[numBarrio];
		
		this.alquilerDosCasas = ALQUILER_DOS_CASAS[numBarrio];
		
		this.alquilerHotel = ALQUILER_HOTEL[numBarrio];
	
	
	
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public int getPrecio() {
		
		return this.precio;
	}
	
	public int getPrecioCasa() {
		
		return this.precioCasa;
	}


	public int getPrecioHotel() {
		return precioHotel;
	}


	public int getMaximoCasas() {
		return maximoCasas;
	}


	public int getAlquilerSimple() {
		return alquilerSimple;
	}



	public int getAlquilerUnaCasa() {
		return alquilerUnaCasa;
	}


	public int getAlquilerDosCasas() {
		return alquilerDosCasas;
	}



	public int getAlquilerHotel() {
		return alquilerHotel;
	}

	public boolean puedeTenerHotel() {
		return (alquilerHotel != 0);
	}

	public String getVecino() {
		return vecino;
	}


	
}
