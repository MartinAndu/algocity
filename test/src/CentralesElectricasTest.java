package src;

import junit.framework.Assert;
import org.junit.Test;
import CentralesElectricas.*;
import Edificios.Posicion;

public class CentralesElectricasTest {
	
	@Test
	public void centralEolicaDevuelveCapacidadMaximaEnMWCorrecta(){
		Posicion unaPosicion = new Posicion(5,5);
		CentralElectrica unaCentralEolica = new CentralEolica(unaPosicion);
		int capacidad = unaCentralEolica.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(100, capacidad);
	}
	
	@Test
	public void centralMineralDevuelveCapacidadMaximaEnMWCorrecta(){
		Posicion unaPosicion = new Posicion(5,5);
		CentralElectrica unaCentralMineral = new CentralMineral(unaPosicion);
		int capacidad = unaCentralMineral.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(400, capacidad);
		
	}
	
	@Test
	public void centralNuclearDevuelveCapacidadMaximaEnMWCorrecta(){
		Posicion unaPosicion = new Posicion(5,5);
		CentralElectrica unaCentralNuclear = new CentralNuclear(unaPosicion);
		int capacidad = unaCentralNuclear.obtenerCapacidadMaxDeAbastecimientoEnMW();
		Assert.assertEquals(1000, capacidad);
	}

}
