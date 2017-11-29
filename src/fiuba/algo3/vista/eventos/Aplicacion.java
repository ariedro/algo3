package fiuba.algo3.vista.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.clases.AlgoPoly;
import fiuba.algo3.vista.*;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");
        
        AlgoPoly algoPoly = crearModelo();
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, algoPoly);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1280, 720);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1280, 720);
        
        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
    
    private AlgoPoly crearModelo() {
        AlgoPoly algoPoly = new AlgoPoly();
        return algoPoly;
    }
}
