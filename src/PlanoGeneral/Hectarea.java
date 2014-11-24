package PlanoGeneral;

import CentralesElectricas.CentralElectrica;
import Conectores.Conexion;
import Conectores.ConexionDeAgua;
import Conectores.LineasDeTension;
import Conectores.RutaPavimentada;
import Edificios.Construccion;
import Edificios.Edificio;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionCentralElectricaNoPoseeRedDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Superficies.Superficie;
import SuperficiesGeneradores.GeneradorSuperficieDeterminista;

public class Hectarea {
	public String identi;
	protected GeneradorSuperficieDeterminista generadorSuperficie;
	protected Superficie superficieHectarea;
	protected Construccion construccionHectarea;
	protected Conexion conexion;
	protected boolean servicioElectrico;
	protected boolean servicioAgua;
	protected boolean accesoAlTransito;
	protected ConexionDeAgua unaConexionDeAgua;
	protected RutaPavimentada unaCalle;
	protected LineasDeTension unaLineaDeTension;
	protected boolean poseePozoDeAgua;
	
	public Hectarea(){
		this.construccionHectarea = null;
		this.identi = java.util.UUID.randomUUID().toString(); 
		this.generadorSuperficie = new GeneradorSuperficieDeterminista();
		this.superficieHectarea = generadorSuperficie.generarSuperficie();
		this.unaConexionDeAgua = null;
		this.unaLineaDeTension = null;

		poseePozoDeAgua=false;
	}
	
    @Override
    public boolean equals (Object o) {
        Hectarea x = (Hectarea) o;
            if (x.identi == identi) return true;
            return false;
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

	public boolean poseeServicioDeAgua(){
		return this.servicioAgua;
	}
	

	
	public boolean poseeServicioElectrico(){
		return this.servicioElectrico;
	}
	
	public boolean poseeLos3Servicios(){
		//return (servicioAgua && accesoAlTransito); con este funciona bien JugadorTest
		return (servicioAgua && servicioElectrico && accesoAlTransito);//con este falla porque le faltan servicios
	}
	
	public boolean poseeConstruccion(){
		return (construccionHectarea != null);
	}
	
	public Construccion obtenerConstruccion(){
		return construccionHectarea;
	}
	
	public Superficie obtenerSuperficie(){
		return superficieHectarea;
	}
	
	
	public ConexionDeAgua obtenerCanio() {
		return unaConexionDeAgua;
	}
	
	public LineasDeTension obtenerLineaDeTension(){
		return unaLineaDeTension;
	}
	
	public boolean tieneAgua() {
		
		return servicioAgua;
	}
	
	public boolean tieneCanio() {
		return (unaConexionDeAgua!= null);
	}
	

	public void establecerEdificio(Edificio unEdificio){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!this.poseeLos3Servicios()){
			throw new ExcepcionHectareaNoBrindaLosServiciosNecesarios();
		}
		else if(!(this.superficieHectarea).puedoConstruir(unEdificio)){
			//throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();//lo deshabilito para probar sin tener en cuenta los terrenos
			;
		}
		this.construccionHectarea = unEdificio;
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
		else if(!(this.superficieHectarea).puedoConstruir(unPozoDeAgua)){
			//throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
		this.construccionHectarea = unPozoDeAgua;
		poseePozoDeAgua=true;
		servicioAgua=true;

		
	}
	
	public void establecerCentral(CentralElectrica unaCentral){
		if(this.poseeConstruccion())
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		//else if(!(this.superficieHectarea).puedoConstruir(unaCentral))
				//throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		else if (!this.tieneAgua()){
			throw new ExcepcionCentralElectricaNoPoseeRedDeAgua();
		}
		this.construccionHectarea = unaCentral;
		this.habilitarElectricidad();
		
	}
	
	public void establecerConexion(Conexion unaConexion){
		
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else{
			this.conexion = unaConexion;
			servicioElectrico=true; 
		}
		
	}
	
	public void establecerConexionDeAgua(ConexionDeAgua unaConexion){
		

			unaConexionDeAgua=unaConexion;
			servicioAgua=unaConexionDeAgua.conectadoALaRed();
			//servicioAgua=true;//corregir esto
		
	}

	public void establecerCalle(RutaPavimentada rutaPavimentada) {
		
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else{
			unaCalle=rutaPavimentada;
			accesoAlTransito=true;	
		}
	}
	

}