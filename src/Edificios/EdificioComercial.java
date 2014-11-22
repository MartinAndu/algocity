package Edificios;

public class EdificioComercial extends Edificio {
	
	static int COSTO = 5;
	static int CONSUMO_ELECTRICO = 2;
	static int PORCENTAJE_REPARACION_POR_BOMBEROS = 7;
	
	public EdificioComercial(Posicion unaPosicion){
		costoDeConstruccion = COSTO;
		consumoElectrico = CONSUMO_ELECTRICO;
		tieneAgua = false;
		tieneElectricidad = false;
		tieneAccesoAlTransito = false;
		posicionConstruccion = unaPosicion;
		porcentajeDeConstruccion=100;
		
		puntosMaximosDeConstruccion=15000;
		puntosDeConstruccion=puntosMaximosDeConstruccion;
	}

}
