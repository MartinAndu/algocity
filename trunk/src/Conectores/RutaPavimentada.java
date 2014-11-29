package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class RutaPavimentada extends Conexion{

	static int COSTO_CONSTRUCCION = 10;
	static int RADIO_DE_DISTRIBUCION = 3;
	Plano miPlano;

	public RutaPavimentada(Posicion unaPosicion) {
		super(unaPosicion);
		
		conectadoALaRed = true;
		
		radioDeDistribucion = RADIO_DE_DISTRIBUCION;
		costoDeConstruccion = COSTO_CONSTRUCCION;
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
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
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
	
	public void destruir(){
		danio = this.estadoConstruccion * 80 / 100;
	}

	@Override
	public void destruirEnPorcentaje(int porcentaje) {
		// TODO Auto-generated method stub
		
	}
}
