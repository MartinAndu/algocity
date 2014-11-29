package CentralesElectricas;

import java.util.ArrayList;
import Conectores.LineasDeTension;
import Edificios.Construccion;
import Edificios.Posicion;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;

public class CentralElectrica extends Construccion {
	
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;

	
	static int CONSUMO_ELECTRICO = 0;
	
	ArrayList <Hectarea> hectareas;
	
	public CentralElectrica(Posicion posicion) {
		super(posicion);
	}
	
	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerCentral(this);
	}
	
	public void proveerElectricidadZona(Plano unPlano){
		//Obtengo lo que hay en las zonas circundante de radio X correspondiente a la central
		
		Recorrido zonaCircundante = unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			hectareaActual.habilitarElectricidad();
	
		}
	
		Hectarea hectareaActual = unPlano.devolverHectarea(posicionConstruccion);
		LineasDeTension unaLineaDeTension = new LineasDeTension(posicionConstruccion);
		hectareaActual.establecerConexionElectrica(unaLineaDeTension);
		unaLineaDeTension.establecerCentralQueProveeEnergia(this);
		unaLineaDeTension.habilitarConexion();
		
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
