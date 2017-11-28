package fiuba.algo3.clases;

import fiuba.algo3.excepciones.ServicioNoPuedeConstruirException;

public interface Comprable {

	Jugador getPropietario();
	
	String getNombre();
	
	int getPrecio();

	int getValorVenta();
	
	public void setPropietario(Jugador unJugador);
	
	public void darDeBajaPropietario();
	
	public boolean tienePropietario();
	
	public boolean esPropietario(Jugador unJugador);

	public boolean puedeConstruir();
	
	public int getPrecioCasa();
	
	public int getPrecioHotel();
	
	public void construirCasa() throws ServicioNoPuedeConstruirException;
	
	public void construirHotel() throws ServicioNoPuedeConstruirException;
	
	
}
