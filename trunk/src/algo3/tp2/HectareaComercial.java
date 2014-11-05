package algo3.tp2;

public class HectareaComercial extends Hectarea {

	public int COSTO = 5;
	public int CONSUMO_ELECTRICO = 2;
	
	public HectareaComercial(Ubicacion ubicacionDada){
		costo = COSTO;
		consumo = CONSUMO_ELECTRICO;
		this.ubicacion = ubicacionDada;
	}
	
}
