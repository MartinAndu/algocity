package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import PuntosConstruccion.PuntosDeRuta;

public class RutaPavimentada extends Conexion{

	static int COSTO_CONSTRUCCION = 10;
	static int RADIO_DE_DISTRIBUCION = 3;
	Plano miPlano;

	public RutaPavimentada(Posicion unaPosicion) {
		super(unaPosicion);
		this.conectadoALaRed = true;
		this.radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		this.puntosDeConstruccion = new PuntosDeRuta();
	}

	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerCalle(this);
		this.habilitarConexion();
	}
	
	@Override
	public void proveerServicioZona(Plano unPlano) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean conectadoALaRed(Hectarea hectareaActual) {
		// TODO Auto-generated method stub
		return true;
		//return conectadoALaRed;
	}

	@Override
	public void habilitarConexion() {

		conectadoALaRed=true;
		this.habilitarAccesoEnAlrededores(miPlano, posicionConstruccion);
		
	}
	public void habilitarAccesoEnAlrededores(Plano unPlano, Posicion ubicacionP){
		miPlano=unPlano;
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(ubicacionP, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()&&this.conectadoALaRed(miPlano.devolverHectarea(ubicacionP))){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAccesoAlTransito();
		}
	}
	
}
