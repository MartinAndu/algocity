package Edificios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	
	public void destruir() {
		danio = this.estadoConstruccion * 100 / 100;
	}
	
    public static EdificioResidencial hidratar(Document doc) {
    	Element elementoConstruccion = (Element)doc.getElementsByTagName("Construccion").item(0);

    	int coordenadaX = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaX"));
    	int coordenadaY = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaY"));
    	float nuevoPorcentajeDeConstruccion = Float.parseFloat((elementoConstruccion).getAttribute("porcentajeDeConstruccion"));
    	
    	Posicion nuevaPosicion = new Posicion(coordenadaX, coordenadaY);
    	
    	EdificioResidencial nuevaConstruccion = new EdificioResidencial(nuevaPosicion);
    	nuevaConstruccion.porcentajeDeConstruccion = nuevoPorcentajeDeConstruccion;
    	
    	return nuevaConstruccion;
    }
}