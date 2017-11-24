package fiuba.algo3.clases;

public class Dados {

	private int primerDado = 0;
	private int segundoDado = 0;
	
	private boolean dobles = false;
	
	public int getSuma() {
	
		return (this.primerDado + this.segundoDado);

	}

	public int getValorPrimerDado() {
	
		return this.primerDado;
	
	}
	
	public int getValorSegundoDado() {
		
		return this.segundoDado;
		
	}
	
	public boolean sonDobles() {
		
		return this.dobles;
		
	}
	
	public int rolarDados() {
			
		this.primerDado = (int) (Math.random() * 6) + 1;
		this.segundoDado = (int) (Math.random() * 6) + 1;
		
		if (this.primerDado == this.segundoDado) {
			
			this.dobles = true;
			
		} else this.dobles = false;
		
		
		
		return this.getSuma();
		
	}
	
	
	
}
