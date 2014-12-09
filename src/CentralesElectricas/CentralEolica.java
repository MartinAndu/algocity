package CentralesElectricas;

import java.awt.image.BufferedImage;

import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeCentralEolica;

public class CentralEolica extends CentralElectrica {
	static int COSTO_DE_CONSTRUCCION = 1000;
	static int RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS = 4;
	static int CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO = 100;

	public CentralEolica(Posicion unaPosicion) {
		super(unaPosicion);
		this.radioDeAbastecimientoEnHectareas = RADIO_DE_ABASTECIMIENTO_EN_HECTAREAS;
		this.costoConstruccion = COSTO_DE_CONSTRUCCION;
		this.capacidadMaxDeAbastecimientoEnMW = CAPACIDAD_MAXIMA_DE_ABASTECIMIENTO;
		this.puntosConstruccion = new PuntosDeCentralEolica();
	}

	public BufferedImage graficar() {
		return Imagen.loadImg("Images/Walls/CentralEolica.png");
	}	
	

}
