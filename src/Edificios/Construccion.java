package Edificios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import PlanoGeneral.Plano;


public abstract class Construccion implements Reconstruible {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected int estadoConstruccion;
	protected int danio;
	protected float puntosMaximosDeConstruccion;
	protected float puntosDeConstruccion;
	protected float porcentajeDeConstruccion;

	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
		
		porcentajeDeConstruccion = 100;
	}

    public Element serializar(Document doc) {
        Element elementoConstruccion = doc.createElement("Construccion");
        String nombreConstruccion = (this.getClass()).getSimpleName();
        
        elementoConstruccion.setAttribute("nombre", nombreConstruccion);        
        elementoConstruccion.setAttribute("coordenadaX", Integer.toString((this.posicionConstruccion).devolverCoordenadaX()));
        elementoConstruccion.setAttribute("coordenadaY", Integer.toString((this.posicionConstruccion).devolverCoordenadaY()));
        elementoConstruccion.setAttribute("porcentajeDeConstruccion", Float.toString(this.porcentajeDeConstruccion()));
       
        return elementoConstruccion;
    }
 
    public static Construccion hidratar(Document doc) {
    	Element elementoConstruccion = (Element)doc.getElementsByTagName("Construccion").item(0);
    	
    	String nombreConstruccion = (elementoConstruccion).getAttribute("nombre");
    	int coordenadaX = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaX"));
    	int coordenadaY = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaY"));
    	
    	Posicion nuevaPosicion = new Posicion(coordenadaX, coordenadaY);
    	Float nuevoPorcentajeDeConstruccion = Float.parseFloat((elementoConstruccion).getAttribute("porcentajeDeConstruccion"));
   
    	Construccion nuevaConstruccion = null;
    	
    	if (nombreConstruccion.equals("EdificioComercial")){
    		nuevaConstruccion = new EdificioComercial(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("EdificioIndustrial")){
    		nuevaConstruccion = new EdificioIndustrial(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("EdificioResidencial")){
    		nuevaConstruccion = new EdificioResidencial(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("CentralEolica")){
    		nuevaConstruccion = new CentralEolica(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("CentralMineral")){
    		nuevaConstruccion = new CentralMineral(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("CentralNuclear")){
    		nuevaConstruccion = new CentralNuclear(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("ConexionDeAgua")){
    		nuevaConstruccion = new ConexionDeAgua(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("LineasDeTension")){
    		nuevaConstruccion = new LineasDeTension(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("RutaPavimentada")){
    		nuevaConstruccion = new RutaPavimentada(nuevaPosicion);
    	}
    	else if (nombreConstruccion.equals("PozoDeAgua")){
    		nuevaConstruccion = new PozoDeAgua(nuevaPosicion);
    	}
    	nuevaConstruccion.porcentajeDeConstruccion = nuevoPorcentajeDeConstruccion;
    	return nuevaConstruccion;
    }
    
	public abstract int devolverConsumo();
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}
	
	public int devolverPorcentajeDeConstruccion(){
		return (int) (porcentajeDeConstruccion);
	}
	
	public void reconstruir(int puntosDeReconstruccion){
		this.actualizarPuntosDeConstruccion();
		puntosDeConstruccion=Math.min(puntosDeConstruccion+puntosDeReconstruccion,puntosMaximosDeConstruccion);
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
		porcentajeDeConstruccion=(porcentajeDeConstruccion-danio/2);
		actualizarPuntosDeConstruccion();
	}
	
	
	
	public int devolverDanioRecibido(){
		return danio;
	}
	
	
	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		return (posicionConstruccion.enString());
	}
	
	public abstract void construirSobrePlano(Plano plano);

	public abstract boolean esConstruibleSobreAgua();

	public abstract boolean esConstruibleSobreTierra();

	
	public abstract void destruir();

}
