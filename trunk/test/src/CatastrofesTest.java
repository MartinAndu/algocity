package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Catastrofe.Terremoto;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import PlanoGeneral.Plano;

public class CatastrofesTest {
	
    @Test
    
    public void terremotoDañaEdificiosMuyCerca(){
	
	Plano unPlano=new Plano(20,20);
	Posicion posicionPozo = new Posicion(4, 4);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 198);
    
    }
    
    @Test
    
    public void terremotoDañaEdificiosEnBorde(){
	
	Plano unPlano=new Plano(80,80);
	Posicion posicionPozo = new Posicion(69,69);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 3);
    
    }
    
    @Test
    
    public void terremotoNoDañaEdificiosLejanos(){
	
	Plano unPlano=new Plano(80,80);
	Posicion posicionPozo = new Posicion(75,75);
	PozoDeAgua unPozo=new PozoDeAgua(posicionPozo);
	unPlano.devolverHectarea(posicionPozo).establecerPozoDeAgua(unPozo);
	Terremoto unTerremoto=new Terremoto();
	unTerremoto.destruirCiudad(unPlano);
	assertEquals(unPozo.devolverDanioRecibido(), 0);
    
    }
    
}
