package fiuba.algo3.clases;

import java.util.Random;

public class Dado {
	
	public int tirar() {
		return (int) (Math.random() * 6) + 1;
	}
	
}
