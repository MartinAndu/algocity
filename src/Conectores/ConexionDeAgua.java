package Conectores;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	boolean conectadoALaRed;
	Hectarea ubicacion=new Hectarea();
	int radioDeDistribucion;
	Posicion ubicacionP;
	
	public ConexionDeAgua(Hectarea unaHectarea) {
		unaHectarea.establecerConexionDeAgua(this);
		ubicacion=unaHectarea;
		conectadoALaRed=false;
		radioDeDistribucion=3;
		// TODO Auto-generated constructor stub
	}
	public ConexionDeAgua(Posicion unaPosicion){

		ubicacionP=unaPosicion;
		conectadoALaRed=false;
		radioDeDistribucion=3;
	}
	
	public void construirSobrePlano(Plano plano){

		Hectarea unaHectarea = plano.devolverHectarea(ubicacionP);
		unaHectarea.establecerConexionDeAgua(this);
	}



	public boolean conectadoALaRed() {
//Chequear si esta conectado a la red
		return conectadoALaRed;		
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
		
	}
	
	
	public void habilitarCanioConAguaSiCorresponde(Plano unPlano) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(ubicacionP, 1);
		Hectarea hectareaActual;
		ConexionDeAgua conexionActual;
		while (zonaCircundante.tieneSiguiente()){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				conexionActual=hectareaActual.obtenerCanio();
				if(this.conectadoALaRed()){
					conexionActual.habilitarConexion();
				}
			}
		}
	}
	
	
	public void habilitarConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()){
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
}
