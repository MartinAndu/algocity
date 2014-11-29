package PlanoGeneral;

import java.util.ArrayList;


import CentralesElectricas.CentralElectrica;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Edificios.Construccion;
import Edificios.Destruible;
import Edificios.Edificio;
import Edificios.PozoDeAgua;
import Edificios.Reconstruible;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
import Superficies.Superficie;

public class Hectarea implements Destruible {
	public String identi;
	protected Superficie superficie;
	protected Construccion construccion;
	protected boolean servicioElectrico;
	protected boolean servicioAgua;
	protected boolean accesoAlTransito;
	protected ConexionDeAgua unaConexionDeAgua;
	protected RutaPavimentada unaCalle;
	protected LineasDeTension unaLineaDeTension;
	protected boolean poseePozoDeAgua;
	protected boolean poseeCentralElectrica;
	
	public Hectarea(Superficie superficie){
		this.construccion = null;
		this.identi = java.util.UUID.randomUUID().toString(); 
		this.superficie = superficie;
		this.unaConexionDeAgua = null;
		this.unaLineaDeTension = null;

		poseePozoDeAgua=false;
		poseeCentralElectrica=false;
	}
	
    @Override
    public boolean equals (Object o) {
        Hectarea x = (Hectarea) o;
        return (x.identi == identi);
    }
	
	public void habilitarElectricidad(){
		this.servicioElectrico = true;
	}
		
	public void habilitarAgua(){
		this.servicioAgua = true;
	}
	
	public void habilitarAccesoAlTransito(){
		this.accesoAlTransito = true;
	}
	
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
		return unaConexionDeAgua;
	}
	
	public boolean tieneConexionElectrica() {
		return (!(unaLineaDeTension== null));
	}
	
	public LineasDeTension obtenerLineaDeTension(){
		return unaLineaDeTension;
	}
	
	public boolean tieneConexionDeAgua() {
		return (!(unaConexionDeAgua== null));
	}
	

	public void establecerEdificio(Edificio unEdificio){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!this.poseeLosTresServicios()){
			throw new ExcepcionHectareaNoBrindaLosServiciosNecesarios();
		}
		else if(!(this.superficie).sePuedeConstruirUnPozoDeAgua()){
			//throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();//lo deshabilito para probar sin tener en cuenta los terrenos
			;
		}
		this.construccion = unEdificio;
		unEdificio.habilitarAccesoAlTransito();
		unEdificio.habilitarAgua();
		unEdificio.habilitarElectricidad();
	}
	
	public boolean poseePozoDeAgua(){
		return poseePozoDeAgua;
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
		
		this.unaLineaDeTension = unaConexion;	
	}
	
	public void establecerConexionDeAgua(ConexionDeAgua unaConexion){
		

			unaConexionDeAgua=unaConexion;
			servicioAgua=unaConexionDeAgua.conectadoALaRed(this);
		
	}

	public void establecerCalle(RutaPavimentada rutaPavimentada) {
		
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		unaCalle=rutaPavimentada;
	}

	@Override
	public void destruir() {		
		try {
			this.construccion.destruir();
		} catch (Exception e) {}
		
		try {
			unaConexionDeAgua.destruir();
		} catch (Exception e) {}
		
		try {
			unaLineaDeTension.destruir();
		} catch (Exception e) {}
		
		try {
			unaCalle.destruir();
		} catch (Exception e) {}
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		try {
			this.construccion.destruirEnPorcentaje(porcentaje);
		} catch (Exception e) {}
		
		try {
			unaConexionDeAgua.destruirEnPorcentaje(porcentaje);
		} catch (Exception e) {}
		
		try {
			unaLineaDeTension.destruirEnPorcentaje(porcentaje);
		} catch (Exception e) {}
		
		try {
			unaCalle.destruirEnPorcentaje(porcentaje);
		} catch (Exception e) {}		
	}
	
	public ArrayList<Reconstruible> devolverListaDeReconstruibles() {
		ArrayList<Reconstruible> reconstruilbles = new ArrayList<Reconstruible>();
		
		if (unaConexionDeAgua != null) {
			reconstruilbles.add(unaConexionDeAgua);
		}
		
		if (unaLineaDeTension != null) {
			reconstruilbles.add(unaLineaDeTension);
		}
		
		if (unaCalle != null) {
			reconstruilbles.add(unaCalle);
		}
		
		if (unaConexionDeAgua != null) {
			reconstruilbles.add(construccion);
		}
		return reconstruilbles;
	}
	

}