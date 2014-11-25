package Edificios;

public class EdificioComercial extends Edificio {
	
	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 2;
	static int PUNTOS_MAXIMOS_DE_CONSTRUCCION = 14285;
	
	public EdificioComercial(Posicion unaPosicion){
		super(unaPosicion);
		
		costoDeConstruccion = COSTO_CONSTRUCCION;
		consumoElectrico = CONSUMO_ELECTRICO;
		
		puntosMaximosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
		puntosDeConstruccion = PUNTOS_MAXIMOS_DE_CONSTRUCCION;
	}
}