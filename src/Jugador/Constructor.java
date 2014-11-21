package Jugador;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Edificios.Construccion;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionDineroInsuficiente;

public class Constructor {
	//Constructor deberia ser una clase abstracta. Se trata de un FACTORY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	Presupuesto miPresupuesto = new PresupuestoAlto(); 	// lo recibe por parametro cuando se construye
	private void construir(Construccion unaConstruccion, Posicion unaPosicion){
		
		int costoDeConstruccion = unaConstruccion.devolverCosto();
		
		if (!miPresupuesto.alcanzaPara(costoDeConstruccion)){
			throw new ExcepcionDineroInsuficiente();
		}
		
		unaConstruccion.establecerPosicion(unaPosicion);
		
		miPresupuesto.reducirPresupuesto(costoDeConstruccion);
	}
	
	public EdificioResidencial construirZonaResidencial(Posicion unaPosicion){
		EdificioResidencial unResidencial = new EdificioResidencial();
		this.construir(unResidencial, unaPosicion);
		
		return unResidencial;
	}
	
	public EdificioComercial construirZonaComercial(Posicion unaPosicion){
		EdificioComercial unComercial = new EdificioComercial();
		this.construir(unComercial, unaPosicion);
		
		return unComercial;
	}
	
	public EdificioIndustrial construirZonaIndustrial(Posicion unaPosicion){
		EdificioIndustrial unIndustrial = new EdificioIndustrial();
		this.construir(unIndustrial, unaPosicion);
		
		return unIndustrial;
	}
	
	public PozoDeAgua construirPozoDeAgua(Posicion unaPosicion){
		PozoDeAgua unPozo = new PozoDeAgua();
		this.construir(unPozo, unaPosicion);
		
		return unPozo;
	}
	
	public CentralEolica construirCentralEolica(Posicion unaPosicion){
		CentralEolica unaCentralEolica = new CentralEolica();
		this.construir(unaCentralEolica, unaPosicion);
		
		return unaCentralEolica;
	}
	
	public CentralMineral construirCentralMineral(Posicion unaPosicion){
		CentralMineral unaCentralMineral = new CentralMineral();
		this.construir(unaCentralMineral, unaPosicion);
		
		return unaCentralMineral;
	}
	
	public CentralNuclear construirCentralNuclear(Posicion unaPosicion){
		CentralNuclear unaCentralNuclear = new CentralNuclear();
		this.construir(unaCentralNuclear, unaPosicion);
		
		return unaCentralNuclear;
	}
	
	public RutaPavimentada construirRuta(Posicion unaPosicion){
		RutaPavimentada unaRuta = new RutaPavimentada();
		this.construir(unaRuta, unaPosicion);
		
		return unaRuta;
	}
	
	public LineasDeTension construirLinea(Posicion unaPosicion){
		
		// para crear una nueva linea de tension tengo que mandarle la central, que onda!?
		return null;
	}
	
	public ConexionDeAgua construirTuberia(Posicion unaPosicion){
		
		// para crear una nueva tuberia de agua tengo que mandarle la hectarea, que onda!? x2
		return null;
	}
	
	public void habilitarEstacionDeBomberos(){
		// implementar (...)
	}

}