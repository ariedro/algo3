package fiuba.algo3.clases;

public enum Barrios{

	BUENOS_AIRES_SUR(0), 
	BUENOS_AIRES_NORTE(1), 
	CORDOBA_SUR(2) , 
	CORDOBA_NORTE(3), 	
	SANTA_FE(4) , 
	SALTA_NORTE(5) ,
	SALTA_SUR(6) , 
	NEUQUEN(7) , 
	TUCUMAN(8);
	 
	 private final int numBarrio;

	 Barrios (int numBarrio){
		 
		 this.numBarrio = numBarrio;
	 }
	 
	 public int getNumBarrio() {
		 
		 return this.numBarrio;
	 
	 }
	 
	 
};

