package PlanoGeneral;

import CentralesElectricas.CentralElectrica;
import Conectores.Conexion;
import Conectores.ConexionDeAgua;
import Edificios.Construccion;
import Edificios.Edificio;
import Edificios.PozoDeAgua;
import Excepciones.ExcepcionHectareaYaContieneUnaConstruccion;
import Excepciones.ExcepcionHectareaNoBrindaLosServiciosNecesarios;
import Excepciones.ExcepcionNoSePuedeConstruirEnEsteTerreno;
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
	protected ConexionDeAgua unaConexionDeAgua=null;
	
	public Hectarea(){
		this.construccionHectarea = null;
		this.identi = java.util.UUID.randomUUID().toString(); 
		this.generadorSuperficie = new GeneradorSuperficieDeterminista();
		this.superficieHectarea = generadorSuperficie.generarSuperficie();
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
	public boolean poseeLos3Servicios(){
		return (servicioAgua && servicioElectrico && accesoAlTransito);
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
	

	public void establecerEdificio(Edificio unEdificio){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!this.poseeLos3Servicios()){
			throw new ExcepcionHectareaNoBrindaLosServiciosNecesarios();
		}
		else if(!(this.superficieHectarea).puedoConstruir(unEdificio)){
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
		this.construccionHectarea = unEdificio;
		unEdificio.habilitarAccesoAlTransito();
		unEdificio.habilitarAgua();
		unEdificio.habilitarElectricidad();
	}
	
	public void establecerPozoDeAgua(PozoDeAgua unPozoDeAgua){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!(this.superficieHectarea).puedoConstruir(unPozoDeAgua)){
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		}
		this.construccionHectarea = unPozoDeAgua;
	}
	
	public void establecerCentral(CentralElectrica unaCentral){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		else if(!(this.superficieHectarea).puedoConstruir(unaCentral)){
			throw new ExcepcionNoSePuedeConstruirEnEsteTerreno();
		if (!this.poseeServicioDeAgua())
				throw new ExcepcionCentralElectricaNoPoseeRedDeAgua();
		}
		this.construccionHectarea = unaCentral;
		this.habilitarElectricidad();
	}
	
	public void establecerConexion(Conexion unaConexion){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
		this.conexion = unaConexion;
		this.habilitarElectricidad();
	}
	public void establecerConexionDeAgua(ConexionDeAgua unaConexion){
		unaConexionDeAgua=unaConexion;
		servicioAgua=unaConexionDeAgua.conectadoALaRed();
	}
	
	
	public ConexionDeAgua obtenerCanio() {
		return unaConexionDeAgua;
	}
	
	public boolean tieneAgua() {
		servicioAgua=unaConexionDeAgua.conectadoALaRed();
		return servicioAgua;
	}
	
	public boolean tieneCanio() {
		return (unaConexionDeAgua!= null);
	}
}