package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;
import PuntosConstruccion.PuntosDeTuberia;

public class ConexionDeAgua extends Conexion {
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 3;
	Plano miPlano;
	boolean marca;
	
	public ConexionDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		this.puntosDeConstruccion = new PuntosDeTuberia();
		
	}
	
	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerConexionDeAgua(this);
		Recorrido zonaCircundante= plano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=conectadoALaRed(unaHectarea);
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
		}
	}

	public boolean conectadoALaRed(Hectarea unaHectarea){
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(posicionConstruccion, 1);
		Hectarea hectareaActual;
		marca=true;
		while (zonaCircundante.tieneSiguiente()&&!conectadoALaRed){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneConexionDeAgua()&&(!hectareaActual.obtenerCanio().marcado())&&
				hectareaActual.obtenerCanio().conectadoALaRed(hectareaActual)){
				this.habilitarConexion();
			}
			if (hectareaActual.poseePozoDeAgua()){
				this.habilitarConexion();
			}
		}
		marca=false;
		return conectadoALaRed;
	}

	private boolean marcado() {//Este metodo indica si la conexion ya fue marcada para no volver a chequearla y evitar bucles infinitos. 
		
		return marca;
	}

	
	public void proveerServicioZona(Plano unPlano){
		miPlano=unPlano;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=this.conectadoALaRed(miPlano.devolverHectarea(posicionConstruccion));
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
		}	
	}
	
	public boolean puedeProveerServicio(){
		return true;
	}
	
	public void habilitarConexion(){
		conectadoALaRed=true;
		this.proveerServicioZona(miPlano);
		miPlano.devolverHectarea(posicionConstruccion).habilitarAgua();
	}
	
}
