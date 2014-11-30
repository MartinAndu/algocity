package Conectores;

import CentralesElectricas.CentralElectrica;
import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import PuntosConstruccion.PuntosDeLineaTension;

public  class LineasDeTension extends Conexion{

	CentralElectrica centralElectricaALAQuePertenece;
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 3;
	
	public LineasDeTension(Posicion unaPosicion) {
		super(unaPosicion);
		radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDeLineaTension();
		servicioQueTransmite="electricidad";
		conectadoALaRed=false;
	}
	
	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerConexionElectrica(this);
		this.proveerServicioZona(miPlano);
	}
	
	public void establecerCentralQueProveeEnergia(CentralElectrica unaCentralElectrica){
		this.centralElectricaALAQuePertenece = unaCentralElectrica;
	}
	
	
	public boolean puedeProveerServicio(){
		return true;
	}

	
	/*private boolean excedeElConsumo(int consumoDeLaNuevaConexion){
		int consumoActual = this.centralElectricaALAQuePertenece.obtenerCapacidadDeAbastecimientoEnMW();
		int consumoMaximo = this.centralElectricaALAQuePertenece.obtenerCapacidadMaxDeAbastecimientoEnMW();
		consumoActual += consumoDeLaNuevaConexion;		
		return (consumoActual>consumoMaximo);
	}*/
	
	public boolean conectadoALaRed(Hectarea unaHectarea){
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(posicionConstruccion, 1);
		Hectarea hectareaActual;
		marca=true;
		while (zonaCircundante.tieneSiguiente()&&!conectadoALaRed){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneConexionElectrica()&&(!hectareaActual.obtenerLineaDeTension().marcado())&&
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
	
}
