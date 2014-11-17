package Edificios;

import planoGeneral.Plano;


public abstract class Construccion {

	protected Posicion unaPosicion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public void recibirDanio(int unDanio){
		this.danio += unDanio;
	}
	
	public int devolverDanioRecibido(){
		return danio;
	}

	public String devolverPosicionEnString() {
		//Debe devolver la posicion de la construccion en formato string
		return null;
	}

	public void realizarTareasSobrePlano(Plano plano) {
		//la construccion debe saber que acciones posteriores a sus construccion realizar
	}

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

}
