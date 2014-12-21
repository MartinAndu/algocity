package Superficies;


public abstract class Superficie{
	protected String idSuperficie;
	
	public String obtenerId(){
		return this.idSuperficie;
	}
	
	public abstract boolean sePuedeConstruirUnPozoDeAgua();
	
	public abstract boolean sePuedeConstruirUnEdificioOCentral();
	
	public abstract boolean sePuedeConstruirUnaConexion();
	
}
