package src;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import CentralesElectricas.CentralElectrica;
import Edificios.Posicion;
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
		Posicion unaPosicion=new Posicion(2,2);
		CentralElectrica unaCentralElectrica = new CentralElectrica(unaPosicion);
		unaCentralElectrica.construirSobrePlano(unPlano);	
		
		
	}
	
}
