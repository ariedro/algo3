package fiuba.algo3.clases;

public enum Servicios {
	
	EDESUR(0),
	SUBTE(1),
	AYSA(2),
	TREN(3);
	
	private final int numServicio;
	
	Servicios(int numServicio) {
		
		this.numServicio = numServicio;
		
	}
	
	
	public int getNumServicio() {
		
		return this.numServicio;
		
	}
	

}
