package src;

import CentralesElectricas.CentralNuclear;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import junit.framework.Assert;

import org.junit.Test;


public class ReparacionesTest {
	@Test
	public void porcentajeDeConstruccionInicialDeEdificio(){
	Posicion unaPosicion=new Posicion(2,1);
	
	
	EdificioResidencial unEdificioResidencial=new EdificioResidencial(unaPosicion);
	float porcentajeActual= unEdificioResidencial.porcentajeDeConstruccion();
	float porcentajeEsperado=100;
	Assert.assertEquals(porcentajeActual,porcentajeEsperado);
	}
	
	@Test
	public void porcentajeDeConstruccionLuegoDeReconstruccion(){
		
		
		Posicion unaPosicion=new Posicion(2,1);
		
		
		EdificioResidencial unEdificioResidencial=new EdificioResidencial(unaPosicion);
		unEdificioResidencial.destruirUnPoco();
		float porcentajeEsperado=81;
		Assert.assertEquals(unEdificioResidencial.porcentajeDeConstruccion(),porcentajeEsperado);
		int capacidadDeReconstruccionDeResidencialEnUnTurno=1000;
		unEdificioResidencial.reconstruir(capacidadDeReconstruccionDeResidencialEnUnTurno);
		porcentajeEsperado=91;
		Assert.assertEquals(unEdificioResidencial.porcentajeDeConstruccion(),porcentajeEsperado);
		unEdificioResidencial.reconstruir(capacidadDeReconstruccionDeResidencialEnUnTurno);
		porcentajeEsperado=100;
		Assert.assertEquals(unEdificioResidencial.porcentajeDeConstruccion(),porcentajeEsperado);
		unEdificioResidencial.reconstruir(capacidadDeReconstruccionDeResidencialEnUnTurno);
		Assert.assertEquals(unEdificioResidencial.porcentajeDeConstruccion(),porcentajeEsperado);
	}
	
	@Test
	public void reconstruccionDeCentralEolica(){
		
		
		Posicion unaPosicion=new Posicion(2,1);
		
		
		CentralNuclear unaCentral=new CentralNuclear(unaPosicion);
		unaCentral.recibirDanio(38);
		float porcentajeEsperado=81;
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
		int capacidadDeReconstruccionEnUnTurno=1000;
		unaCentral.reconstruir(capacidadDeReconstruccionEnUnTurno);
		porcentajeEsperado=84;
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
		unaCentral.reconstruir(capacidadDeReconstruccionEnUnTurno);
		porcentajeEsperado=87;
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
		unaCentral.reconstruir(capacidadDeReconstruccionEnUnTurno);
		porcentajeEsperado=90;
		Assert.assertEquals(unaCentral.porcentajeDeConstruccion(),porcentajeEsperado);
	}

}
