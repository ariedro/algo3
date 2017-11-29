package fiuba.algo3.vista;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Casillero;
import fiuba.algo3.clases.Jugador;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaTablero implements Vista{
    Canvas canvas;
    AlgoPoly algoPoly;
    Image imagenTablero;
	HashMap<Casillero,Vector> posicionesCasilleros;
	LinkedList<Jugador> jugadores;
	HashMap<Jugador,Color> coloresJugadores;

	

    public VistaTablero(Canvas canvas, AlgoPoly algoPoly) {
        this.canvas = canvas;
        this.algoPoly = algoPoly;
        this.imagenTablero = new Image("file:res/imagenes/tableroJuego.png");
        this.posicionesCasilleros = new HashMap<>();
        for(int i = 0; i < 5; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i), new Vector(740 - (i * 140), 330));
        }
        for(int i = 0; i < 6; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 5), new Vector(40, 330 - (i * 60)));
        }
        for(int i = 0; i < 5; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 11), new Vector(180 + (i * 140), 30));
        }
        for(int i = 0; i < 4; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 16), new Vector(740, 90 + (i * 60)));
        }
        this.jugadores = algoPoly.getJugadores();
        this.coloresJugadores = new HashMap<>();
        coloresJugadores.put(jugadores.get(0), Color.RED);
        coloresJugadores.put(jugadores.get(1), Color.GREEN);
        coloresJugadores.put(jugadores.get(2), Color.BLUE);
        
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        
        int i = 0;
        for(Jugador unJugador: jugadores) {
        	if (!unJugador.esPerdedor()){
                int x = posicionesCasilleros.get(unJugador.getUbicacion()).getX();
                int y = posicionesCasilleros.get(unJugador.getUbicacion()).getY();
        		canvas.getGraphicsContext2D().setStroke(Color.BLACK);
                canvas.getGraphicsContext2D().setFill(coloresJugadores.get(unJugador));
                canvas.getGraphicsContext2D().fillOval(	x + (i++ * 30), y, 30, 30);    		
        	}
        }
    }

    public void clean() {
        canvas.getGraphicsContext2D().drawImage(this.imagenTablero, 0, 0);
    }

    public void update() {
        this.dibujar();
    }

}
