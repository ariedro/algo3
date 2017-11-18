package fiuba.algo3.clases;

public class IndiceDeTablero {
	private static String[] NOMBRES = { "Salida", "Quini 6", "Buenos Aires Sur", "Edesur", 
			"Buenos Aires Norte", "Carcel", "Cordoba Sur", "Avance Dinamico", "Subte", "Cordoba Norte",
			"Impuesto Al Lujo", "Santa Fe", "Aysa", "Salta Norte" , "Salta Sur",
			"Policia", "Tren", "Neuquen", "Retroceso Dinamico", "Tucuman"};
	
	//Busca el indice asociado al nombre de un Encasillable dentro del Tablero
	//Si no se encuentra devuelve -1.
	public int getIndice(String unNombre) {
		for (int i = 0; i<NOMBRES.length; i++) {
			if (NOMBRES[i].equals(unNombre)) return i;
		}
		return -1;
	}
	
}
