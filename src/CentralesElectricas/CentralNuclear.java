package CentralesElectricas;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeCentralNuclear;

public class CentralNuclear extends CentralElectrica{
	static int COSTO_DE_CONSTRUCCION = 10000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 25;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 1000;
	
	public CentralNuclear(Posicion unaPosicion) {
		super(unaPosicion);
		this.radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		this.costoDeConstruccion = COSTO_DE_CONSTRUCCION;
		this.capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		this.puntosDeConstruccion = new PuntosDeCentralNuclear();
	
	}
	
	public BufferedImage graficar() {
		return Imagen.loadImg("Images/Walls/CentralNuclear.jpg");
	}	


}
