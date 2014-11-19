package Edificios;

public class PozoDeAgua extends Construccion{

	static int COSTO_CONSTRUCCION = 250;
	static int CONSUMO_ELECTRICO = 0;
	
	public PozoDeAgua(){
	}
	
	public boolean esConstruibleSobreTierra(){
		return false;
	}
	
	public boolean esConstruibleSobreAgua(){
		return true;
	}

	@Override
	public int devolverConsumo() {
		return CONSUMO_ELECTRICO;
	}
}
