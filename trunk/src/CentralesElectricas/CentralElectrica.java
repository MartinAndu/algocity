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



public class CentralElectrica extends Construccion implements Reconstruible,Destruible {
	protected int radioDeAbastecimientoEnHectareas;
	protected int capacidadDeAbastecimientoEnMW;
	protected int capacidadMaxDeAbastecimientoEnMW;
	
	static int CONSUMO_ELECTRICO = 0;
	
	ArrayList <Hectarea> hectareas;
	
	
	public void construirSobrePlano(Plano unPlano){
		Hectarea unaHectarea = unPlano.devolverHectarea(posicionConstruccion);
		unaHectarea.establecerCentral(this);
	}
	
	public void proveerElectricidadZona(Plano unPlano){
		//Obtengo lo que hay en las zonas circundante de radio X correspondiente a la central
		
		Recorrido zonaCircundante = unPlano.recorrerZonaCircundante(posicionConstruccion, radioDeAbastecimientoEnHectareas);

		int cantidadDeConsumoActual = capacidadDeAbastecimientoEnMW;
		
		while (zonaCircundante.tieneSiguiente()){
			
			Hectarea hectareaActual = zonaCircundante.siguiente();
			
			cantidadDeConsumoActual += ( hectareaActual.obtenerConstruccion() ).devolverConsumo(); 
			
			//Verifico el consumo del edificio si excede a la capacidad máxima
			if (cantidadDeConsumoActual <= capacidadMaxDeAbastecimientoEnMW)
				hectareaActual.establecerConexion((Conexion)new LineasDeTension(this));
			
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
	
	public void setearCapacidadDeAbastecimientoEnMW(int capacidadParaAsignar){
		this.capacidadDeAbastecimientoEnMW = capacidadParaAsignar;
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

	@Override
	public void reconstruir(int puntosDeReconstruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int porcentajeDeConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizarPuntosDeConstruccion() {
		// TODO Auto-generated method stub
		
	}
	
	
}
