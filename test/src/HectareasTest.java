package src;

import static org.junit.Assert.fail;




import org.junit.Test;

import CentralesElectricas.CentralElectrica;
import CentralesElectricas.CentralMineral;
import Conectores.ConexionDeAgua;
import Conectores.RutaPavimentada;
import ConstruccionGeneral.Posicion;
import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import PlanoGeneral.Plano;
import PlanoGeneral.PlanoDeterminista;

public class HectareasTest {
	
	@Test
	public void hectareaNoAgregaEdificioSiNoEstanLosServiciosBasicosYLanzaExcepcion(){
		Plano plano = new PlanoDeterminista();
		Posicion pos = new Posicion(1, 1);
        Edificio unEdificioComercial = new EdificioComercial(pos);
        
        try {
        	unEdificioComercial.construirSobrePlano(plano);
        	fail();
        }
        catch (ExcepcionHectareaNoBrindaLosServiciosNecesarios excepcion){
        }
       
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnPozoDeAguaEnUnaSuperficieDeTierra(){
		Plano plano = new PlanoDeterminista();
		Posicion pos = new Posicion(1, 1);
        PozoDeAgua pozo = new PozoDeAgua(pos);
        
        try {
        	pozo.construirSobrePlano(plano);
        	fail();
        }
        catch (ExcepcionNoSePuedeConstruirEnEsteTerreno e){
        }
	}
	
	@Test
	public void hectareaLanzaExcepcionAlEstablecerUnEdificioConLaConstruccionOcupada(){
		Plano plano = new PlanoDeterminista();
		
		Posicion posicion = new Posicion(1, 2);
		PozoDeAgua pozo = new PozoDeAgua(posicion);
		pozo.construirSobrePlano(plano);
		
		Posicion otraPosicion = new Posicion(1, 3);
		ConexionDeAgua canio1 = new ConexionDeAgua(otraPosicion);
		canio1.construirSobrePlano(plano);
		
		Posicion otraPosicionMas = new Posicion(1, 4);
		ConexionDeAgua canio2 = new ConexionDeAgua(otraPosicionMas);
		canio2.construirSobrePlano(plano);		
		
		Posicion unaPosicionMas = new Posicion(1, 5);
		CentralElectrica central = new CentralMineral(unaPosicionMas);
		central.construirSobrePlano(plano);
		
		RutaPavimentada ruta1 = new RutaPavimentada(otraPosicion);
		ruta1.construirSobrePlano(plano);
		
		RutaPavimentada ruta2 = new RutaPavimentada(otraPosicionMas);
		ruta2.construirSobrePlano(plano);
		
		Posicion posicionDeLaCasa = new Posicion(2, 3);
		EdificioResidencial casa = new EdificioResidencial(posicionDeLaCasa);
		casa.construirSobrePlano(plano);
		
		try {
			EdificioResidencial casa2 = new EdificioResidencial(posicionDeLaCasa);
			casa2.construirSobrePlano(plano);
		} catch (ExcepcionHectareaYaContieneUnaConstruccion e) {
		}
	}
	
}