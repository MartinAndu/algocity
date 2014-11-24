
        package src;



import org.junit.Assert;
import org.junit.Test;






import Conectores.ConexionDeAgua;
import Edificios.Edificio;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;


        public class ConexionesDeAguaTest {
      
                @Test
                        public void hayConexionDeAguaEnTuberia(){
                				
                				Plano unPlano=new Plano(8,8);
                				Posicion unaPosicion=new Posicion(2,3);
                                ConexionDeAgua unaConexionDeAgua = new ConexionDeAgua(unaPosicion);
                        
                                unaConexionDeAgua.construirSobrePlano(unPlano);

                                unaConexionDeAgua.habilitarConexion();
                                
                        Assert.assertTrue(unaConexionDeAgua.conectadoALaRed(new Hectarea()));
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
                		ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
                		ConexionDeAgua otraConexion=new ConexionDeAgua(otraPosicion);
                		unaConexion.construirSobrePlano(unPlano);
                		otraConexion.construirSobrePlano(unPlano);
                		unaConexion.habilitarConexion();
                		otraConexion.habilitarConexion();
                		
                		
                		
                		
                		Assert.assertTrue(otraConexion.conectadoALaRed(unPlano.devolverHectarea(otraPosicion)));
                		
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
            		otraHectarea.habilitarAccesoAlTransito();
            		otraHectarea.habilitarElectricidad();
            		unaConexion.habilitarConAguaSiCorresponde(unPlano, unaPosicion);
            		otraHectarea.establecerEdificio(unoResidencial);
            		Assert.assertTrue(unoResidencial.tieneAgua());
            		
                	
                }
                
                @Test
                public void accesoAAguaDesdePozo(){
                	


                	Posicion unaPosicion=new Posicion(2,2);
                	ConexionDeAgua unaConexion= new ConexionDeAgua(unaPosicion);
                	Plano unPlano = new Plano (8,8);
                	unaConexion.construirSobrePlano(unPlano);

                	Posicion posicionPozo=new Posicion(2,1);
                	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
                	Hectarea unaHectarea=unPlano.devolverHectarea(posicionPozo);
                	unaHectarea.establecerPozoDeAgua(unPozo);
                	Posicion otraPosicion=new Posicion(3,2);
                	
                	Hectarea otraHectarea = unPlano.devolverHectarea(otraPosicion);
                	
            		Edificio unoResidencial = new EdificioResidencial(otraPosicion);
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