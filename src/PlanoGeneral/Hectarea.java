package PlanoGeneral;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import CentralesElectricas.CentralElectrica;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Destruible;
import ConstruccionGeneral.Reconstruible;
import Edificios.Edificio;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Superficies.Superficie;
import Superficies.SuperficieConAgua;
import Superficies.SuperficieConTerrenoLlano;

public class Hectarea implements Destruible {
	public String identi;
	protected Superficie superficie;
	protected Construccion construccion;
	protected ConexionDeAgua canio;
	protected RutaPavimentada ruta;
	protected LineasDeTension linea;
	protected boolean poseePozoDeAgua;
	protected boolean poseeCentralElectrica;
	private boolean servicioAgua;
	private boolean servicioElectrico;
	private boolean accesoAlTransito;
	
	public Hectarea(Superficie superficie){
		this.construccion = null;
		this.identi = java.util.UUID.randomUUID().toString(); 
		this.superficie = superficie;
		this.canio = null;
		this.linea = null;

		poseePozoDeAgua=false;
		poseeCentralElectrica=false;
	}
	
    @Override
    public boolean equals (Object o) {
        Hectarea x = (Hectarea) o;
        return (x.identi == identi);
    }
	
    public void habilitarServicio(String servicio){
    	if (servicio=="agua"){
    		this.servicioAgua=true;
    	}
    	if (servicio=="electricidad"){
    		this.servicioElectrico=true;
    	}
    	if (servicio=="transito"){
    		this.accesoAlTransito=true;
    	}
    
    }
    
	/*public void habilitarElectricidad(){
		this.servicioElectrico = true;
	}
		
	public void habilitarAgua(){
		this.servicioAgua = true;
	}
	
	public void habilitarAccesoAlTransito(){
		this.accesoAlTransito = true;
	}*/
	
	public boolean poseeCentralElectrica(){
		return poseeCentralElectrica;
	}
	
	public boolean poseeServicioDeAgua(){
		return this.servicioAgua;
	}
	
	public boolean poseeServicioElectrico(){
		return this.servicioElectrico;
	}
	
	public boolean poseeLosTresServicios(){
		return ((servicioAgua && servicioElectrico) && accesoAlTransito);
	}
	
	public boolean poseeConstruccion(){
		return (construccion != null);
	}
	
	public ConexionDeAgua obtenerCanio() {
		return canio;
	}
	
	public boolean tieneConexionElectrica() {
		return (!(linea== null));
	}
	
	public LineasDeTension obtenerLineaDeTension(){
		return linea;
	}
	
	public boolean tieneConexionDeAgua() {
		return (!(canio== null));
	}
	

