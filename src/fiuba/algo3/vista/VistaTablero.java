package fiuba.algo3.vista;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Ficha;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaTablero {
    Canvas canvas;
    AlgoPoly algoPoly;
    Image imagenTablero;

    public VistaTablero(Canvas canvas, AlgoPoly algoPoly) {
        this.canvas = canvas;
        this.algoPoly = algoPoly;
        this.imagenTablero = new Image("file:src/fiuba/algo3/vista/imagenes/tableroJuego.png");
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.CRIMSON);
        Ficha primerFicha = this.algoPoly.getFicha(0);
        canvas.getGraphicsContext2D().fillOval(primerFicha.getPosicion().getX() + 10, primerFicha.getPosicion().getY() + 10, primerFicha.RADIO, primerFicha.RADIO);
        
        canvas.getGraphicsContext2D().setFill(Color.CYAN);
        Ficha segundaFicha = this.algoPoly.getFicha(1);
        canvas.getGraphicsContext2D().fillOval(segundaFicha.getPosicion().getX() + 20, segundaFicha.getPosicion().getY() + 10, segundaFicha.RADIO, segundaFicha.RADIO);
    
        canvas.getGraphicsContext2D().setFill(Color.FUCHSIA);
        Ficha tercerFicha = this.algoPoly.getFicha(2);
        canvas.getGraphicsContext2D().fillOval(tercerFicha.getPosicion().getX() + 30, tercerFicha.getPosicion().getY() + 10, tercerFicha.RADIO, tercerFicha.RADIO);
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
