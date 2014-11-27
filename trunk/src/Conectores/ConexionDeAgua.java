package Conectores;

import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	Hectarea ubicacion = new Hectarea();
	Posicion ubicacionP;
	static int COSTO_CONSTRUCCION = 5;
	static int RADIO_DE_DISTRIBUCION = 3;
	Plano miPlano;
	boolean marca;
	
	public ConexionDeAgua(Posicion unaPosicion){
		super(unaPosicion);
		
		ubicacionP = unaPosicion;
		conectadoALaRed = false;
		costoDeConstruccion = COSTO_CONSTRUCCION;
		radioDeDistribucion = RADIO_DE_DISTRIBUCION;
	}
	
	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(ubicacionP);
		unaHectarea.establecerConexionDeAgua(this);
		Recorrido zonaCircundante= plano.recorrerZonaCircundante(posicionConstruccion, radioDeDistribucion);
		conectadoALaRed=conectadoALaRed(unaHectarea);
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
		}
	}

	public boolean conectadoALaRed(Hectarea unaHectarea){
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(ubicacionP, 1);
		Hectarea hectareaActual;
		marca=true;
		while (zonaCircundante.tieneSiguiente()&&!conectadoALaRed){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()&&(!hectareaActual.obtenerCanio().marcado())&&
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

	
	public boolean esConstruibleSobreAgua(){
		
		return true;
	}
	public boolean esConstruibleSobreTierra(){
		
		return true;
	}
	
	public void proveerServicioZona(Plano unPlano){
		
	}
	
	public boolean puedeProveerServicioZona(Plano unPlano){
		return true;
	}
	
	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub	
	}
	
	public void habilitarConexion(){
		conectadoALaRed=true;
		this.habilitarConAguaSiCorresponde(miPlano, ubicacionP);
		miPlano.devolverHectarea(ubicacionP).habilitarAgua();
	}
	
	
	public void habilitarConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		miPlano=unPlano;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, radioDeDistribucion);
		conectadoALaRed=this.conectadoALaRed(miPlano.devolverHectarea(ubicacionP));
		while (zonaCircundante.tieneSiguiente()&&conectadoALaRed){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
		}
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
	
	public void destruir(){
		//Godzilla no destruye la conexion de agua
	}
}