	public void establecerEdificio(Edificio unEdificio){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!(this.superficie).sePuedeConstruirUnPozoDeAgua()){
			//throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();//lo deshabilito para probar sin tener en cuenta los terrenos

		}
		this.construccion = unEdificio;
		unEdificio.habilitarAccesoAlTransito();
		unEdificio.habilitarAgua();
		unEdificio.habilitarElectricidad();
	}
	

	public boolean poseePozoDeAgua(){
		return poseePozoDeAgua;
	}
	
	public CentralElectrica obtenerCentral(){
		return (CentralElectrica) construccion;
	}
	
	public void establecerPozoDeAgua(PozoDeAgua unPozoDeAgua){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		if(!(this.superficie).sePuedeConstruirUnPozoDeAgua()){
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
		
		this.construccion = unPozoDeAgua;
		poseePozoDeAgua=true;
		
	}
	
	public void establecerCentral(CentralElectrica unaCentral){
		if(this.poseeConstruccion())
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		
		this.construccion = unaCentral;
		poseeCentralElectrica = true;
		
	}

	
	public void establecerConexionElectrica(LineasDeTension unaConexion){
		
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		
		this.linea = unaConexion;	
	}
	
	public void establecerConexionDeAgua(ConexionDeAgua unaConexion){
		

			canio=unaConexion;
			servicioAgua=canio.conectadoALaRed(this);
		
	}

	public void establecerCalle(RutaPavimentada rutaPavimentada) {
		
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		ruta=rutaPavimentada;
	}

	@Override
	public void destruir() {		
		try {
			this.construccion.destruir();
		} catch (Exception e) {}
		
		try {
			canio.destruir();
		} catch (Exception e) {}
		
		try {
			linea.destruir();
		} catch (Exception e) {}
		
		try {
			ruta.destruir();
		} catch (Exception e) {}
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		try {
			this.construccion.destruirEnPorcentaje(porcentaje);
		} catch (NullPointerException e) {}
		
		try {
			canio.destruirEnPorcentaje(porcentaje);
		} catch (NullPointerException e) {}
		
		try {
			linea.destruirEnPorcentaje(porcentaje);
		} catch (NullPointerException e) {}
		
		try {
			ruta.destruirEnPorcentaje(porcentaje);
		} catch (NullPointerException e) {}		
	}
	
	public ArrayList<Reconstruible> devolverListaDeReconstruibles() {
		ArrayList<Reconstruible> reconstruilbles = new ArrayList<Reconstruible>();
		
		if (canio != null) {
			reconstruilbles.add(canio);
		}
		
		if (linea != null) {
			reconstruilbles.add(linea);
		}
		
		if (ruta != null) {
			reconstruilbles.add(ruta);
		}
		
		if (construccion != null) {
			reconstruilbles.add(construccion);
		}
		return reconstruilbles;
	}

	public Node serializar(Document doc, String posicionEnString) {
		Element elementoHectarea = doc.createElement("Hectarea");
		
		elementoHectarea.setAttribute("posicion", posicionEnString);
		elementoHectarea.setAttribute("tienePozo", Boolean.toString(this.poseePozoDeAgua));
		elementoHectarea.setAttribute("tieneCentralElectrica", Boolean.toString(this.poseeCentralElectrica));
		elementoHectarea.setAttribute("tieneServicioElectrico", Boolean.toString(this.servicioElectrico));
		elementoHectarea.setAttribute("tieneServicioAgua", Boolean.toString(this.servicioAgua));
		elementoHectarea.setAttribute("tieneAccesoTransito", Boolean.toString(this.accesoAlTransito));
		
		String tipoSuperficie = "tierra";
		if(this.superficie.sePuedeConstruirUnPozoDeAgua()){
			tipoSuperficie = "agua";
		}
		
		elementoHectarea.setAttribute("tipoSuperficie", tipoSuperficie);
		
		
		if (ruta != null){
			elementoHectarea.appendChild(this.ruta.serializar(doc));
		}
		
		if (construccion != null){
			elementoHectarea.appendChild(this.construccion.serializar(doc));
		}
		if (canio != null){
			elementoHectarea.appendChild(this.canio.serializar(doc));
		}
		if (linea != null){
			elementoHectarea.appendChild(this.linea.serializar(doc));
		}

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
		
		hectareaNueva.poseePozoDeAgua = Boolean.parseBoolean(elementoHectarea.getAttribute("tienePozo"));
		hectareaNueva.poseeCentralElectrica = Boolean.parseBoolean(elementoHectarea.getAttribute("tieneCentralElectrica"));
		hectareaNueva.servicioAgua = Boolean.parseBoolean(elementoHectarea.getAttribute("tieneServicioAgua"));
		hectareaNueva.accesoAlTransito = Boolean.parseBoolean(elementoHectarea.getAttribute("tieneAccesoTransito"));
		hectareaNueva.servicioElectrico = Boolean.parseBoolean(elementoHectarea.getAttribute("tieneServicioElectrico"));
		
		Construccion construccion1 = null;
		Construccion construccion2 = null;
		
		try{
			construccion1 = Construccion.hidratar(elementoHectarea.getChildNodes().item(0));
		}
		catch(NullPointerException e){
			construccion1 = null;
		}
		
		try{
			construccion2 = Construccion.hidratar(elementoHectarea.getChildNodes().item(1));
		}
		catch(NullPointerException e){
			construccion2 = null;
		}
		
		hectareaNueva.construccion = construccion1;
		hectareaNueva.canio = (ConexionDeAgua) construccion2;

		return hectareaNueva;
	}
	
	public Superficie obtenerSuperficie(){
		return this.superficie;
	}
}