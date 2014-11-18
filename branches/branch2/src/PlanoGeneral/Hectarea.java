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

public class Hectarea {
	public String identi;
	protected Superficie superficieHectarea;
	protected Construccion construccionHectarea;
	protected boolean servicioElectrico;
	protected boolean servicioAgua;
	protected boolean accesoAlTransito;
	protected ConexionDeAgua unaConexionDeAgua=null;
	
	public Hectarea(Superficie unaSuperficie){ // Hectarea recibiria la superficie por parametro? no estaba seguro, pero no me parece mal
		this.superficieHectarea = unaSuperficie;
		this.construccionHectarea = null;
		this.identi = java.util.UUID.randomUUID().toString(); 
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

	public boolean poseeLos3Servicios(){
		return (servicioAgua && servicioElectrico && accesoAlTransito);
	}
	
	public boolean poseeConstruccion(){
		return (construccionHectarea != null);
	}
	
	public Construccion obtenerConstruccion(){
		return construccionHectarea;
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
	}
	
	public void establecerConexion(Conexion unaConexion){
		if(this.poseeConstruccion()){
			throw new ExcepcionHectareaYaContieneUnaConstruccion();
		}
	}
	
	public ConexionDeAgua obtenerCanio() {
		return unaConexionDeAgua;
	}

	public boolean tieneCanio() {
		return (unaConexionDeAgua!= null);
	}

}