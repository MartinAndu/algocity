package algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class HectareasTest {

	@Test
	public void hectareaResidencialDevuelveCostoCorrecto(){
        Hectarea unaHectareaDeEdificiosResidenciales = new HectareaResidencial();
        int costo = unaHectareaDeEdificiosResidenciales.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	public void hectareaResidencialDevuelveConsumoCorrecto(){
		Hectarea unaHectareaDeEdificiosResidenciales = new HectareaResidencial();
        int consumo = unaHectareaDeEdificiosResidenciales.devolverConsumo();
        Assert.assertEquals(1, consumo);
	}
	
	public void hectareaComercialDevuelveCostoCorrecto(){
		Hectarea unaHectareaDeEdificiosComerciales = new HectareaComercial();
		int costo = unaHectareaDeEdificiosComerciales.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	public void hectareaIndustrialDevuelveCostoCorrecto(){
		Hectarea unaHectareaDeEdificiosIndustriales = new HectareaIndustrial();
		int costo = unaHectareaDeEdificiosIndustriales.devolverCosto();
		Assert.assertEquals(10, costo);
	}
}
