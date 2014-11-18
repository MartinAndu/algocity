package Edificios;



public class PozoDeAgua extends Construccion{

	static int COSTO_CONSTRUCCION = 250;
	
	public PozoDeAgua(){
	}
	
	public boolean esConstruibleSobreTierra(){
		return false;
	}
	
	public boolean esConstruibleSobreAgua(){
		return true;
	}
}
