package src;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import CentralesElectricas.CentralElectrica;
import PlanoGeneral.Plano;


public class LineasDeTension {
	
	@Test
	public void seCreanCorrectamenteLasLineasDeTension(){
		LineasDeTension unaLineaDeTension = new LineasDeTension();
		assertNotNull(unaLineaDeTension);
	}
	
	@Test
	public void lasLineasDeTensionSeConectanCorrectamente(){
		//En construccion
		Plano unPlano = new Plano(5,5);
		
		CentralElectrica unaCentralElectrica = new CentralElectrica();
		unaCentralElectrica.construirSobrePlano(unPlano);
		
		
	}
	
}
