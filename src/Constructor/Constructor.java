package Constructor;

import CentralesElectricas.CentralEolica;

import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import ConstruccionGeneral.Posicion;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;


public abstract class Constructor {
	
	public abstract EdificioResidencial construirResidencia(Posicion unaPosicion);

	public abstract EdificioComercial construirComercio(Posicion unaPosicion);
	
	public abstract EdificioIndustrial construirIndustria(Posicion unaPosicion);
	
	public abstract PozoDeAgua construirPozoDeAgua(Posicion unaPosicion);
	
	public abstract CentralEolica construirCentralEolica(Posicion unaPosicion);
	
	public abstract CentralMineral construirCentralMineral(Posicion unaPosicion);
	
	public abstract CentralNuclear construirCentralNuclear(Posicion unaPosicion);
	
	public abstract RutaPavimentada construirRuta(Posicion unaPosicion);
	
	public abstract LineasDeTension construirLineaDeTension(Posicion unaPosicion);
	
	public abstract ConexionDeAgua construirTuberia(Posicion unaPosicion);


}
