package Conectores;

import CentralesElectricas.CentralElectrica;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public abstract class Conexion extends Construccion {


	public abstract boolean conectadoALaRed(Hectarea hectareaActual);

	protected static String servicioQueTransmite;
	protected boolean marca=false;
	
	protected int radioDeDistribucion;
	protected boolean conectadoALaRed;
	protected Plano miPlano;
	protected CentralElectrica centralElectricaALAQuePertenece;

	public Conexion(Posicion posicion) {
		super(posicion);
	}
	 


	@Override
	public int devolverConsumo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean marcado() {//Este metodo indica si la conexion ya fue marcada para no volver a chequearla y evitar bucles infinitos. 
		
		return marca;
	}
	
	public void habilitarConexion(){
		conectadoALaRed=true;
		this.proveerServicioZona(miPlano);
		miPlano.devolverHectarea(posicionConstruccion).habilitarServicio(servicioQueTransmite);
	}
	
	public void proveerServicioZona(Plano unPlano){
		miPlano=unPlano;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=this.conectadoALaRed(miPlano.devolverHectarea(posicionConstruccion));
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();

			hectareaActual.habilitarServicio(servicioQueTransmite);

		}
		
	}

}
