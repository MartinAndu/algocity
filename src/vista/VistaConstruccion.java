package vista;

import java.awt.image.BufferedImage;

import ConstruccionGeneral.Construccion;
import Estados.EstadoConstruccion;


public abstract class VistaConstruccion {
	protected EstadoConstruccion estadoConstruccion;
	protected Construccion construccion;
	
	public abstract BufferedImage obtenerRepresentacionDeLaConstruccion();
	
	public Construccion obtenerConstruccion(){
		return this.construccion;
	}
	
	public void asignarEstadoConstruccion(EstadoConstruccion estadoConstruccion){
		this.estadoConstruccion = estadoConstruccion;
	}
}
