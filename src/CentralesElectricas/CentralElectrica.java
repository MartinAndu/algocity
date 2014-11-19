package CentralesElectricas;

import java.util.ArrayList;

import Conectores.Conexion;
import Conectores.LineasDeTension;
import Edificios.Construccion;
import Edificios.Destruible;
import Edificios.Reconstruible;
import PlanoGeneral.Hectarea;
import PlanoGeneral.Plano;
import PlanoGeneral.Recorrido;
import Excepciones.ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima;



public class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
	static int CONSUMO_ELECTRICO = 0;
	
	ArrayList <Hectarea> hectareas;
	
	public void proveerElectricidadZona(Plano unPlano){
		//Obtengo lo que hay en las zonas circundante de radio X correspondiente a la central
		
		Recorrido zonaCircundante = unPlano.recorrerZonaCircundante(unaPosicion, radioDeAbastecimientoEnHectareas);

		int cantidadDeConsumoActual = 0;
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			cantidadDeConsumoActual += ( hectareaActual.obtenerConstruccion() ).devolverConsumo(); 
			
			//Verifico el consumo del edificio si excede a la capacidad máxima
			if (cantidadDeConsumoActual > capacidadMaxDeAbastecimientoEnMW)
				throw new ExcepcionElConsumoElectricoDeLaHectareaExcedeALaCapacidadMaxima();
			hectareaActual.establecerConexion((Conexion)new LineasDeTension(hectareaActual));
			
		}
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
	
	public boolean esConstruibleSobreTierra(){
		return true;
	}
	
	public boolean esConstruibleSobreAgua(){
		return false;
	}

	@Override
	public void reconstruir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int devolverConsumo() {
		return CONSUMO_ELECTRICO;
	}
	
}
