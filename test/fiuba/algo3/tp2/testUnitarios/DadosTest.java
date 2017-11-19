package fiuba.algo3.tp2.testUnitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.clases.Dados;

public class DadosTest {
	
	@Test
	public void test01CrearDadosNoEsNull() {
		
		Dados unosDados = new Dados();
		
		assertNotNull(unosDados);

		
	}	
	
	@Test 
	public void test02DadosCreadosTienenComoSumaValorCero() {
		
		Dados unosDados = new Dados();
		
		assertEquals(0, unosDados.getSuma());
	}
	
	@Test
	public void test03DadosCreadosTieneCeroComoValorDelPrimerDado() {
		
		Dados unosDados = new Dados();
				
		assertEquals(0, unosDados.getValorPrimerDado());
		
	}
	
	
	@Test
	public void test04DadosCreadosTieneCeroComoValorDelSegundoDado() {
		
		Dados unosDados = new Dados();
		
		assertEquals(0, unosDados.getValorSegundoDado());
		
	}
	
	@Test
	public void test05DadosCreadosNoSonDobles() {
		
		Dados unosDados = new Dados();
		
		assertFalse(unosDados.sonDobles());
		
		
	}
	
	@Test
	public void test06RolarDadosDevuelveUnaSumaCorrecta() {
		
		Dados unosDados = new Dados();
		
		boolean sumaCorrecta = true;
		
		for (int i=0 ; i<1000 ; i++) {
			
			int suma = unosDados.rolarDados();
			
			if (suma != (unosDados.getValorPrimerDado() + unosDados.getValorSegundoDado())) {
				
				sumaCorrecta = false;
			
			}
			
		}
		
		assertTrue(sumaCorrecta);
		
	}
	
	
	@Test
	public void test07SonDoblesSoloCuandoAmbosDadosSonIguales() {
		
		Dados unosDados = new Dados();
		
		boolean comparacionCorrecta = true;
		
		for (int i=0 ; i<1000 ; i++) {
			
			unosDados.rolarDados();
			
			if ((unosDados.sonDobles()) != (unosDados.getValorPrimerDado() == unosDados.getValorSegundoDado())) {
			
				comparacionCorrecta = false;
			
				break;
			}
		
		}
		
		assertTrue(comparacionCorrecta);
		
	}
	
	
	

}
