package algo3.tp2;

public class Posicion {
	
	protected int coordenadaX;
	protected int coordenadaY;
	
	public Posicion(int x, int y){
		this.coordenadaX = x;
		this.coordenadaY = y;
	}
	
	public int devolverCoordenadaX(){
		return this.coordenadaX;
	}
	
	public int devolverCoordenadaY(){
		return this.coordenadaY;
	}
}