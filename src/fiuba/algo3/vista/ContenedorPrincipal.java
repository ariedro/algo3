package fiuba.algo3.vista;

import fiuba.algo3.encasillables.Barrio;
import fiuba.algo3.clases.DatosDeBarrio;

import java.io.File;
import java.net.URL;

import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.clases.Comprable;
import fiuba.algo3.clases.Jugador;
import fiuba.algo3.vista.eventos.BotonComprarPropiedadHandler;
import fiuba.algo3.vista.eventos.BotonConstruirCasaHandler;
import fiuba.algo3.vista.eventos.BotonConstruirCasasHandler;
import fiuba.algo3.vista.eventos.BotonConstruirHotelHandler;
import fiuba.algo3.vista.eventos.BotonConstruirHotelesHandler;
import fiuba.algo3.vista.eventos.BotonFinalizarTurnoHandler;
import fiuba.algo3.vista.eventos.BotonPagarFianzaHandler;
import fiuba.algo3.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.vista.eventos.BotonVenderPropiedadHandler;
import fiuba.algo3.vista.eventos.BotonVenderPropiedadesHandler;
import fiuba.algo3.vista.eventos.BotonVentaHandler;
import fiuba.algo3.vista.eventos.BotonVolverHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    VBox contenedorCentral;
    VistaTablero vistaTablero;
    VBox contenedorDados;
    VistaDados vistaDados;
    VistaInfoJugadores vistaInfoJugadores;

    public ContenedorPrincipal(Stage stage, AlgoPoly algoPoly) {
        
     	this.setMenu(stage);
        this.setCentro(algoPoly);
        this.setDados(algoPoly);
        this.setInfoJugadores(algoPoly);
        //this.setConsola();
        this.setBotonera(algoPoly);
    }

	private void setBotonera(AlgoPoly algoPoly) {
    	
    	VBox contenedorVertical = new VBox(10);
    	
        Button botonVender = new Button();
        botonVender.setText("Vender Propiedades");
        BotonVenderPropiedadesHandler venderPropiedadesHandler = new BotonVenderPropiedadesHandler(algoPoly, this, contenedorVertical);
        botonVender.setOnAction(venderPropiedadesHandler);
        contenedorVertical.getChildren().add(botonVender);
        
        Button botonConstruirCasas = new Button();
        botonConstruirCasas.setText("Construir Casas");
        BotonConstruirCasasHandler construirCasasHandler = new BotonConstruirCasasHandler(algoPoly, this, contenedorVertical);
        botonConstruirCasas.setOnAction(construirCasasHandler);
        contenedorVertical.getChildren().add(botonConstruirCasas);
        
        Button botonConstruirHoteles = new Button();
        botonConstruirHoteles.setText("Construir Hoteles");
        BotonConstruirHotelesHandler construirHotelesHandler = new BotonConstruirHotelesHandler(algoPoly, this, contenedorVertical);
        botonConstruirHoteles.setOnAction(construirHotelesHandler);
        contenedorVertical.getChildren().add(botonConstruirHoteles);
        
        Button botonPagarFianza = new Button();
        botonPagarFianza.setText("Pagar Fianza");
        BotonPagarFianzaHandler pagarFianzaHandler = new BotonPagarFianzaHandler(algoPoly, vistaInfoJugadores);
        botonPagarFianza.setOnAction(pagarFianzaHandler);
        contenedorVertical.getChildren().add(botonPagarFianza);
        
        Button botonFinalizarTurno = new Button();
        botonFinalizarTurno.setText("Finalizar Turno");
        
        Button botonDados = new Button();
        botonDados.setText("Tirar Dados");
        
        botonFinalizarTurno.setDisable(true);
        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(vistaTablero, vistaInfoJugadores, algoPoly, botonFinalizarTurno,botonDados, botonVender, botonConstruirCasas, botonConstruirHoteles);
        botonFinalizarTurno.setOnAction(finalizarTurnoHandler);
        if (algoPoly.getJugadorActual().estaEnCana()) botonFinalizarTurno.setDisable(false);
        contenedorVertical.getChildren().add(botonFinalizarTurno);
        
        BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(vistaTablero, vistaDados, vistaInfoJugadores, algoPoly, botonFinalizarTurno, botonVender, botonConstruirCasas, botonConstruirHoteles);
        botonDados.setOnAction(tirarDadosHandler);
        contenedorVertical.getChildren().add(botonDados);
        
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
        
    }

    private void setMenu(Stage stage) {
        
    	this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(AlgoPoly algoPoly) {
    		
    	
    	canvasCentral = new Canvas(840, 360);
    	vistaTablero = new VistaTablero(canvasCentral, algoPoly);
    	vistaTablero.dibujar();
        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));    	
        
        Image imagen = new Image("file:res/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        
        String musicFile = "res/sonidos/monopoly.mp3";     
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
        		public void run() {
        			mediaPlayer.seek(Duration.ZERO);
        		}
        });
		mediaPlayer.play();

        this.setCenter(contenedorCentral);
    		
    }
    
    private void setDados(AlgoPoly algoPoly) {
    	vistaDados = new VistaDados(canvasCentral, algoPoly.getDados());
    }
    
    private void setInfoJugadores(AlgoPoly algoPoly) {
    	vistaInfoJugadores = new VistaInfoJugadores(algoPoly);
        VBox contenedorInfoJugadores = new VBox(vistaInfoJugadores.getLabel());
        contenedorInfoJugadores.setSpacing(10);
        contenedorInfoJugadores.setPadding(new Insets(0));
        contenedorInfoJugadores.setStyle("-fx-background-color: lightgray;");
        
        this.setBottom(contenedorInfoJugadores);
    }

    private void setConsola() {

        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

	public void setBotoneraVenta(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, VBox botoneraAnterior) {

		Jugador jugador = algoPoly.getJugadorActual();
		VBox contenedorVertical = new VBox(10);
		for (Comprable propiedad: jugador.getPropiedades()) {
			Button botonVender = new Button();
			botonVender.setText(propiedad.getNombre());
			BotonVentaHandler botonVenderHandler = new BotonVentaHandler(propiedad, algoPoly, botonVender);
			botonVender.setOnAction(botonVenderHandler);
			contenedorVertical.getChildren().add(botonVender);	
		}
		Button botonVolver = new Button();
		botonVolver.setText("Volver");
		BotonVolverHandler botonVolverHandler = new BotonVolverHandler(botoneraAnterior, contenedorPrincipal);
		botonVolver.setOnAction(botonVolverHandler);
		contenedorVertical.getChildren().add(botonVolver);
		contenedorVertical.setPadding(new Insets(15));
		contenedorPrincipal.setLeft(contenedorVertical);
			
	}
	
	public void setBotoneraConstruirCasa(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, VBox botoneraAnterior) {
		Jugador jugador = algoPoly.getJugadorActual();
		VBox contenedorVertical = new VBox(10);
		for (Comprable propiedad: jugador.getPropiedades()) {
			if (DatosDeBarrio.esBarrio(propiedad.getNombre())) {
				Button botonConstruirCasa = new Button();
				botonConstruirCasa.setText(propiedad.getNombre());
				BotonConstruirCasaHandler botonConstruirCasaHandler = new BotonConstruirCasaHandler(propiedad, algoPoly, botonConstruirCasa, vistaInfoJugadores);
				botonConstruirCasa.setOnAction(botonConstruirCasaHandler);
				contenedorVertical.getChildren().add(botonConstruirCasa);	
			}
		}
		Button botonVolver = new Button();
		botonVolver.setText("Volver");
		BotonVolverHandler botonVolverHandler = new BotonVolverHandler(botoneraAnterior, contenedorPrincipal);
		botonVolver.setOnAction(botonVolverHandler);
		contenedorVertical.getChildren().add(botonVolver);
		contenedorVertical.setPadding(new Insets(15));
		contenedorPrincipal.setLeft(contenedorVertical);
	}
	
	public void setBotoneraConstruirHotel(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, VBox botoneraAnterior) {
		Jugador jugador = algoPoly.getJugadorActual();
		VBox contenedorVertical = new VBox(10);
		for (Comprable propiedad: jugador.getPropiedades()) {
			if (DatosDeBarrio.esBarrio(propiedad.getNombre())) {
				Button botonConstruirHotel = new Button();
				botonConstruirHotel.setText(propiedad.getNombre());
				BotonConstruirHotelHandler botonConstruirHotelHandler = new BotonConstruirHotelHandler(propiedad, algoPoly, botonConstruirHotel, vistaInfoJugadores);
				botonConstruirHotel.setOnAction(botonConstruirHotelHandler);
				contenedorVertical.getChildren().add(botonConstruirHotel);	
			}
		}
		Button botonVolver = new Button();
		botonVolver.setText("Volver");
		BotonVolverHandler botonVolverHandler = new BotonVolverHandler(botoneraAnterior, contenedorPrincipal);
		botonVolver.setOnAction(botonVolverHandler);
		contenedorVertical.getChildren().add(botonVolver);
		contenedorVertical.setPadding(new Insets(15));
		contenedorPrincipal.setLeft(contenedorVertical);
	}


}
