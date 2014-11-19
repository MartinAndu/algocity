package Jugador;

import Edificios.Edificio;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.Posicion;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionDineroInsuficiente;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class Constructor {
	 // Estas instanciaciones estan mal, son cosas que se van a obtener 
	// del Jugador que tiene el constructor, pero por ahora hago esto...
	Plano miPlano = new Plano(10,10);
	Presupuesto miPresupuesto = new PresupuestoAlto();
	
	private void construirEdificio(Edificio unEdificio){
		
		int costoDeUnEdificio = unEdificio.devolverCosto();
		
		if (!miPresupuesto.alcanzaPara(costoDeUnEdificio)){
			throw new ExcepcionDineroInsuficiente();
		}
		
		Posicion unaPosicion = unEdificio.obtenerPosicion();
		Hectarea hectareaDondeConstruir = miPlano.devolverHectarea(unaPosicion);
		(hectareaDondeConstruir).establecerEdificio(unEdificio);
		miPresupuesto.reducirPresupuesto(costoDeUnEdificio);
	}
	
	public EdificioResidencial construirZonaResidencial(Posicion unaPosicion){
		EdificioResidencial unResidencial = new EdificioResidencial();
		unResidencial.establecerPosicion(unaPosicion);
		
		this.construirEdificio(unResidencial);
		
		return unResidencial;
	}
	
	public EdificioComercial construirZonaComercial(Posicion unaPosicion){
		EdificioComercial unComercial = new EdificioComercial();
		unComercial.establecerPosicion(unaPosicion);
		
		this.construirEdificio(unComercial);
		
		return unComercial;
	}
	
	public EdificioIndustrial construirZonaIndustrial(Posicion unaPosicion){
		EdificioIndustrial unIndustrial = new EdificioIndustrial();
		unIndustrial.establecerPosicion(unaPosicion);
		
		this.construirEdificio(unIndustrial);
		
		return unIndustrial;
	}
	
	public PozoDeAgua construirPozoDeAgua(Posicion unaPosicion){
		return null;
	}	

}