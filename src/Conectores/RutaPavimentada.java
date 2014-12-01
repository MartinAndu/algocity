package Conectores;

import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PuntosConstruccion.PuntosDeRuta;

public class RutaPavimentada extends Conexion{

	static int COSTO_CONSTRUCCION = 10;
	static int RADIO_DE_DISTRIBUCION = 3;

	public RutaPavimentada(Posicion unaPosicion) {
		super(unaPosicion);
		this.conectadoALaRed = true;
		this.radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDeRuta();
		servicioQueTransmite="transito";
	}

	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerCalle(this);
		this.habilitarConexion();
	}
	
	public boolean conectadoALaRed(Hectarea unaHectarea){
		return conectadoALaRed;
	}
	
}
