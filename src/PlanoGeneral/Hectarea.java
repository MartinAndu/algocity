package PlanoGeneral;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import aplicacion.Archivo;
import aplicacion.Imagen;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Destruible;
import ConstruccionGeneral.Reconstruible;
import Servicios.AdministradorServicios;
import Servicios.Servicio;
import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class Hectarea implements Destruible{
	
	public String identi;
	protected Superficie superficie;
	private AdministradorServicios administradorServicios;
	private ArrayList<Construccion> construcciones;

	
	public Hectarea(Superficie superficie){
		this.identi = java.util.UUID.randomUUID().toString(); 
		this.superficie = superficie;
		this.administradorServicios = new AdministradorServicios();
		this.construcciones = new ArrayList<Construccion>();
	}
	
    @Override
    public boolean equals (Object o) {
        Hectarea x = (Hectarea) o;
        return (x.identi == identi);
    }
 
    public AdministradorServicios serviciosAConsumir() {
    	return this.administradorServicios;
    }
    
    public void agregarServicioAProveer(Servicio servicio) {
    	this.administradorServicios.agregarServicio(servicio);
    	this.verificarServiciosEnConstrucciones();
    }
    
    public void quitarServicioAProveer(Servicio servicio) {
    	this.administradorServicios.quitarServicio(servicio);
    	this.verificarServiciosEnConstrucciones();
    }
    
    private void verificarServiciosEnConstrucciones() {
    	if (!this.administradorServicios.huboUnCambio()) {
			return;
		}
    	Iterator<Construccion> it = this.construcciones.iterator();
    	
    	while (it.hasNext()) {
			Construccion construccion = (Construccion) it.next();
			construccion.verificarServicios(this.administradorServicios);
		}
    }
    
    public void agregarConstruccion(Construccion construccionAAgregar) {
    	construccionAAgregar.verificarSuperficie(this.superficie);
    	
    	if (this.construcciones.size() == 0) {
			this.construcciones.add(construccionAAgregar);
			return;
		}
    	
    	Iterator<Construccion> it = this.construcciones.iterator();
    	
    	while (it.hasNext()) {
			Construccion construccion = (Construccion) it.next();
			construccion.verificarAfinidadConConstruccion(construccionAAgregar);
		}
    	
    	this.construcciones.add(construccionAAgregar); 	
    }
    
    public Construccion quitarConstruccion() {
    	try {
    		Construccion construccion = this.construcciones.get(0);
			this.construcciones.remove(0);
			return construccion;
		} catch (Exception e) {
		}
		return null;
    }
    
	@Override
	public void destruir() {
		Iterator<Construccion> it = this.construcciones.iterator();
    	
    	while (it.hasNext()) {
			Construccion construccion = (Construccion) it.next();
			construccion.destruir();
		}
	}

	@Override
	public void destruirEnUnPorcentaje(int porcentaje) {
		Iterator<Construccion> it = this.construcciones.iterator();
    	
    	while (it.hasNext()) {
			Construccion construccion = (Construccion) it.next();
			construccion.destruirEnUnPorcentaje(porcentaje);
		}
	}
	
	public Collection<? extends Reconstruible> darListaDeReconstruibles() {
		return this.construcciones;
	}

	public Node serializar(Document doc, String posicionEnString) {
		Element elementoHectarea = doc.createElement("Hectarea");
		
		elementoHectarea.setAttribute("posicion", posicionEnString);
		elementoHectarea.setAttribute("identidad", this.identi);
		
		elementoHectarea.appendChild((this.administradorServicios).serializar(doc));
		
		for (Construccion construccion : this.construcciones) {
			elementoHectarea.appendChild(construccion.serializar(doc));
		}
		
		String tipoSuperficie = "tierra";
		if(this.superficie.sePuedeConstruirUnPozoDeAgua()){
			tipoSuperficie = "agua";
		}
		
		elementoHectarea.setAttribute("tipoSuperficie", tipoSuperficie);

		return elementoHectarea;
	}

	public static Hectarea hidratar(Element elementoHectarea) {
		String tipoSuperficie = elementoHectarea.getAttribute("tipoSuperficie");
		
		Superficie superficieNueva = null;
		if(tipoSuperficie.equals("tierra")){
			superficieNueva = new SuperficieConTerrenoLlano();
		}
		else{
			superficieNueva = new SuperficieConAgua();
		}
		
		Hectarea hectareaNueva = new Hectarea(superficieNueva);
		
		hectareaNueva.identi = elementoHectarea.getAttribute("identidad");
		
		AdministradorServicios administradorDeServiciosHidratado = AdministradorServicios.hidratar(elementoHectarea.getChildNodes().item(0));
		
		ArrayList<Construccion> construccionesHidratadas = new ArrayList<Construccion>();

		for(int i = 1 ; i < (elementoHectarea.getChildNodes().getLength()) ; i++) {
			Construccion construccionHidratada = Construccion.hidratar(elementoHectarea.getChildNodes().item(i));
			construccionesHidratadas.add(construccionHidratada);
		}
		
		hectareaNueva.construcciones = construccionesHidratadas;
		hectareaNueva.administradorServicios = administradorDeServiciosHidratado;
		return hectareaNueva;
	}

	public Superficie darSuperficie() {
		return this.superficie;
	}

	
	public void GraficarHectarea(Graphics g,boolean vistaSubterranea){
		if (construcciones.size() > 0){
			Iterator<Construccion> it = this.construcciones.iterator();
	    	
	    	while (it.hasNext()) {
				Construccion construccion = (Construccion) it.next();
				g.drawImage(construccion.graficar(), 0, 0, null);
				if (vistaSubterranea && !construccion.esConstruibleBajoTierra())
					g.drawImage(Imagen.loadImg(Archivo.SuperficieSubterranea), 0, 0, null);
			}
		}
		else{
			if (vistaSubterranea)
				g.drawImage(Imagen.loadImg(Archivo.SuperficieSubterranea), 0, 0, null);
			else
				g.drawImage(this.superficie.graficar(), 0, 0, null);
		}
	}

}