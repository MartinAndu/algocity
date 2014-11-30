package src;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;






import Conectores.ConexionDeAgua;
import ConstruccionGeneral.Posicion;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import Superficies.Superficie;
import Superficies.SuperficieConTerrenoLlano;


public class ConexionesDeAguaTest {
      
	@Test
	public void hayConexionDeAguaEnTuberia(){
		
		Plano unPlano=new Plano(8,8);
		Posicion unaPosicion=new Posicion(2,3);
		ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua(unaPosicion);
		
		unaConexionDeAgua.construirSobrePlano(unPlano);
		
		unaConexionDeAgua.habilitarConexion();
		Superficie superficie = new SuperficieConTerrenoLlano();
		Assert.assertTrue(unaConexionDeAgua.conectadoALaRed(new Hectarea(superficie)));
	}
	
	
	@Test
	
	public void hayConexionDeAgua(){
		Posicion unaPosicion = new Posicion(5,5);
		EdificioResidencial unEdificioResidencial = new EdificioResidencial(unaPosicion);
		unEdificioResidencial.habilitarAgua();
                Assert.assertTrue(unEdificioResidencial.tieneAgua());
        	}
	@Test
	
	public void pasaElAgua(){
		Plano unPlano = new Plano (4,7);
		Posicion unaPosicion = new Posicion(2, 2);
		Posicion otraPosicion = new Posicion(3,2);
		Posicion tercerPosicion = new Posicion(4,2);
		ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
		ConexionDeAgua otraConexion=new ConexionDeAgua(otraPosicion);
		ConexionDeAgua tercerConexion=new ConexionDeAgua(tercerPosicion);
		
		unaConexion.construirSobrePlano(unPlano);
		otraConexion.construirSobrePlano(unPlano);
		tercerConexion.construirSobrePlano(unPlano);
		unaConexion.habilitarConexion();
		//otraConexion.habilitarConexion();
		
		
		
		
		Assert.assertTrue(tercerConexion.conectadoALaRed(unPlano.devolverHectarea(tercerPosicion)));
                		
	}
	
	@Test
	public void accesoAAgua(){
                	
		Plano unPlano = new Plano (8,8);
		Posicion unaPosicion=new Posicion(4,4);
		ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
		unaConexion.construirSobrePlano(unPlano);
		unaConexion.habilitarConexion();
 

		Posicion otraPosicion=new Posicion(7,7);
		Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
		
		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("electricidad");
		unaConexion.proveerServicioZona(unPlano);
		otraHectarea.establecerEdificio(unoResidencial);
		Assert.assertTrue(unoResidencial.tieneAgua());
            			
                		
	}
                
	@Test
	public void accesoAAguaDesdePozo(){
           
		//no se deberia poder construir una conexion de agua sin un pozo de agua que ya provea
		//agua a su entorno.
		Posicion unaPosicion=new Posicion(2,2);
		ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
		Plano unPlano = new Plano (8,8);
		unaConexion.construirSobrePlano(unPlano);
		
		Posicion posicionPozo=new Posicion(1,2);
		PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
		Hectarea unaHectarea=unPlano.devolverHectarea(posicionPozo);
		unaHectarea.establecerPozoDeAgua(unPozo);
		Posicion otraPosicion=new Posicion(3,2);
                	
		Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
		
		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("electricidad");
		unaConexion.proveerServicioZona(unPlano);
		otraHectarea.establecerEdificio(unoResidencial);
		Assert.assertTrue(unoResidencial.tieneAgua());
            			
                	
	}
                
	@Test
	public void sinAccesoAAguaMuyLejos(){
		Plano unPlano = new Plano (8,8);
		Posicion unaPosicion=new Posicion(2,2);
		ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
		unaConexion.construirSobrePlano(unPlano);
		unaConexion.habilitarConexion();
 
                		
		Posicion otraPosicion=new Posicion(7,7);
		Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
		
		Posicion unaPosicion2 = new Posicion(5,5);
		Edificio unoResidencial = new EdificioResidencial(unaPosicion2);
		otraHectarea.habilitarServicio("transito");
		otraHectarea.habilitarServicio("electricidad");
		unaConexion.proveerServicioZona(unPlano);
		try{
			otraHectarea.establecerEdificio(unoResidencial);
			fail();
		}
		catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
		}		
                	
	}

}