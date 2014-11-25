package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Catastrofe.Terremoto;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import PlanoGeneral.Plano;

public class CatastrofesTest {
	
    @Test
    
    public void terremotoDaniaEdificiosMuyCerca(){
	
	Plano unPlano=new Plano(20,20);
	Posicion posicionPozo = new Posicion(3, 3);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 197);
    
    }
    
    @Test
    
    public void terremotoDaniaEdificiosEnBorde(){
	
	Plano unPlano=new Plano(80,80);
	Posicion posicionPozo = new Posicion(74,74);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 2);//el danio estimado se calcula como el doble del porcentaje, esto lo hice para no usar numeros con coma.
    
    }
    
    @Test
    
    public void terremotoNoDaniaEdificiosLejanos(){
	
	Plano unPlano=new Plano(80,80);
	Posicion posicionPozo = new Posicion(79,79);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 0);
    
    }
    
}
