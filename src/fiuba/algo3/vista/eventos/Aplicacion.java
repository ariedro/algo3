package fiuba.algo3.vista.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.vista.*;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 800, 600);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 800, 600);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
}
