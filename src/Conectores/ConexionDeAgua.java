package Conectores;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	boolean conectadoALaRed;
	Hectarea ubicacion=new Hectarea();
	
	public ConexionDeAgua(Hectarea unaHectarea) {
		unaHectarea.establecerConexionDeAgua(this);
		ubicacion=unaHectarea;
		conectadoALaRed=false;
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
	
	public void habilitarConexionARedAgua(){
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
					conexionActual.habilitarConexionARedAgua();
				}
			}
		}
	}
	
	public void habilitarConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 3);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarAgua();
				
			
		}
	}
}