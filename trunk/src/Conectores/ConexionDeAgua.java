package Conectores;

import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;
import PuntosConstruccion.PuntosDeTuberia;

public class ConexionDeAgua extends Conexion {
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 3;
	
	public ConexionDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		this.puntosDeConstruccion = new PuntosDeTuberia();
		servicioQueTransmite="agua";
		conectadoALaRed=false;
		
	}
	
	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerConexionDeAgua(this);
		this.proveerServicioZona(miPlano);
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

	
	public boolean puedeProveerServicio(){
		return true;
	}
		
}
