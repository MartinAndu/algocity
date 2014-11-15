package Edificios;


public class Construccion {
	
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
}
