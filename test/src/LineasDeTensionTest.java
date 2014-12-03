package src;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import CentralesElectricas.CentralEolica;
import Conectores.LineasDeTension;
import ConstruccionGeneral.Posicion;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;
import Superficies.SuperficieConTerrenoLlano;

public class LineasDeTensionTest {
	
	@Test
	public void seCreanCorrectamenteLasLineasDeTension(){
		LineasDeTensionTest unaLineaDeTension = new LineasDeTensionTest();
		assertNotNull(unaLineaDeTension);
	}
	
    @Test
    public void hayConexionElectricaEnLinea(){
    	
    	Plano unPlano=new PlanoDeterminista();
    	Posicion unaPosicion=new Posicion(2,3);
    	LineasDeTension unaLineaDeTension = new LineasDeTension(unaPosicion);
    	
    	unaLineaDeTension.construirSobrePlano(unPlano);
    	
    	unaLineaDeTension.habilitarConexion();
    	
    	Assert.assertTrue(unaLineaDeTension.conectadoALaRed(new Hectarea(new SuperficieConTerrenoLlano())));
    }	
    	
    	
    @Test
    
    public void hayConexionElectrica(){
    		Posicion unaPosicion = new Posicion(5,5);
            EdificioResidencial unEdificioResidencial = new EdificioResidencial(unaPosicion);
            unEdificioResidencial.habilitarElectricidad();
    Assert.assertTrue(unEdificioResidencial.tieneElectricidad());
}
    @Test
    
    public void pasaLaElectricidad(){
    		Plano unPlano = new PlanoDeterminista();
    		Posicion unaPosicion = new Posicion(2, 2);
    		Posicion otraPosicion = new Posicion(3,2);
    		Posicion tercerPosicion = new Posicion(4,2);
    		LineasDeTension unaConexion= new LineasDeTension(unaPosicion);
    		LineasDeTension otraConexion=new LineasDeTension(otraPosicion);
    		LineasDeTension tercerConexion=new LineasDeTension(tercerPosicion);
    		
    		unaConexion.construirSobrePlano(unPlano);
    		otraConexion.construirSobrePlano(unPlano);
    		tercerConexion.construirSobrePlano(unPlano);
    		otraConexion.habilitarConexion();
    		
    		Assert.assertTrue(tercerConexion.conectadoALaRed(unPlano.devolverHectarea(tercerPosicion)));
    		
   }
    
    @Test
    public void accesoAElectricidad(){
    	
    	Plano unPlano = new PlanoDeterminista();
    	Posicion unaPosicion=new Posicion(4,4);
    	LineasDeTension unaConexion= new LineasDeTension(unaPosicion);
    	unaConexion.construirSobrePlano(unPlano);
    	unaConexion.habilitarConexion();


    	Posicion otraPosicion=new Posicion(7,7);
    	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
    	
		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("agua");
		//unaConexion.proveerServicioZona(unPlano);
		otraHectarea.establecerEdificio(unoResidencial);
		Assert.assertTrue(unoResidencial.tieneElectricidad());
		
    	
    }
    
    @Test
    public void accesoAElectricidadDesdeCentral(){
    	


    	Posicion unaPosicion=new Posicion(2,2);
    	LineasDeTension unaConexion= new LineasDeTension(unaPosicion);
    	Plano unPlano = new PlanoDeterminista();
    	unaConexion.construirSobrePlano(unPlano);
    	Posicion posicionCentralElectrica=new Posicion(2,1);
    	CentralEolica unaCentralElectrica=new CentralEolica(posicionCentralElectrica);
    	Hectarea unaHectarea=unPlano.devolverHectarea(posicionCentralElectrica);
    	unaHectarea.habilitarServicio("agua");
    	unaCentralElectrica.construirSobrePlano(unPlano);//
    	Posicion otraPosicion=new Posicion(3,2);
    	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("agua");
		otraHectarea.establecerEdificio(unoResidencial);
		Assert.assertTrue(unoResidencial.tieneElectricidad());
		
    	
    }
    
    @Test
    public void sinAccesoAElectricidadMuyLejos(){
    	boolean noTieneServiciosSuficiente = false;
    	Plano unPlano = new PlanoDeterminista();
    	Posicion unaPosicion=new Posicion(2,2);
    	LineasDeTension unaConexion= new LineasDeTension(unaPosicion);
    	unaConexion.construirSobrePlano(unPlano);
    	unaConexion.habilitarConexion();


    	Posicion otraPosicion=new Posicion(7,7);
    	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
    	
    	Posicion unaPosicion2 = new Posicion(5,5);
		Edificio unoResidencial = new EdificioResidencial(unaPosicion2);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("agua");
		//unaConexion.proveerServicioZona(unPlano);
		try{
    		otraHectarea.establecerEdificio(unoResidencial);
		}
		catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
			noTieneServiciosSuficiente = true;
		}
		
		Assert.assertTrue(noTieneServiciosSuficiente);//Suponiendo radioDeDistribucion=3 , si eso ca
		
    	
    }
	
}
