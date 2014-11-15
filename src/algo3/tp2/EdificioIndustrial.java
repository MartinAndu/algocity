package algo3.tp2;

public class EdificioIndustrial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 10;
	static int CONSUMO_ELECTRICO = 5;
	static int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	protected int cantidadEmpleados;
	
	public EdificioIndustrial(){
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
		cantidadEmpleados = 0;
	}
	
	public int devolverCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}
	
	public int devolverCantidadEmpleados(){
		return cantidadEmpleados;
	}
	
}
