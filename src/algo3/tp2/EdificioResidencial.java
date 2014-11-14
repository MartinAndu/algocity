package algo3.tp2;

public class EdificioResidencial extends Edificio {

	static int COSTO = 5;
	static int CONSUMO_ELECTRICO = 1;
	static int CAPACIDAD_MAXIMA_HABITANTES = 100;
	protected int cantidadHabitantes;
	
	public EdificioResidencial(){
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
	}
	
	public int devolverCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}
	
	public int devolverCantidadHabitantes(){
		return cantidadHabitantes;
	}
	
}
