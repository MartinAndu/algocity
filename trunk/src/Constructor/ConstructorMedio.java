package Constructor;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;

public class ConstructorMedio extends Constructor{
	
	public EdificioResidencial construirZonaResidencial(Posicion unaPosicion){
		EdificioResidencial unResidencial = new EdificioResidencial(unaPosicion);	
		
		return unResidencial;
	}
	
	public EdificioComercial construirZonaComercial(Posicion unaPosicion){
		EdificioComercial unComercial = new EdificioComercial(unaPosicion);
		
		return unComercial;
	}
	
	public EdificioIndustrial construirZonaIndustrial(Posicion unaPosicion){
		EdificioIndustrial unIndustrial = new EdificioIndustrial(unaPosicion);
		
		return unIndustrial;
	}
	
	public PozoDeAgua construirPozoDeAgua(Posicion unaPosicion){
		PozoDeAgua unPozo = new PozoDeAgua(unaPosicion);
		
		return unPozo;
	}
	
	public CentralEolica construirCentralEolica(Posicion unaPosicion){
		CentralEolica unaCentralEolica = new CentralEolica(unaPosicion);
		
		return unaCentralEolica;
	}
	
	public CentralMineral construirCentralMineral(Posicion unaPosicion){
		CentralMineral unaCentralMineral = new CentralMineral(unaPosicion);
		
		return unaCentralMineral;
	}
	
	public CentralNuclear construirCentralNuclear(Posicion unaPosicion){
		CentralNuclear unaCentralNuclear = new CentralNuclear(unaPosicion);
		
		return unaCentralNuclear;
	}
	
	public RutaPavimentada construirRuta(Posicion unaPosicion){
		RutaPavimentada unaRuta = new RutaPavimentada(unaPosicion);
		
		return unaRuta;
	}

	public LineasDeTension construirLineaDeTension(Posicion unaPosicion) {
		LineasDeTension unaLineaDeTension = new LineasDeTension(unaPosicion);
		
		return unaLineaDeTension;
	}

	public ConexionDeAgua construirTuberia(Posicion unaPosicion){
		ConexionDeAgua unaConexion = new ConexionDeAgua(unaPosicion);
		
		return unaConexion;
	}
}