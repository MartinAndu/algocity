package src;

import org.junit.Assert;
import org.junit.Test;
import Superficies.Superficie;
import SuperficiesGeneradores.GeneradorSuperficieDeterminista;

public class GeneradorQueAlternaSuperficiesTest {

	@Test
	public void generadorAlternaCorrectamente(){
				
		GeneradorSuperficieDeterminista generador = new GeneradorSuperficieDeterminista();
		
		Superficie superficieQueDeberiaSerLlana1 = generador.generarSuperficie();
		Superficie superficieQueDeberiaSerAgua1 = generador.generarSuperficie();
		Superficie superficieQueDeberiaSerLlana2 = generador.generarSuperficie();
		Superficie superficieQueDeberiaSerAgua2 = generador.generarSuperficie();
		Superficie superficieQueDeberiaSerLlana3 = generador.generarSuperficie();
		
		Assert.assertTrue(!superficieQueDeberiaSerLlana1.sePuedeConstruirUnPozoDeAgua());
		Assert.assertTrue(superficieQueDeberiaSerAgua1.sePuedeConstruirUnPozoDeAgua());
		Assert.assertTrue(!superficieQueDeberiaSerLlana2.sePuedeConstruirUnPozoDeAgua());
		Assert.assertTrue(superficieQueDeberiaSerAgua2.sePuedeConstruirUnPozoDeAgua());
		Assert.assertTrue(!superficieQueDeberiaSerLlana3.sePuedeConstruirUnPozoDeAgua());
	}
}
