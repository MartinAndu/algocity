
        package src;



import org.junit.Assert;
import org.junit.Test;


import Conectores.ConexionDeAgua;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
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
                        
                        EdificioResidencial unEdificioResidencial = new EdificioResidencial();
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
                
                		otraConexion.habilitarConAguaSiCorresponde(unPlano, otraPosicion);
                		
                		Assert.assertTrue(otraConexion.conectadoALaRed(unaHectarea));
                		
               }
                
                @Test
                public void accesoAAgua(){
                	Plano unPlano = new Plano (8,8);
                	Posicion unaPosicion=new Posicion(4,4);
                	Hectarea unaHectarea = unPlano.devolverHectarea(unaPosicion);
                	ConexionDeAgua unaConexion= new ConexionDeAgua(unaHectarea);
                	unaConexion.habilitarAgua();
 

                	Posicion otraPosicion=new Posicion(6,6);
                	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);

            		Edificio unoResidencial = new EdificioResidencial();
            		otraHectarea.habilitarAccesoAlTransito();
            		otraHectarea.habilitarElectricidad();
            		unaConexion.habilitarConAguaSiCorresponde(unPlano, unaPosicion);
            		otraHectarea.establecerEdificio(unoResidencial);
            		Assert.assertTrue(unoResidencial.tieneAgua());
            		
                	
                }

}