package algo3.tp2;

public class EdificioIndustrial extends Edificio {
	public int COSTO = 10;
	public int CONSUMO_ELECTRICO = 5;
	public int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	public int cantidadEmpleados;
	
	public EdificioIndustrial(){
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
	}
	
	public int devolverCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}
	
	public int devolverCantidadEmpleados(){
		return cantidadEmpleados;
	}
	
}
