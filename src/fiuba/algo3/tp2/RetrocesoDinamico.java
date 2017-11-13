package fiuba.algo3.tp2;

public class RetrocesoDinamico implements Encasillable{

	@Override
	public void accionarCon(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

	public int getRetroceso(Jugador unJugador, int suma) {
		
		if (suma <7 ) {
			
			return (suma - unJugador.getCantidadPropiedades());
		
		} else if (suma<11) {
			
			return (unJugador.getDinero() % suma);
		}
	
		return (suma - 2 );
		
	
	}

}
