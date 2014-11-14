package algo3.tp2;

public class Posicion {
	public int coordenadaX;
	public int coordenadaY;
	
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