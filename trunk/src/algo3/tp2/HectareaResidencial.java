package algo3.tp2;

public class HectareaResidencial extends Hectarea {
	
	public int COSTO = 5; // Constantes en mayusculas.
	public int CONSUMO_ELECTRICO = 1;
	public int CAPACIDAD_ALOJAMIENTO = 100;
	
	public HectareaResidencial(Ubicacion ubicacionDada){
		costo = COSTO;
		consumo = CONSUMO_ELECTRICO;
		this.ubicacion = ubicacionDada;
	}
	
	public int devolverCapacidadAlojamiento(){
		return this.CAPACIDAD_ALOJAMIENTO;
	}
	

}
