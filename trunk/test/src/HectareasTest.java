package src;

import static org.junit.Assert.fail;



import org.junit.Test;

import ConstruccionGeneral.Posicion;
import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Hectarea;
import Superficies.SuperficieConTerrenoLlano;
import junit.framework.Assert;

public class HectareasTest {
	@Test
	public void hectareaSeCreaCorrectamente(){
		Hectarea unaHectarea = new Hectarea(new SuperficieConTerrenoLlano());
		Assert.assertFalse(unaHectarea.poseeConstruccion());
		Assert.assertFalse(unaHectarea.poseeLosTresServicios());
	}
	
	@Test
	public void hectareaNoAgregaEdificioSiNoEstanLosServiciosBasicosYLanzaExcepcion(){
		Posicion unaPosicion = new Posicion(5,5);
		Hectarea unaHectarea = new Hectarea(new SuperficieConTerrenoLlano());
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
		Hectarea unaHectarea = new Hectarea(new SuperficieConTerrenoLlano());
		
		unaHectarea.habilitarServicio("transito");
		unaHectarea.habilitarServicio("agua");
		unaHectarea.habilitarServicio("electricidad");
		
		Assert.assertTrue(unaHectarea.poseeLosTresServicios());
		
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion);
        unaHectarea.establecerEdificio(unEdificioComercial);
        
        Assert.assertTrue(unaHectarea.poseeConstruccion());
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnPozoDeAguaEnUnaSuperficieDeTierra(){
		Posicion unaPosicion = new Posicion(5,5);
		Hectarea unaHectarea = new Hectarea(new SuperficieConTerrenoLlano());
		
		PozoDeAgua unPozoDeAgua = new PozoDeAgua(unaPosicion);
		
		try{
			unaHectarea.establecerPozoDeAgua(unPozoDeAgua);
			fail("se deberia lanzar una excepcion");
		}
		catch (ExcepcionNoSePuedeConstruirEnEsteTerreno excepcion){
		}
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnEdificioConLaConstruccionOcupada(){
		Posicion unaPosicion = new Posicion(5,5);
		Posicion unaPosicion2 = new Posicion(52,54);
		Hectarea unaHectarea = new Hectarea(new SuperficieConTerrenoLlano());
		
        Edificio unEdificioResidencial = new EdificioResidencial(unaPosicion);
        Edificio unEdificioComercial = new EdificioComercial(unaPosicion2);
        
		unaHectarea.habilitarServicio("transito");
		unaHectarea.habilitarServicio("agua");
		unaHectarea.habilitarServicio("electricidad");
		
		try{
			unaHectarea.establecerEdificio(unEdificioResidencial);
			unaHectarea.establecerEdificio(unEdificioComercial);
			fail("se deberia lanzar una excepcion");
		}
		catch (ExcepcionHectareaYaContieneUnaConstruccion excepcion){
		}
	}
	
}