package Edificios;

public class EdificioComercial extends Edificio {
	
	static int COSTO = 5;
	static int CONSUMO_ELECTRICO = 2;
	
	public EdificioComercial(){
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
	}

}
