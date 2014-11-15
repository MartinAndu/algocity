package Plano;

public class Posicion { // Cada hectarea va a tener su ubicacion en la "cuadrilla" con sus respectivas coordenadas.
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
