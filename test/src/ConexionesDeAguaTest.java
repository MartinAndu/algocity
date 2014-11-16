
	package src;

	import junit.framework.Assert;

	import org.junit.Test;

	import CentralesElectricas.*;
import Conectores.ConexionDeAgua;
import Edificios.EdificioResidencial;

	public class ConexionesTuberiasTest {
		

		

		
		@Test
			
			public void hayConexionDeAguaEnTuberia(){
				ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua();
				unaConexionDeAgua.habilitarAgua();
				
			Assert.assertEquals(unaConexionDeAgua.conectadoALaRed(), true);
		}
		
		
		@Test
		
		public void hayConexionDeAgua(){
			
			EdificioResidencial unEdificioResidencial = new EdificioResidencial();
			unEdificioResidencial.habilitarAgua();
		Assert.assertEquals(unEdificioResidencial.tieneAgua(), true);
	}
	
		
	

}
