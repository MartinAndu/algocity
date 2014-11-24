package Edificios;

import PlanoGeneral.Plano;


public abstract class Construccion {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;

	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
	}
	public abstract int devolverConsumo();
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public void recibirDanio(int unDanio){
		this.danio += unDanio;
	}
	
	public int devolverDanioRecibido(){
		return danio;
	}
	
	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		//Debe devolver la posicion de la construccion en formato string
		return null;
	}
	
	public abstract void construirSobrePlano(Plano plano);

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}

}
