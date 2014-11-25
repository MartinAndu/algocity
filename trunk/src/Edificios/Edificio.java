package Edificios;

import Excepciones.ExcepcionHectareaNoHabilitadaParaConstruirEdificio;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;

public class Edificio extends Construccion implements Reconstruible, Destruible {
	
	protected boolean tieneElectricidad;
	protected boolean tieneAgua;
	protected boolean tieneAccesoAlTransito;
	protected int consumoElectrico;
	protected float puntosMaximosDeConstruccion;
	protected float puntosDeConstruccion;
	protected float porcentajeDeConstruccion;

	
	
	
	public Edificio(Posicion posicion) {
		super(posicion);
		
		porcentajeDeConstruccion = 100;
		
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
    	if ((!unaHectarea.poseeLos3Servicios()) || (unaHectarea.poseeConstruccion())){
    		throw new ExcepcionHectareaNoHabilitadaParaConstruirEdificio();
    	}
    }

	public boolean esConstruibleSobreTierra(){
		return true;
	}
	
	public boolean esConstruibleSobreAgua(){
		return false;
	}


	
	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerEdificio(this);
	}

	public void reconstruir(int puntosDeReconstruccion){
		this.actualizarPuntosDeConstruccion();
		puntosDeConstruccion=Math.min(puntosDeConstruccion+puntosDeReconstruccion,puntosMaximosDeConstruccion);
	}
	
	public void destruirUnPoco(){ //Este es un metodo temporal para probar las clases de bomberos y reconstruibles, luego sera borrada cuando se implemente Destruible
		porcentajeDeConstruccion=81;
		actualizarPuntosDeConstruccion();
	}
	
	public float porcentajeDeConstruccion(){
		porcentajeDeConstruccion=(puntosDeConstruccion*100)/puntosMaximosDeConstruccion;
		
		return Math.round(porcentajeDeConstruccion);
	}
	
	public void actualizarPuntosDeConstruccion(){
		puntosDeConstruccion=(puntosMaximosDeConstruccion*porcentajeDeConstruccion)/100;
	}
}
