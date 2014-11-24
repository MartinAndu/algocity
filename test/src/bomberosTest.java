package src;

import Bomberos.EstacionDeBomberos;
import CentralesElectricas.CentralEolica;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Excepciones.ExceptionEstacionDeBomberosNoEstaHabilitada;
import junit.framework.Assert;

import org.junit.Test;

import Jugador.Presupuesto;
import Jugador.PresupuestoBajo;


public class bomberosTest {
	@Test
	public void reconstruccionDeResidencialyEolica(){
		
		Posicion unaPosicion=new Posicion(2,1);
		EdificioResidencial unEdificioResidencial=new EdificioResidencial(unaPosicion);
		unEdificioResidencial.destruirUnPoco();
		
		Posicion otraPosicion=new Posicion(5,1);
		CentralEolica unaCentral=new CentralEolica(otraPosicion);
		unaCentral.destruirUnPoco();

		Presupuesto presupuesto = new PresupuestoBajo();
		EstacionDeBomberos unaEstacionDeBomberos=new EstacionDeBomberos();
		unaEstacionDeBomberos.habilitar(presupuesto);
		float porcentajeEsperado=81;
		Assert.assertEquals(unEdificioResidencial.porcentajeDeConstruccion(),porcentajeEsperado);//81=sin reparar, 91=reparado
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
		
		unaEstacionDeBomberos.agregarReconstruible(unEdificioResidencial);
		unaEstacionDeBomberos.agregarReconstruible(unaCentral);
		unaEstacionDeBomberos.realizarReparaciones();
		porcentajeEsperado=91;
		Assert.assertEquals(Math.round(unEdificioResidencial.porcentajeDeConstruccion()),Math.round(porcentajeEsperado));
		porcentajeEsperado=95;
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
	}
}
