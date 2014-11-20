package Conectores;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Recorrido;
import PlanoGeneral.Plano;

public class ConexionDeAgua extends Conexion {
	
	public ConexionDeAgua(Hectarea unaHectarea) {
		unaHectarea.establecerConexionDeAgua(this);
		// TODO Auto-generated constructor stub
	}

	boolean conectadoALaRed=false;

	public boolean conectadoALaRed(Hectarea hectareaActual) {
		//Esto puede devolver false considerand un caño de agua vacio sin agua
		//Se deja por ahora que devuelva true indicando que siempre hay agua
		return true;
		
		//Una posible solución es "return hectareaActual.poseeServicioDeAgua()"
		
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
	}
	
	public void habilitarCanioConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, 1);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()){
				ConexionDeAgua unaConexion=hectareaActual.obtenerCanio();
				if(unaConexion.conectadoALaRed(hectareaActual)){
					habilitarAgua();
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
