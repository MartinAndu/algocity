package src;

import junit.framework.Assert;

import org.junit.Test;

import CentralesElectricas.*;
import Edificios.Posicion;
import Excepciones.ExcepcionCentralElectricaNoPoseeRedDeAgua;
import PlanoGeneral.Hectarea;

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
	
	@Test
	public void seEstableceCentralElectricaCorrectamenteSiHayRedDeAgua(){
		Hectarea unaHectarea = new Hectarea();
		Posicion unaPosicion=new Posicion(2,2);
		CentralElectrica unaCentralElectrica = new CentralElectrica(unaPosicion);
		unaHectarea.habilitarAgua();
		unaHectarea.establecerCentral(unaCentralElectrica);
		Assert.assertEquals(true, unaHectarea.poseeServicioElectrico());
	}
	
	@Test
	public void seEstableceCentralElectricaSinRedDeAguaYLanzaExcepcion(){
		Hectarea unaHectarea = new Hectarea();
		Hectarea estaHectareaEsLlana = new Hectarea();
		Posicion unaPosicion=new Posicion(2,2);
		CentralElectrica unaCentralElectrica = new CentralElectrica(unaPosicion);
		boolean excepcionAtrapada = false;
		
		try{
			estaHectareaEsLlana.establecerCentral(unaCentralElectrica);
		}
		catch (ExcepcionCentralElectricaNoPoseeRedDeAgua excepcion){
			excepcionAtrapada = true;
		}
		
		Assert.assertEquals(true, excepcionAtrapada);
		Assert.assertEquals(false, unaHectarea.poseeServicioDeAgua());
	}
	

}
