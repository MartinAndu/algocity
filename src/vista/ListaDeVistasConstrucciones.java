package vista;

import java.util.Iterator;
import java.util.LinkedList;

import ConstruccionGeneral.Construccion;

public class ListaDeVistasConstrucciones {
	

	private LinkedList<VistaConstruccion> construccionesParaGraficar;
	
	ListaDeVistasConstrucciones(){
		this.construccionesParaGraficar = new LinkedList<VistaConstruccion>();
		construccionesParaGraficar.add(new VistaCentralEolica());
		construccionesParaGraficar.add(new VistaCentralNuclear());
		construccionesParaGraficar.add(new VistaCentralMineral());
		construccionesParaGraficar.add(new VistaConexionDeAgua());
		construccionesParaGraficar.add(new VistaEdificioComercial());
		construccionesParaGraficar.add(new VistaEdificioIndustrial());
		construccionesParaGraficar.add(new VistaEdificioResidencial());
		construccionesParaGraficar.add(new VistaLineasDeTension());
		construccionesParaGraficar.add(new VistaPozoDeAgua());
		construccionesParaGraficar.add(new VistaRutaPavimentada());
		
	}
	
	public VistaConstruccion obtenerVistaConstruccion(Construccion construccionActual){
		Iterator<VistaConstruccion> it = construccionesParaGraficar.iterator();
		VistaConstruccion vistaActual = null;
		boolean encontrado = false;
		
		while (!encontrado){
			vistaActual = it.next();
			if (vistaActual.obtenerConstruccion().obteneridTipoDeConstruccion() == construccionActual.obteneridTipoDeConstruccion()){
				vistaActual.asignarEstadoConstruccion(construccionActual.darEstadoContruccion());
				encontrado = true;
			}
		}
		
		return vistaActual;
		
		
	}
}
