package algo3.tp2;

public class Construccion {
	public int costoDeConstruccion;
	public int estadoConstruccion;
	public int danio;
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public void recibirDanio(int unDanio){
		this.danio += unDanio;
	}
}
