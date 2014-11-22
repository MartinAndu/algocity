package Edificios;

/*
 * Lista de puntosMaximosDeConstruccion segun el tipo de construccion:
 * Edificios residenciales:10% - 10 puntos
 * Edificios comerciales:7% - 15 puntos
 * Edificios industriales:3% - 34 puntos
 * Centrales electricas eolicas:15% - 7 puntos
 * Centrales electricas minerales:10% - 10 puntos
 * Centrales electricas nucleares: 3% - 34 puntos
 * Otros: A elegir cualquiera. 
 * 
 */

public abstract class Reconstruibles implements Reconstruible {
	int puntosMaximosDeConstruccion;
	int puntosDeConstruccion;
	int porcentajeDeConstruccion;

	public void reconstruir(int puntosDeReconstruccion){
		this.actualizarPuntosDeConstruccion();
		puntosDeConstruccion=Math.min(puntosDeConstruccion+puntosDeReconstruccion,puntosMaximosDeConstruccion);
	}
	
	public int porcentajeDeConstruccion(){
		porcentajeDeConstruccion=(puntosDeConstruccion*100)/puntosMaximosDeConstruccion;
		return porcentajeDeConstruccion;
	}
	
	public void actualizarPuntosDeConstruccion(){
		puntosDeConstruccion=(puntosMaximosDeConstruccion*porcentajeDeConstruccion)/100;
	}
}
