package src;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class LineasDeTension {
	
	@Test
	public void seCreanCorrectamenteLasLineasDeTension(){
		LineasDeTension unaLineaDeTension = new LineasDeTension();
		assertNotNull(unaLineaDeTension);
	}
	
	@Test
	public void lasLineasDeTensionSoloSeConectanConUnaZonaSinoLanzaExcepcion(){
		//En construccion
		
	}
	

	
	@Test
	public void seIntentaConectarUnaLineaDeTensionPeroSobrepasaLaCapacidadMaximaDeLaCentralElectrica(){

		
	}
	
}
