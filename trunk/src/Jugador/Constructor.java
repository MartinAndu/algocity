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


public abstract class Constructor {

	protected Presupuesto presupuesto;

	public Constructor (Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	protected void construir(Construccion unaConstruccion){
		
		int costoDeConstruccion = unaConstruccion.devolverCosto();	
		presupuesto.reducirPresupuesto(costoDeConstruccion);
	}
	
	public abstract EdificioResidencial construirZonaResidencial(Posicion unaPosicion);

	public abstract EdificioComercial construirZonaComercial(Posicion unaPosicion);
	
	public abstract EdificioIndustrial construirZonaIndustrial(Posicion unaPosicion);
	
	public abstract PozoDeAgua construirPozoDeAgua(Posicion unaPosicion);
	
	public abstract CentralEolica construirCentralEolica(Posicion unaPosicion);
	
	public abstract CentralMineral construirCentralMineral(Posicion unaPosicion);
	
	public abstract CentralNuclear construirCentralNuclear(Posicion unaPosicion);
	
	public abstract RutaPavimentada construirRuta(Posicion unaPosicion);
	
	public abstract LineasDeTension construirLineaDeTension(Posicion unaPosicion);
	
	public abstract ConexionDeAgua construirTuberia(Posicion unaPosicion);


}
