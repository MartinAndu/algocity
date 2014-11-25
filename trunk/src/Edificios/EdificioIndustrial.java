package Edificios;

public class EdificioIndustrial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 10;
	static int CONSUMO_ELECTRICO = 5;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 34000;
	static int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	protected int cantidadEmpleados;
	
	public EdificioIndustrial(Posicion unaPosicion){
		super(unaPosicion);
		
		costoDeConstruccion = COSTO_CONSTRUCCION;
		consumoElectrico = CONSUMO_ELECTRICO;

		puntosMaximosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
		puntosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;

		cantidadEmpleados = 0;
	}
	
	public int devolverCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}
	
	public int devolverCantidadEmpleados(){
		return cantidadEmpleados;
	}
	
}