package src;

import org.junit.Assert;
import org.junit.Test;

import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Superficies.Superficie;
import SuperficiesGeneradores.GeneradorSuperficie;
import SuperficiesGeneradores.GeneradorSuperficieDeterminista;

public class GeneradorQueAlternaSuperficiesTest {

	@Test
	public void generadorAlternaCorrectamente(){
		Posicion unaPosicion = new Posicion(1,1);
		Edificio unResidencial = new EdificioResidencial(unaPosicion);
		
		GeneradorSuperficie generadorSuperficie = new GeneradorSuperficieDeterminista();
		
		Superficie superficieQueDeberiaSerLlana1 = generadorSuperficie.generarSuperficie();
		Superficie superficieQueDeberiaSerAgua1 = generadorSuperficie.generarSuperficie();
		Superficie superficieQueDeberiaSerLlana2 = generadorSuperficie.generarSuperficie();
		Superficie superficieQueDeberiaSerAgua2 = generadorSuperficie.generarSuperficie();
		Superficie superficieQueDeberiaSerLlana3 = generadorSuperficie.generarSuperficie();
		
		Assert.assertTrue(superficieQueDeberiaSerLlana1.puedoConstruir(unResidencial));
		Assert.assertTrue(!superficieQueDeberiaSerAgua1.puedoConstruir(unResidencial));
		Assert.assertTrue(superficieQueDeberiaSerLlana2.puedoConstruir(unResidencial));
		Assert.assertTrue(!superficieQueDeberiaSerAgua2.puedoConstruir(unResidencial));
		Assert.assertTrue(superficieQueDeberiaSerLlana3.puedoConstruir(unResidencial));
	}
}
