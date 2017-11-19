package fiuba.algo3.clases;

public interface Comprable {

	Jugador getPropietario();
	
	String getNombre();
	
	int getPrecio();

	int getValorVenta();
	
	public boolean tienePropietario();
	
	public boolean esPropietario(Jugador unJugador);

}
