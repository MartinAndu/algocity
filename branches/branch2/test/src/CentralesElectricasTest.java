package src;

import junit.framework.Assert;

import org.junit.Test;

import CentralesElectricas.*;

public class CentralesElectricasTest {
	
	@Test
	public void centralEolicaDevuelveCapacidadMaximaEnMWCorrecta(){
		CentralElectrica unaCentralEolica = new CentralEolica();
		int capacidad = unaCentralEolica.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(100, capacidad);
	}
	
	@Test
	public void centralMineralDevuelveCapacidadMaximaEnMWCorrecta(){
		CentralElectrica unaCentralMineral = new CentralMineral();
		int capacidad = unaCentralMineral.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(400, capacidad);
		
	}
	
	@Test
	public void centralNuclearDevuelveCapacidadMaximaEnMWCorrecta(){
		CentralElectrica unaCentralNuclear = new CentralNuclear();
		int capacidad = unaCentralNuclear.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(1000, capacidad);
	}
	
}
