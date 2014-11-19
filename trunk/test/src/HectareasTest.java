package src;

import org.junit.Test;

import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Hectarea;
import junit.framework.Assert;

public class HectareasTest {
	
	@Test
	public void hectareaSeCreaCorrectamente(){
		Hectarea unaHectarea = new Hectarea();
		Assert.assertFalse(unaHectarea.poseeConstruccion());
		Assert.assertFalse(unaHectarea.poseeLos3Servicios());
	}
	
	@Test
	public void hectareaNoAgregaEdificioSiNoEstanLosServiciosBasicosYLanzaExcepcion(){
		Hectarea unaHectarea = new Hectarea();
        Edificio unEdificioComercial = new EdificioComercial();
        
        boolean excepcionAtrapada = false;
        try {
        	unaHectarea.establecerEdificio(unEdificioComercial);
        }
        catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
        	excepcionAtrapada = true;
        }
        
        Assert.assertTrue(excepcionAtrapada);
        Assert.assertFalse(unaHectarea.poseeConstruccion());
	}
	
	@Test
	public void hectareaAgregaUnEdificioComercialAlTenerLos3ServiciosHabilitados(){
		Hectarea unaHectarea = new Hectarea();
		
		unaHectarea.habilitarAccesoAlTransito();
		unaHectarea.habilitarAgua();
		unaHectarea.habilitarElectricidad();
		
		Assert.assertTrue(unaHectarea.poseeLos3Servicios());
		
        Edificio unEdificioComercial = new EdificioComercial();
        unaHectarea.establecerEdificio(unEdificioComercial);
        
        Assert.assertTrue(unaHectarea.poseeConstruccion());
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnPozoDeAguaEnUnaSuperficieDeTierra(){
		Hectarea unaHectarea = new Hectarea();
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua();
		
		boolean excepcionAtrapada = false;
		
		try{
			unaHectarea.establecerPozoDeAgua(unPozoDeAgua);
		}
		catch (ExcepcionNoSePuedeConstruirEnEsteTerreno excepcion){
			excepcionAtrapada = true;
		}
		
		Assert.assertTrue(excepcionAtrapada);
		Assert.assertFalse(unaHectarea.poseeConstruccion());
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnEdificioConLaConstruccionOcupada(){
		Hectarea unaHectarea = new Hectarea();
		
        Edificio unEdificioResidencial = new EdificioResidencial();
        Edificio unEdificioComercial = new EdificioComercial();
        
		unaHectarea.habilitarAccesoAlTransito();
		unaHectarea.habilitarAgua();
		unaHectarea.habilitarElectricidad();
        
		boolean excepcionAtrapada = false;
		
		try{
			unaHectarea.establecerEdificio(unEdificioResidencial);
			unaHectarea.establecerEdificio(unEdificioComercial);
		}
		catch (ExcepcionHectareaYaContieneUnaConstruccion excepcion){
			excepcionAtrapada = true;
		}
		
		Assert.assertTrue(excepcionAtrapada);
	}
	
}