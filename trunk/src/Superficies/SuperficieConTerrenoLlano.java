package Superficies;

public class SuperficieConTerrenoLlano extends Superficie{
	
	public SuperficieConTerrenoLlano(){
		this.idSuperficie = "superficieConTerrenoLlano";
	}

	public boolean sePuedeConstruirUnPozoDeAgua(){
		return false;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return true;
	}

	@Override
	public boolean sePuedeConstruirUnaConexion() {
		return true;
	}


}
