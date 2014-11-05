package algo3.tp2;

public class HectareaIndustrial extends Hectarea {
	
	public int COSTO = 10;
	public int CONSUMO_ELECTRICO = 5;
	public int CAPACIDAD_EMPLEO = 25;
	
	public HectareaIndustrial(Ubicacion ubicacionDada){
		costo = COSTO;
		consumo = CONSUMO_ELECTRICO;
		this.ubicacion = ubicacionDada;
	}
	
	public int devolverCapacidadEmpleo(){
		return this.CAPACIDAD_EMPLEO;
	}
}
