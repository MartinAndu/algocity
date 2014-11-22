package src;

import junit.framework.Assert;

import org.junit.Test;

import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class EdificiosTest {
	
	@Test
	public void edificioResidencialDevuelveCostoCorrecto(){
		Posicion unaPosicion = new Posicion(5,5);
        Edificio unEdificioResidencial = new EdificioResidencial(unaPosicion);
        int costo = unEdificioResidencial.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void edificioResidencialDevuelveConsumoCorrecto(){
		Posicion unaPosicion = new Posicion(5,5);
        Edificio unEdificioResidencial = new EdificioResidencial(unaPosicion);
        int consumo = unEdificioResidencial.devolverConsumo();
        Assert.assertEquals(1, consumo);
	}
	
	@Test
	public void edificioComercialDevuelveCostoCorrecto(){
		Posicion unaPosicion = new Posicion(5,5);
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion);
		int costo = unEdificioComercial.devolverCosto();
        Assert.assertEquals(5, costo);
	}
	
	@Test
	public void edificioIndustrialDevuelveCostoCorrecto(){
		Posicion unaPosicion = new Posicion(5,5);
        Edificio unEdificioIndustrial = new EdificioIndustrial(unaPosicion);
		int costo = unEdificioIndustrial.devolverCosto();
		Assert.assertEquals(10, costo);
	}
	
	@Test
	public void edificiosCreadosNoPoseenServiciosAlPrincipio(){
		Posicion unaPosicion = new Posicion(5,5);
		Posicion unaPosicion2 = new Posicion(6,6);
		Posicion unaPosicion3 = new Posicion(2,6);
		Edificio unoResidencial = new EdificioResidencial(unaPosicion);
		Edificio unoComercial = new EdificioComercial(unaPosicion2);
		Edificio unoIndustrial = new EdificioIndustrial(unaPosicion3);

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
		Posicion unaPosicion = new Posicion(6,6);
		Edificio unoResidencial = new EdificioResidencial(unaPosicion);
		
		unoResidencial.habilitarAccesoAlTransito();
		unoResidencial.habilitarAgua();
		unoResidencial.habilitarElectricidad();
		
		Assert.assertTrue(unoResidencial.tieneElectricidad());
		Assert.assertTrue(unoResidencial.tieneAgua());
		Assert.assertTrue(unoResidencial.tieneAccesoAlTransito());
	}
	
	@Test
	public void edificioPuedeConstruirseEnSuperficieLlanaPeroNoEnUnaConAgua(){
		Posicion unaPosicion = new Posicion(6,6);
		Superficie unaSuperficieLlana = new SuperficieConTerrenoLlano();
		Superficie unaSuperficieConAgua = new SuperficieConAgua();
		
		Edificio unoResidencial = new EdificioResidencial(unaPosicion);
		Assert.assertTrue(unaSuperficieLlana.puedoConstruir(unoResidencial));
		Assert.assertFalse(unaSuperficieConAgua.puedoConstruir(unoResidencial));
	}
}
