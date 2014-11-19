
        package src;



import org.junit.Assert;
        import org.junit.Test;




import Conectores.ConexionDeAgua;
import Edificios.EdificioResidencial;


        public class ConexionesDeAguaTest {
      
                @Test
                        public void hayConexionDeAguaEnTuberia(){
                                ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua();
                                unaConexionDeAgua.habilitarAgua();
                                
                        Assert.assertEquals(unaConexionDeAgua.conectadoALaRed(),true);
                }
                
                
                @Test
                
                public void hayConexionDeAgua(){
                        
                        EdificioResidencial unEdificioResidencial = new EdificioResidencial();
                        unEdificioResidencial.habilitarAgua();
                Assert.assertEquals(unEdificioResidencial.tieneAgua(), true);
        }
       
        

}