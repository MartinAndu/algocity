package src;

import junit.framework.Assert;

import org.junit.Test;

import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

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
	
	@Test
	public void edificiosCreadosNoPoseenServiciosAlPrincipio(){
		Edificio unoResidencial = new EdificioResidencial();
		Edificio unoComercial = new EdificioComercial();
		Edificio unoIndustrial = new EdificioIndustrial();

		Assert.assertFalse(unoResidencial.tieneElectricidad());
		Assert.assertFalse(unoResidencial.tieneAgua());
		Assert.assertFalse(unoResidencial.tieneAccesoAlTransito());
		Assert.assertFalse(unoComercial.tieneElectricidad());
		Assert.assertFalse(unoComercial.tieneAgua());
		Assert.assertFalse(unoComercial.tieneAccesoAlTransito());
		Assert.assertFalse(unoIndustrial.tieneElectricidad());
		Assert.assertFalse(unoIndustrial.tieneAgua());
		Assert.assertFalse(unoIndustrial.tieneAccesoAlTransito());
	}
	
	@Test
	public void edificioHabilitaServiciosCorrectamente(){
		Edificio unoResidencial = new EdificioResidencial();
		
		unoResidencial.habilitarAccesoAlTransito();
		unoResidencial.habilitarAgua();
		unoResidencial.habilitarElectricidad();
		
		Assert.assertTrue(unoResidencial.tieneElectricidad());
		Assert.assertTrue(unoResidencial.tieneAgua());
		Assert.assertTrue(unoResidencial.tieneAccesoAlTransito());
	}
	
	@Test
	public void edificioPuedeConstruirseEnSuperficieLlanaPeroNoEnUnaConAgua(){
		Superficie unaSuperficieLlana = new SuperficieConTerrenoLlano();
		Superficie unaSuperficieConAgua = new SuperficieConAgua();
		
		Edificio unoResidencial = new EdificioResidencial();
		Assert.assertTrue(unaSuperficieLlana.puedoConstruir(unoResidencial));
		Assert.assertFalse(unaSuperficieConAgua.puedoConstruir(unoResidencial));
	}
}
