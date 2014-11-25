package Edificios;

public class EdificioResidencial extends Edificio {

	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 1;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 10000;
	static int CAPACIDAD_MAXIMA_HABITANTES = 100;
	protected int cantidadHabitantes;

	public EdificioResidencial(Posicion unaPosicion){
		super(unaPosicion);
		
		costoDeConstruccion = COSTO_CONSTRUCCION;
		consumoElectrico = CONSUMO_ELECTRICO;

		puntosMaximosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
		puntosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;

		cantidadHabitantes = 0;
	}

	public int devolverCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}
	
	public int devolverCantidadHabitantes(){
		return cantidadHabitantes;
	}
	
}