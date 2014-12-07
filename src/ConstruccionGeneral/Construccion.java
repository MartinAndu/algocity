package ConstruccionGeneral;

import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import CentralesElectricas.CentralEolica;
import CentralesElectricas.CentralMineral;
import CentralesElectricas.CentralNuclear;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Edificios.EdificioComercial;
import Edificios.EdificioIndustrial;
import Edificios.EdificioResidencial;
import Edificios.PozoDeAgua;
import Estados.EstadoConstruccion;
import Estados.EstoyBien;
import PlanoGeneral.Plano;
import PuntosConstruccion.PuntosDeConstruccion;
import Servicios.AdministradorServicios;
import Superficies.Superficie;


public abstract class Construccion implements Reconstruible, Destruible {

	protected Posicion posicionConstruccion;
	protected int costoDeConstruccion;
	protected PuntosDeConstruccion puntosDeConstruccion;
	protected String idConstruccion;
	protected EstadoConstruccion estadoConstruccion;
	
	public Construccion(Posicion posicion) {
		this.posicionConstruccion = posicion;
		this.estadoConstruccion = new EstoyBien();
	}

    public Element serializar(Document doc) {
        Element elementoConstruccion = doc.createElement("Construccion");
        String nombreConstruccion = (this.getClass()).getSimpleName();
        
        elementoConstruccion.setAttribute("nombre", nombreConstruccion);        
        elementoConstruccion.setAttribute("coordenadaX", Integer.toString((this.posicionConstruccion).devolverCoordenadaX()));
        elementoConstruccion.setAttribute("coordenadaY", Integer.toString((this.posicionConstruccion).devolverCoordenadaY()));
       
        return elementoConstruccion;
    }
 
    public static Construccion hidratar(Node elementoConstruccion) {
    	
    	String nombreConstruccion = ((Element) elementoConstruccion).getAttribute("nombre");
    	int coordenadaX = Integer.parseInt(((Element) elementoConstruccion).getAttribute("coordenadaX"));
    	int coordenadaY = Integer.parseInt(((Element) elementoConstruccion).getAttribute("coordenadaY"));
    	
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
    	
	public int devolverCosto(){
		return costoDeConstruccion;
	}

	public Posicion obtenerPosicion(){
		return posicionConstruccion;
	}

	public String devolverPosicionEnString() {
		return (posicionConstruccion.enString());
	}
	
	public String idConstruccion() {
		return this.idConstruccion;
	}
	
	public EstadoConstruccion estadoContruccion() {
		return this.estadoConstruccion;
	}

	public abstract void construirseSobre(Superficie superficie);

	public abstract void construirJuntoA(Construccion construccionAAgregar);

	public abstract void verificarServicios(AdministradorServicios administradorServicios);
	
	public abstract void construirSobrePlano(Plano plano);

	

	public abstract void quitarDelPlano();
}
