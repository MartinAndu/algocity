package Superficies;


public class SuperficieConAgua extends Superficie {
	
	public SuperficieConAgua(){
		this.idSuperficie = "superficieConAgua";
	}
	
	
	public boolean sePuedeConstruirUnPozoDeAgua(){
		return true;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return false;
	}

	@Override
	public boolean sePuedeConstruirUnaConexion() {
		return true;
	}


}
