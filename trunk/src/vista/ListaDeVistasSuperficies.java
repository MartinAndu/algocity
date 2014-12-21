package vista;

import java.util.Iterator;
import java.util.LinkedList;

import Superficies.Superficie;

public class ListaDeVistasSuperficies {
	

	private LinkedList<VistaSuperficie> superficiesParaGraficar;
	
	ListaDeVistasSuperficies(){
		this.superficiesParaGraficar = new LinkedList<VistaSuperficie>();
		this.superficiesParaGraficar.add(new VistaSuperficieConAgua());
		this.superficiesParaGraficar.add(new VistaSuperficieConTerrenoLlano());
		
	}
	
	public VistaSuperficie obtenerVistaSuperficie(Superficie superficieAGraficar){
		Iterator<VistaSuperficie> it = superficiesParaGraficar.iterator();
		VistaSuperficie vistaSuperficie = null;
		boolean encontrado = false;
		
		while (!encontrado){
			vistaSuperficie = it.next();
			Superficie superficieActual = vistaSuperficie.obtenerSuperficie();
			if (superficieActual.obtenerId() == superficieAGraficar.obtenerId()){
				encontrado = true;
			}
		}
		
		return vistaSuperficie;
	}
}
