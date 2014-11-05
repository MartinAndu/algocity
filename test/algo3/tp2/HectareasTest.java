package algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class HectareasTest {
	
	@Test
	public void hectareaResidencialDevuelveCostoCorrecto(){
		Ubicacion ubicacionDePrueba = new Ubicacion(0,0);
        Hectarea unaHectareaDeEdificiosResidenciales = new HectareaResidencial(ubicacionDePrueba);
        int costo = unaHectareaDeEdificiosResidenciales.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void hectareaResidencialDevuelveConsumoCorrecto(){
		Ubicacion ubicacionDePrueba = new Ubicacion(0,0);
		Hectarea unaHectareaDeEdificiosResidenciales = new HectareaResidencial(ubicacionDePrueba);
        int consumo = unaHectareaDeEdificiosResidenciales.devolverConsumo();
        Assert.assertEquals(1, consumo);
	}
	
	@Test
	public void hectareaComercialDevuelveCostoCorrecto(){
		Ubicacion ubicacionDePrueba = new Ubicacion(0,0);
		Hectarea unaHectareaDeEdificiosComerciales = new HectareaComercial(ubicacionDePrueba);
		int costo = unaHectareaDeEdificiosComerciales.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void hectareaIndustrialDevuelveCostoCorrecto(){
		Ubicacion ubicacionDePrueba = new Ubicacion(0,0);
		Hectarea unaHectareaDeEdificiosIndustriales = new HectareaIndustrial(ubicacionDePrueba);
		int costo = unaHectareaDeEdificiosIndustriales.devolverCosto();
		Assert.assertEquals(10, costo);
	}
}
