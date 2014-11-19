
        package src;



import org.junit.Assert;
import org.junit.Test;







import Conectores.ConexionDeAgua;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;


        public class ConexionesDeAguaTest {
      
                @Test
                        public void hayConexionDeAguaEnTuberia(){
                                ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua();
                                unaConexionDeAgua.habilitarAgua();
                                
                        Assert.assertTrue(unaConexionDeAgua.conectadoALaRed());
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
                		ConexionDeAgua unaConexion= new ConexionDeAgua();
                		ConexionDeAgua otraConexion=new ConexionDeAgua();
                		unaHectarea.establecerConexionDeAgua(unaConexion);
                		otraHectarea.establecerConexionDeAgua(otraConexion);
                		unaConexion.habilitarAgua();
                
                		otraConexion.habilitarConAguaSiCorresponde(unPlano, otraPosicion);
                		
                		Assert.assertTrue(otraConexion.conectadoALaRed());
                		
               }
        

}