package Edificios;

import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class Edificio extends Construccion implements Reconstruible, Destruible {
	
	protected boolean tieneElectricidad;
	protected boolean tieneAgua;
	protected boolean tieneAccesoAlTransito;
	protected int consumoElectrico;

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
	
    public void inspeccionarHectarea(Hectarea unaHectarea) {
        //corrobora que la hectarea contenga todos los servicios necesarios para su construccion
        //o alguna otra caracteristica que inhabilite para construir.
        //si no se puede construir se espera la siguiente excepcion
        //ExceptionHectareaNoHabilitadaParaConstruirEdificio
       
    }

	public boolean esConstruibleSobreTierra(){
		return true;
	}
	
	public boolean esConstruibleSobreAgua(){
		return false;
	}

	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
	
	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerEdificio(this);
	}

	@Override
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}

}
