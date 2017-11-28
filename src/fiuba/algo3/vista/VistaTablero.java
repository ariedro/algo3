package fiuba.algo3.vista;

import java.util.HashMap;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Casillero;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaTablero {
    Canvas canvas;
    AlgoPoly algoPoly;
    Image imagenTablero;
	HashMap<Casillero,Vector> posicionesCasilleros;

	

    public VistaTablero(Canvas canvas, AlgoPoly algoPoly) {
        this.canvas = canvas;
        this.algoPoly = algoPoly;
        this.imagenTablero = new Image("file:res/imagenes/tableroJuego.png");
        this.posicionesCasilleros = new HashMap<>();
        for(int i = 0; i < 5; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i), new Vector(770 - (i * 140), 330));
        }
        for(int i = 0; i < 6; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 5), new Vector(70, 330 - (i * 60)));
        }
        for(int i = 0; i < 5; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 11), new Vector(210 + (i * 140), 30));
        }
        for(int i = 0; i < 4; i++) {
        	posicionesCasilleros.put(algoPoly.getTablero().getCasillero(i + 16), new Vector(770, 90 + (i * 60)));
        }
        
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        canvas.getGraphicsContext2D().fillOval(	posicionesCasilleros.get(algoPoly.getJugadores().get(0).getUbicacion()).getX() - 30,
        										posicionesCasilleros.get(algoPoly.getJugadores().get(0).getUbicacion()).getY(),
        										30,30);
        canvas.getGraphicsContext2D().setFill(Color.DARKRED);
        canvas.getGraphicsContext2D().fillOval(	posicionesCasilleros.get(algoPoly.getJugadores().get(1).getUbicacion()).getX(),
        										posicionesCasilleros.get(algoPoly.getJugadores().get(1).getUbicacion()).getY(),
        										30,30);
        canvas.getGraphicsContext2D().setFill(Color.DARKVIOLET);
        canvas.getGraphicsContext2D().fillOval(	posicionesCasilleros.get(algoPoly.getJugadores().get(2).getUbicacion()).getX() + 30,
        										posicionesCasilleros.get(algoPoly.getJugadores().get(2).getUbicacion()).getY(),
        										30,30);
        
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 840, 360);
        canvas.getGraphicsContext2D().drawImage(this.imagenTablero, 0, 0);
    }

    public void update() {
        this.dibujar();
    }

}
