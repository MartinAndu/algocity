package PuntosConstruccion;

import Excepciones.ExceptionConstruccionComplemtamenteReparada;

public class PuntosDeConstruccion {
	
	protected int puntos;
	protected int maxPuntos;
	protected int porcentajeADescontar;
	
	public void decrementar() {		
		this.decrementarEnPorcentaje(porcentajeADescontar);
	}
	
	public void decrementarEnPorcentaje(int porcentaje){
		
		float porcentajeFloat = (float) (porcentaje / 100.0);
		
		if ((porcentajeFloat * this.puntos) > this.puntos) {
			this.puntos = 0;
		}
		else {
			this.puntos -= (int) (porcentajeFloat * this.puntos);
		}
	}
	
	public void incrementar(int puntos) throws ExceptionConstruccionComplemtamenteReparada {
		
		if ((puntos + this.puntos) >= this.maxPuntos) {
			this.puntos = this.maxPuntos;
			throw new ExceptionConstruccionComplemtamenteReparada();
		}
		this.puntos += puntos;
	}
}
