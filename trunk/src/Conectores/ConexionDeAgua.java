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
	static int COSTO_CONSTRUCCION = 5;
	Plano miPlano;
	

	public ConexionDeAgua(Posicion unaPosicion){

		super(unaPosicion);
		this.costoDeConstruccion = COSTO_CONSTRUCCION;
		ubicacionP=unaPosicion;
		conectadoALaRed=false;
		radioDeDistribucion=3;
	}
	
	public void construirSobrePlano(Plano plano){
		miPlano=plano;
		Hectarea unaHectarea = plano.devolverHectarea(ubicacionP);
		unaHectarea.establecerConexionDeAgua(this);
	}



	public boolean conectadoALaRed(Hectarea unaHectarea) {
		Recorrido zonaCircundante= miPlano.recorrerZonaCircundante(ubicacionP, 1);
		Hectarea hectareaActual;
		while (zonaCircundante.tieneSiguiente()&&!conectadoALaRed){
			hectareaActual=zonaCircundante.siguiente();
			if (hectareaActual.tieneCanio()&&
				hectareaActual.obtenerCanio().conectadoALaRed(miPlano.devolverHectarea(ubicacionP))){
				this.habilitarConexion();
			}
			if (hectareaActual.poseePozoDeAgua()){
				this.habilitarConexion();
			}
		}
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
		this.habilitarConAguaSiCorresponde(miPlano, ubicacionP);
	}
	
	
	public void habilitarConAguaSiCorresponde(Plano unPlano, Posicion unaPosicion) {
		miPlano=unPlano;
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(unaPosicion, radioDeDistribucion);
		while (zonaCircundante.tieneSiguiente()&&this.conectadoALaRed(unPlano.devolverHectarea(unaPosicion))){
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
