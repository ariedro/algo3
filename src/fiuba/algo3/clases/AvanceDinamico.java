package fiuba.algo3.clases;

public class AvanceDinamico implements Encasillable{

	@Override
	public void accionarCon(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

	public int getAvance(Jugador unJugador, int suma) {
		
		if (suma < 7) {
	
			return (suma - 2);
		
		}
		else if (suma <11) {
			
			return (unJugador.getDinero() % suma);
		}
	
		return (suma - unJugador.getCantidadPropiedades());
	
	}

}
