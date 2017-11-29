package fiuba.algo3.vista;

import fiuba.algo3.clases.Dados;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaDados implements Vista {
	
	Dados dados;
	Canvas canvas;
	Image[] imagenesDados;
	
	public VistaDados(Canvas unCanvas, Dados unosDados) {
		this.canvas = unCanvas;
		this.dados = unosDados;
		this.imagenesDados = new Image[6];
		for(int i = 0; i < 6; i++)
			this.imagenesDados[i] = new Image("file:res/imagenes/dados/" + Integer.toString(i + 1) +".png");
	}
	
    public void dibujar() {
        this.dibujarDados();
    }
    
    private void dibujarDados() {
        canvas.getGraphicsContext2D().drawImage(this.imagenesDados[dados.getValorPrimerDado() - 1], canvas.getWidth() / 2 - 64, canvas.getHeight() / 2 + 45);
        canvas.getGraphicsContext2D().drawImage(this.imagenesDados[dados.getValorSegundoDado() - 1], canvas.getWidth() / 2, canvas.getHeight() / 2 + 45);
    }

    public void update() {
        this.dibujar();
    }
	

}
