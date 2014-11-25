package Edificios;

import PlanoGeneral.Plano;


public abstract class Construccion implements Reconstruible {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;
	int porcentajeDeConstruccion;
	int puntosDeConstruccion;
	int puntosMaximosDeConstruccion;

	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
	}
	public abstract int devolverConsumo();
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public void reconstruir(int puntosDeReconstruccion){
		this.actualizarPuntosDeConstruccion();
		puntosDeConstruccion=Math.min(puntosDeConstruccion+puntosDeReconstruccion,puntosMaximosDeConstruccion);
	}
	
	public void destruirUnPoco(){ //Este es un metodo temporal para probar las clases de bomberos y reconstruibles, luego sera borrada cuando se implemente Destruible
		porcentajeDeConstruccion=81;
		actualizarPuntosDeConstruccion();
	}
	
	public float porcentajeDeConstruccion(){
		porcentajeDeConstruccion=(puntosDeConstruccion*100)/puntosMaximosDeConstruccion;
		
		return Math.round(porcentajeDeConstruccion);
	}
	
	public void actualizarPuntosDeConstruccion(){
		puntosDeConstruccion=(puntosMaximosDeConstruccion*porcentajeDeConstruccion)/100;
	}
	
	
	
	public void recibirDanio(int danioAInflingir){
		this.danio = Math.min(danio+danioAInflingir, 200);
		
		
	}
	
	public int devolverDanioRecibido(){
		return danio;
	}
	
	
	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		//Debe devolver la posicion de la construccion en formato string
		return null;
	}
	
	public abstract void construirSobrePlano(Plano plano);

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}

}
