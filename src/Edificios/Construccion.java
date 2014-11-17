package Edificios;

import planoGeneral.Plano;


public class Construccion {
	//esta deberia ser una clase abstracta y no esta definida como tal.....porque?
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
}
