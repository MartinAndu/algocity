package src;

import org.junit.Test;

import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
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
		Posicion unaPosicion = new Posicion(5,5);
		Hectarea unaHectarea = new Hectarea();
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion);
        
        boolean excepcionAtrapada = false;
        try {
        	unaHectarea.establecerEdificio(unEdificioComercial);
        }
        catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
        	excepcionAtrapada = true;
        }
        
        Assert.assertTrue(excepcionAtrapada);
        Assert.assertFalse(unaHectarea.poseeConstruccion());
        Assert.assertEquals(unEdificioComercial.obtenerPosicion(), unaPosicion);
        Assert.assertEquals(unaPosicion.devolverCoordenadaX(), 5);
	}
	
	@Test
	public void hectareaAgregaUnEdificioComercialAlTenerLos3ServiciosHabilitados(){
		Posicion unaPosicion = new Posicion(5,5);
		Hectarea unaHectarea = new Hectarea();
		
		unaHectarea.habilitarAccesoAlTransito();
		unaHectarea.habilitarAgua();
		unaHectarea.habilitarElectricidad();
		
		Assert.assertTrue(unaHectarea.poseeLos3Servicios());
		
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion);
        unaHectarea.establecerEdificio(unEdificioComercial);
        
        Assert.assertTrue(unaHectarea.poseeConstruccion());
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnPozoDeAguaEnUnaSuperficieDeTierra(){
		Posicion unaPosicion = new Posicion(5,5);
		Hectarea unaHectarea = new Hectarea();
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua(unaPosicion);
		
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
		Posicion unaPosicion = new Posicion(5,5);
		Posicion unaPosicion2 = new Posicion(52,54);
		Hectarea unaHectarea = new Hectarea();
		
        Edificio unEdificioResidencial = new EdificioResidencial(unaPosicion);
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion2);
        
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