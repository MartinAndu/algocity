package Conectores;

import CentralesElectricas.CentralElectrica;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import PuntosConstruccion.PuntosDeLineaTension;

public  class LineasDeTension extends Conexion{

	CentralElectrica centralElectricaALAQuePertenece;
	boolean marca=false;
	private Plano miPlano;
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 3;
	
	public LineasDeTension(Posicion unaPosicion) {
		super(unaPosicion);
		radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDeLineaTension();
	}
	
	public void construirSobrePlano(Plano plano){
		
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerConexionElectrica(this);
		Recorrido zonaCircundante= plano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=conectadoALaRed(unaHectarea);
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarElectricidad();
					
		}
	}
	
	
	public void establecerCentralQueProveeEnergia(CentralElectrica unaCentralElectrica){
		this.centralElectricaALAQuePertenece = unaCentralElectrica;
	}
	
	
	public boolean puedeProveerServicio(){
		
		return true;
	}

	
/*	private boolean excedeElConsumo(int consumoDeLaNuevaConexion){
		
		int consumoActual = this.centralElectricaALAQuePertenece.obtenerCapacidadDeAbastecimientoEnMW();
		int consumoMaximo = this.centralElectricaALAQuePertenece.obtenerCapacidadMaxDeAbastecimientoEnMW();
		
		consumoActual += consumoDeLaNuevaConexion;
		
		if (consumoActual > consumoMaximo)
			return true;
		
		return false;
	}*/
	
	public void proveerServicioZona(Plano unPlano){
		miPlano=unPlano;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=this.conectadoALaRed(miPlano.devolverHectarea(posicionConstruccion));
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarElectricidad();
		}
		
	}

	public boolean conectadoALaRed(Hectarea unaHectarea){
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(posicionConstruccion, 1);
		Hectarea hectareaActual;
		marca=true;
		while (zonaCircundante.tieneSiguiente()&&!conectadoALaRed){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneConexionElectrica()&&(hectareaActual.obtenerLineaDeTension().marcado())&&
				hectareaActual.obtenerLineaDeTension().conectadoALaRed(hectareaActual)){
				this.habilitarConexion();
			}
			if (hectareaActual.poseeCentralElectrica()){
				this.habilitarConexion();
			}
		}
		marca=false;
		return conectadoALaRed;
	}
	
	private boolean marcado() {//Este metodo indica si la conexion ya fue marcada para no volver a chequearla y evitar bucles infinitos. 
		
		return marca;
	}

	public void habilitarConexion(){
		conectadoALaRed=true;
		this.proveerServicioZona(miPlano);
		miPlano.devolverHectarea(posicionConstruccion).habilitarElectricidad();
	}
	

	
}
