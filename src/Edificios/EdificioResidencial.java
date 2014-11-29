package Edificios;

import PuntosConstruccion.PuntosDeResidencia;

public class EdificioResidencial extends Edificio {

	static int COSTO_CONSTRUCCION = 5;
	static int CONSUMO_ELECTRICO = 1;
	static int CAPACIDAD_MAXIMA_HABITANTES = 100;

	public EdificioResidencial(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosDeConstruccion = new PuntosDeResidencia();
		
	}

	public int devolverCapacidadAlojamiento(){
		return CAPACIDAD_MAXIMA_HABITANTES;
	}
	
}