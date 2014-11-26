package Edificios;

import PlanoGeneral.Plano;


public abstract class Construccion implements Reconstruible {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;
	protected float puntosMaximosDeConstruccion;
	protected float puntosDeConstruccion;
	protected float porcentajeDeConstruccion;

	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
		
		porcentajeDeConstruccion = 100;
	}
	public abstract int devolverConsumo();
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public void reconstruir(int puntosDeReconstruccion){
		this.actualizarPuntosDeConstruccion();
		puntosDeConstruccion=Math.min(puntosDeConstruccion+puntosDeReconstruccion,puntosMaximosDeConstruccion);
	}
	
	
	public float porcentajeDeConstruccion(){
		porcentajeDeConstruccion=(puntosDeConstruccion*100)/puntosMaximosDeConstruccion;
		
		return Math.round(porcentajeDeConstruccion);
	}
	
	public void actualizarPuntosDeConstruccion(){
		puntosDeConstruccion=(puntosMaximosDeConstruccion*porcentajeDeConstruccion)/100;
	}
	
	
	
	public void recibirDanio(int danioAInflingir){
		this.danio = Math.min(danio+danioAInflingir, 200);
		porcentajeDeConstruccion=(porcentajeDeConstruccion-danio/2);
		actualizarPuntosDeConstruccion();
	}
	
	
	
	public int devolverDanioRecibido(){
		return danio;
	}
	
	
	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		return (posicionConstruccion.enString());
	}
	
	public abstract void construirSobrePlano(Plano plano);

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void destruir();

}
