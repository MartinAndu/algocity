package Edificios;

import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import Excepciones.ExcepcionHectareaNoHabilitadaParaConstruirEdificio;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class Edificio extends Construccion {
	
	protected boolean tieneElectricidad;
	protected boolean tieneAgua;
	protected boolean tieneAccesoAlTransito;
	protected int consumoElectrico;
	
	public Edificio(Posicion posicion) {
		super(posicion);

		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
	}
	
	public int devolverConsumo(){
		return consumoElectrico;
	}
	
	public void habilitarElectricidad(){
		this.tieneElectricidad = true;
	}
	
	public void habilitarAgua(){
		this.tieneAgua = true;
	}
	
	public void habilitarAccesoAlTransito(){
		this.tieneAccesoAlTransito = true;
	}
	
	public boolean tieneAgua(){
		return tieneAgua;
	}
	
	public boolean tieneElectricidad(){
		return tieneElectricidad;
	}
	
	public boolean tieneAccesoAlTransito(){
		return tieneAccesoAlTransito;
	}
	
    public void inspeccionarHectarea(Hectarea unaHectarea){
    	if ((!unaHectarea.poseeLosTresServicios()) || (unaHectarea.poseeConstruccion())){
    		throw new ExcepcionHectareaNoHabilitadaParaConstruirEdificio();
    	}
    }

	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		this.inspeccionarHectarea(unaHectarea);
		unaHectarea.establecerEdificio(this);
	}

}
