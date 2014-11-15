package testPlano;
import static org.junit.Assert.*;
import org.junit.Test;

import planoGeneral.Plano;


public class PlanoTest {

	@Test
	public void testPlanoCrear(){
		
		Plano plano = new Plano(100,100);
		assertNotNull(plano);
	}
	
}
