package src;

import junit.framework.Assert;

import org.junit.Test;

import CentralesElectricas.*;
import Excepciones.ExcepcionCentralElectricaNoPoseeRedDeAgua;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Hectarea;

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
	
	@Test
	public void seEstableceCentralElectricaCorrectamenteSiHayRedDeAgua(){
		Hectarea unaHectarea = new Hectarea();
		CentralElectrica unaCentralElectrica = new CentralElectrica();
		unaHectarea.habilitarAgua();
		unaHectarea.establecerCentral(unaCentralElectrica);
		Assert.assertEquals(true, unaHectarea.poseeServicioElectrico());
	}
	
	@Test
	public void seEstableceCentralElectricaSinRedDeAguaYLanzaExcepcion(){
		Hectarea unaHectarea = new Hectarea();
		CentralElectrica unaCentralElectrica = new CentralElectrica();
		boolean excepcionAtrapada = false;
		
		try{
			unaHectarea.establecerCentral(unaCentralElectrica);
		}
		catch (ExcepcionCentralElectricaNoPoseeRedDeAgua excepcion){
			excepcionAtrapada = true;
		}
		
		Assert.assertEquals(true, excepcionAtrapada);
		Assert.assertEquals(false, unaHectarea.poseeServicioDeAgua());
	}
}
