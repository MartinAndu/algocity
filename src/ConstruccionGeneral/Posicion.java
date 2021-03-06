package ConstruccionGeneral;

public class Posicion { 
	// Cada hectarea va a tener su ubicacion en la "cuadrilla" con sus respectivas coordenadas.
    private int coordenadaX;
    private int coordenadaY;
   
    public Posicion(int x, int y){
            this.coordenadaX = x;
            this.coordenadaY = y;
    }
   
    public int darCoordenadaX(){
            return this.coordenadaX;
    }
   
    public int darCoordenadaY(){
            return this.coordenadaY;
    }

	public String enString() {
		String xEnString = Integer.toString(this.coordenadaX);
		String yEnString = Integer.toString(this.coordenadaY);
		
		return (xEnString.concat("x")).concat(yEnString);
	}
}
