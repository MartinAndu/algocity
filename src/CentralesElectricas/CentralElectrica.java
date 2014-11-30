package CentralesElectricas;

import java.util.ArrayList;
import ConstruccionGeneral.Construccion;
import ConstruccionGeneral.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class CentralElectrica extends Construccion {
	
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	static String servicioQueProvee;
	private ArrayList<Construccion> construcciones;

	
	static int CONSUMO_ELECTRICO = 0;
	
	ArrayList <Hectarea> hectareas;
	
	public CentralElectrica(Posicion posicion) {
		super(posicion);
		servicioQueProvee="electricidad";
	}
	
	public void construirSobrePlano(Plano unPlano){
		construcciones=new ArrayList<Construccion>();
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerCentral(this);
		Recorrido zonaCircundante= unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);
		while (zonaCircundante.tieneSiguiente()){
			Hectarea hectareaActual=zonaCircundante.siguiente();
					hectareaActual.habilitarServicio(servicioQueProvee);
		}
	}
	
	public void proveerElectricidadZona(Plano unPlano){
		//Obtengo lo que hay en las zonas circundante de radio X correspondiente a la central
		
		Recorrido zonaCircundante = unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			hectareaActual.habilitarServicio(servicioQueProvee);
			
	
		}
;
		
	}
	
	public void agregarConstruccionQueConsumeElectricidad(Construccion unaConstruccion){
		construcciones.add(unaConstruccion);
	}
	
	public int obtenerRadioDeAbastecimientoEnHectareas(){
		return radioDeAbastecimientoEnHectareas;
	}
	
	public int obtenerCapacidadDeAbastecimientoEnMW(){
		return capacidadDeAbastecimientoEnMW;
	}
	
	public int obtenerCapacidadMaxDeAbastecimientoEnMW(){
		return capacidadMaxDeAbastecimientoEnMW;
	}
	
	public void setearCapacidadDeAbastecimientoEnMW(int capacidadParaAsignar){
		this.capacidadDeAbastecimientoEnMW = capacidadParaAsignar;
	}

	@Override
	public int devolverConsumo() {
		return CONSUMO_ELECTRICO;
	}
	
}
