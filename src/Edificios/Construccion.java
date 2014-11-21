package Edificios;

import PlanoGeneral.Plano;


public abstract class Construccion {

	protected Posicion unaPosicion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;
	
	public Construccion(Posicion posicion) {
		this.unaPosicion = posicion;
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
	
	public void establecerPosicion(Posicion unaPosicion){
		this.unaPosicion = unaPosicion;
	}
	
	public Posicion obtenerPosicion(){
		return unaPosicion;
	}

	public String devolverPosicionEnString() {
		//Debe devolver la posicion de la construccion en formato string
		return null;
	}

	public void realizarTareasSobrePlano(Plano plano) {
		//la construccion debe saber que acciones posteriores a sus construccion realizar
	}
	
	public abstract void construirSobrePlano(Plano plano); // toda construccion sabe como construirse sobre un plano

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

}
