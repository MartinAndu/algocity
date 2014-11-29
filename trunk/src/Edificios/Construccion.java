package Edificios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Excepciones.ExceptionConstruccionComplemtamenteReparada;
import PlanoGeneral.Plano;
import PuntosConstruccion.PuntosDeConstruccion;


public abstract class Construccion implements Reconstruible, Destruible {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected PuntosDeConstruccion puntosDeConstruccion;
	
	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
	}

    public Element serializar(Document doc) {
        Element elementoConstruccion = doc.createElement("Construccion");
        String nombreConstruccion = (this.getClass()).getSimpleName();
        
        elementoConstruccion.setAttribute("nombre", nombreConstruccion);        
        elementoConstruccion.setAttribute("coordenadaX", Integer.toString((this.posicionConstruccion).devolverCoordenadaX()));
        elementoConstruccion.setAttribute("coordenadaY", Integer.toString((this.posicionConstruccion).devolverCoordenadaY()));
       
        return elementoConstruccion;
    }
 
    public static Construccion hidratar(Document doc) {
    	Element elementoConstruccion = (Element)doc.getElementsByTagName("Construccion").item(0);
    	
    	String nombreConstruccion = (elementoConstruccion).getAttribute("nombre");
    	int coordenadaX = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaX"));
    	int coordenadaY = Integer.parseInt((elementoConstruccion).getAttribute("coordenadaY"));
    	
    	Posicion nuevaPosicion = new Posicion(coordenadaX, coordenadaY);
   
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
    	return nuevaConstruccion;
    }
    
	public abstract int devolverConsumo();
	
	public int devolverCosto(){
		return costoDeConstruccion;
	}

	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		return (posicionConstruccion.enString());
	}
	
	public abstract void construirSobrePlano(Plano plano);
	
	public void destruir() {
		this.puntosDeConstruccion.decrementar();
	}
	
	public void destruirEnPorcentaje(int porcentaje){
		this.puntosDeConstruccion.decrementarEnPorcentaje(porcentaje);
	}
	
	public void reconstruir(int puntosDeReconstruccion) throws ExceptionConstruccionComplemtamenteReparada {
		this.puntosDeConstruccion.incrementar(puntosDeReconstruccion);
	}

}
