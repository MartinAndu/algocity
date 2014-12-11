package Edificios;

import java.awt.image.BufferedImage;

import aplicacion.Archivo;
import aplicacion.Imagen;
import ConstruccionGeneral.Posicion;
import PuntosConstruccion.PuntosDeIndustria;
import Servicios.AdministradorServicios;

public class EdificioIndustrial extends Edificio {
	
	static final int COSTO_CONSTRUCCION = 10;
	static final int CONSUMO_ELECTRICO = 5;
	static final int CAPACIDAD_MAXIMA_EMPLEADOS = 25;
	
	public EdificioIndustrial(Posicion unaPosicion){
		super(unaPosicion);
		costoConstruccion = COSTO_CONSTRUCCION;
		consumoElectrico = CONSUMO_ELECTRICO;
		this.puntosConstruccion = new PuntosDeIndustria();

	}
	
	public int darCapacidadEmpleo(){
		return CAPACIDAD_MAXIMA_EMPLEADOS;
	}

	@Override
	protected boolean administradorPoseeServicioQueRequiero(
			AdministradorServicios administrador) {
		boolean poseeServicios = administrador.poseeElectricidad();
		poseeServicios &= administrador.poseeAccesoAlTransito();
		return poseeServicios;
	}
	
	public BufferedImage graficar() {
		if (estadoConstruccion.enString() == "estoy bien")
			return Imagen.loadImg(Archivo.EdificioIndustrial);
		if (estadoConstruccion.enString() == "estoy destruido")
			return Imagen.loadImg(Archivo.EdificioIndustrialDestruido);
		else
			return Imagen.loadImg(Archivo.EdificioIndustrialSinServicio);
	}
}