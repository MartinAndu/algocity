package algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class EdificiosTest {
	
	@Test
	public void edificioResidencialDevuelveCostoCorrecto(){
        Edificio unEdificioResidencial = new EdificioResidencial();
        int costo = unEdificioResidencial.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void edificioResidencialDevuelveConsumoCorrecto(){
        Edificio unEdificioResidencial = new EdificioResidencial();
        int consumo = unEdificioResidencial.devolverConsumo();
        Assert.assertEquals(1, consumo);
	}
	
	@Test
	public void edificioComercialDevuelveCostoCorrecto(){
        Edificio unEdificioComercial = new EdificioComercial();
		int costo = unEdificioComercial.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void edificioIndustrialDevuelveCostoCorrecto(){
        Edificio unEdificioIndustrial = new EdificioIndustrial();
		int costo = unEdificioIndustrial.devolverCosto();
		Assert.assertEquals(10, costo);
	}
}
