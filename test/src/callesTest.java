
	

    package src;



import org.junit.Assert;
import org.junit.Test;







import Conectores.ConexionDeAgua;
import Conectores.RutaPavimentada;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

	public class callesTest {
              
            
            @Test
            
            public void hayConexionAlTransito(){
            		Posicion unaPosicion = new Posicion(5,5);
                    EdificioResidencial unEdificioResidencial = new EdificioResidencial(unaPosicion);
                    unEdificioResidencial.habilitarAccesoAlTransito();
            Assert.assertTrue(unEdificioResidencial.tieneAccesoAlTransito());
    }
            
            

            
            @Test
            public void accesoARutaPavimentada(){
            	
            	Plano unPlano = new Plano (8,8);
            	Posicion unaPosicion=new Posicion(4,4);
            	RutaPavimentada unaConexion= new RutaPavimentada(unaPosicion);
            	unaConexion.construirSobrePlano(unPlano);
            	unaConexion.habilitarConexion();


            	Posicion otraPosicion=new Posicion(7,7);
            	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
            	
        		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
        		otraHectarea.habilitarAgua();
        		otraHectarea.habilitarElectricidad();
        		otraHectarea.establecerEdificio(unoResidencial);
        		Assert.assertTrue(unoResidencial.tieneAgua());
        		
            	
            }
            
           
            @Test
            public void sinAccesoAAguaMuyLejos(){
            	boolean noTieneServiciosSuficiente = false;
            	Plano unPlano = new Plano (8,8);
            	Posicion unaPosicion=new Posicion(2,2);
            	ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
            	unaConexion.construirSobrePlano(unPlano);
            	unaConexion.habilitarConexion();


            	Posicion otraPosicion=new Posicion(7,7);
            	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
            	
            	Posicion unaPosicion2 = new Posicion(5,5);
        		Edificio unoResidencial = new EdificioResidencial(unaPosicion2);
        		otraHectarea.habilitarAccesoAlTransito();
        		otraHectarea.habilitarElectricidad();
        		unaConexion.habilitarConAguaSiCorresponde(unPlano, unaPosicion);
        		try{
            		otraHectarea.establecerEdificio(unoResidencial);
        		}
        		catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
        			noTieneServiciosSuficiente = true;
        		}
        		
        		Assert.assertTrue(noTieneServiciosSuficiente);//Suponiendo radioDeDistribucion=3 , si eso ca
        		
            	
            }

}

