package Superficies;

import ConstruccionGeneral.Graficable;

public abstract class Superficie implements Graficable{
	public abstract boolean sePuedeConstruirUnPozoDeAgua();
	
	public abstract boolean sePuedeConstruirUnEdificioOCentral();
	
	public abstract boolean sePuedeConstruirUnaConexion();
}
