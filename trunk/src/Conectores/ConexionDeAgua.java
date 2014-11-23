package Conectores;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	boolean conectadoALaRed;
	Hectarea ubicacion=new Hectarea();
	int radioDeDistribucion;
	
	public ConexionDeAgua(Hectarea unaHectarea) {
		unaHectarea.establecerConexionDeAgua(this);
		ubicacion=unaHectarea;
		conectadoALaRed=false;
		radioDeDistribucion=3;
		// TODO Auto-generated constructor stub
	}



	public boolean conectadoALaRed(Hectarea hectareaActual) {

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

	public void habilitarAgua(){
		conectadoALaRed=true;
		ubicacion.habilitarAgua();
		
		
	}
	
	public void habilitarConexion(){
		conectadoALaRed=true;
		
	}
	
	public void habilitarCanioConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		Hectarea unaHectarea=unPlano.devolverHectarea(unaPosicion);
		Conexion unaConexion=unaHectarea.obtenerCanio();
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				ConexionDeAgua conexionActual=hectareaActual.obtenerCanio();
				if(unaConexion.conectadoALaRed(hectareaActual)){
					conexionActual.habilitarAgua();
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
