package Edificios;

public class EdificioIndustrial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 10;
	static int CONSUMO_ELECTRICO = 5;
	static int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 3;
	protected int cantidadEmpleados;
	
	public EdificioIndustrial(Posicion unaPosicion){
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
		costoDeConstruccion = COSTO_CONSTRUCCION;
		cantidadEmpleados = 0;
		posicionConstruccion = unaPosicion;
		porcentajeDeConstruccion=100;
		
		puntosMaximosDeConstruccion=34000;
		puntosDeConstruccion=puntosMaximosDeConstruccion;
	}
	
	public int devolverCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}
	
	public int devolverCantidadEmpleados(){
		return cantidadEmpleados;
	}
	
}
