package Edificios;

public class EdificioResidencial extends Edificio {

	static int COSTO = 5;
	static int CONSUMO_ELECTRICO = 1;
	static int CAPACIDAD_MAXIMA_HABITANTES = 100;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 10;
	protected int cantidadHabitantes;

	
	public EdificioResidencial(Posicion unaPosicion){
		super(unaPosicion);
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
		cantidadHabitantes = 0;
		posicionConstruccion = unaPosicion;

		porcentajeDeConstruccion=100;
		
		puntosMaximosDeConstruccion=10000;
		puntosDeConstruccion=puntosMaximosDeConstruccion;
	}
	

	
	public int devolverCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}
	
	public int devolverCantidadHabitantes(){
		return cantidadHabitantes;
	}
	
}
