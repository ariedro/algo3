package fiuba.algo3.vista.eventos;

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionAbrirEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {

        try {
        	//Estaria bueno poner el informe aca.
			Desktop.getDesktop().open(new File("res/informe.pdf"));
		} catch (IOException e) {
		}
	}

}
