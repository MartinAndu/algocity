package Jugador;

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
	
	public ConstructorMedio(Presupuesto presupuesto) {
		super(presupuesto);
	}
	
	public EdificioResidencial construirZonaResidencial(Posicion unaPosicion){
		EdificioResidencial unResidencial = new EdificioResidencial(unaPosicion);
		this.construir(unResidencial);
		
		return unResidencial;
	}
	
	public EdificioComercial construirZonaComercial(Posicion unaPosicion){
		EdificioComercial unComercial = new EdificioComercial(unaPosicion);
		this.construir(unComercial);
		
		return unComercial;
	}
	
	public EdificioIndustrial construirZonaIndustrial(Posicion unaPosicion){
		EdificioIndustrial unIndustrial = new EdificioIndustrial(unaPosicion);
		this.construir(unIndustrial);
		
		return unIndustrial;
	}
	
	public PozoDeAgua construirPozoDeAgua(Posicion unaPosicion){
		PozoDeAgua unPozo = new PozoDeAgua(unaPosicion);
		this.construir(unPozo);
		
		return unPozo;
	}
	
	public CentralEolica construirCentralEolica(Posicion unaPosicion){
		CentralEolica unaCentralEolica = new CentralEolica(unaPosicion);
		this.construir(unaCentralEolica);
		
		return unaCentralEolica;
	}
	
	public CentralMineral construirCentralMineral(Posicion unaPosicion){
		CentralMineral unaCentralMineral = new CentralMineral(unaPosicion);
		this.construir(unaCentralMineral);
		
		return unaCentralMineral;
	}
	
	public CentralNuclear construirCentralNuclear(Posicion unaPosicion){
		CentralNuclear unaCentralNuclear = new CentralNuclear(unaPosicion);
		this.construir(unaCentralNuclear);
		
		return unaCentralNuclear;
	}
	
	public RutaPavimentada construirRuta(Posicion unaPosicion){
		RutaPavimentada unaRuta = new RutaPavimentada(unaPosicion);
		this.construir(unaRuta);
		
		return unaRuta;
	}

	@Override
	public LineasDeTension construirLineaDeTension(Posicion unaPosicion) {
		LineasDeTension unaLineaDeTension = new LineasDeTension(unaPosicion);
		this.construir(unaLineaDeTension);
		// TODO Auto-generated method stub
		return unaLineaDeTension;
	}

	@Override
	public ConexionDeAgua construirTuberia(Posicion unaPosicion) {
		// TODO Auto-generated method stub
		return null;
	}

	// Hay que cambiar los constructores de LineaDeTension y TuberiaDeAgua, solo deben recibir la posicion!! (mirar abajo)
/**
	public LineasDeTension construirLineaDeTension(Posicion unaPosicion){
		LineasDeTension unaLinea = new LineasDeTension(unaPosicion);
		this.construir(unaLinea);
		
		return unaLinea;
	}
	
	public ConexionDeAgua construirTuberia(Posicion unaPosicion){
		ConexionDeAgua unaConexion = new ConexionDeAgua(unaPosicion);
		this.construir(unaConexion);
		
		return unaConexion;
	}
**/
}