
        package src;



import org.junit.Assert;
import org.junit.Test;




import Conectores.ConexionDeAgua;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;


        public class ConexionesDeAguaTest {
      
                @Test
                        public void hayConexionDeAguaEnTuberia(){
                				Hectarea unaHectarea=new Hectarea();
                                ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua(unaHectarea);
                                unaConexionDeAgua.habilitarAgua();
                                
                        Assert.assertTrue(unaConexionDeAgua.conectadoALaRed(unaHectarea));
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
                		Hectarea unaHectarea = unPlano.devolverHectarea(unaPosicion);
                		Hectarea otraHectarea= unPlano.devolverHectarea(otraPosicion);
                		ConexionDeAgua unaConexion= new ConexionDeAgua(unaHectarea);
                		ConexionDeAgua otraConexion=new ConexionDeAgua(otraHectarea);
                		unaConexion.habilitarAgua();
                
                		unaConexion.habilitarCanioConAguaSiCorresponde(unPlano, unaPosicion);
                		
                		Assert.assertTrue(otraConexion.conectadoALaRed(otraHectarea));
                		
               }
                
                @Test
                public void accesoAAgua(){
                	
                	Plano unPlano = new Plano (8,8);
                	Posicion unaPosicion=new Posicion(4,4);
                	Hectarea unaHectarea = unPlano.devolverHectarea(unaPosicion);
                	ConexionDeAgua unaConexion= new ConexionDeAgua(unaHectarea);
                	unaConexion.habilitarAgua();
 

                	Posicion otraPosicion=new Posicion(7,7);
                	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
                	
                	Posicion unaPosicion2 = new Posicion(5,5);
            		Edificio unoResidencial = new EdificioResidencial(unaPosicion2);
            		otraHectarea.habilitarAccesoAlTransito();
            		otraHectarea.habilitarElectricidad();
            		unaConexion.habilitarConAguaSiCorresponde(unPlano, unaPosicion);
            		otraHectarea.establecerEdificio(unoResidencial);
            		Assert.assertTrue(unoResidencial.tieneAgua());
            		
                	
                }
                
                @Test
                public void sinAccesoAAguaMuyLejos(){
                	boolean noTieneServiciosSuficiente = false;
                	Plano unPlano = new Plano (8,8);
                	Posicion unaPosicion=new Posicion(2,2);
                	Hectarea unaHectarea = unPlano.devolverHectarea(unaPosicion);
                	ConexionDeAgua unaConexion= new ConexionDeAgua(unaHectarea);
                	unaConexion.habilitarAgua();
 

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