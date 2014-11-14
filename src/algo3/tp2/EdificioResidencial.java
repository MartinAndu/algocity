package algo3.tp2;

public class EdificioResidencial extends Edificio {
	
	public int COSTO = 5;
	public int CONSUMO_ELECTRICO = 1;
	public int CAPACIDAD_MAXIMA_HABITANTES = 100;
	public int cantidadHabitantes;
	
	public EdificioResidencial(){
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
	}
	
	public int devolverCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}
	
	public int devolverCantidadHabitantes(){
		return cantidadHabitantes;
	}
	
}
