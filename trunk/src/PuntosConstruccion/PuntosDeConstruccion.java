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
		this.puntos=Math.max(puntos - (int) (porcentajeFloat * this.puntos), 0);
	}
	
	public void incrementar(int puntos) throws ExceptionConstruccionComplemtamenteReparada {
		
		if ((puntos + this.puntos) >= this.maxPuntos) {
			this.puntos = this.maxPuntos;
			throw new ExceptionConstruccionComplemtamenteReparada();
		}
		this.puntos += puntos;
	}
}
