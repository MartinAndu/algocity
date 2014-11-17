package PlanoGeneral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Edificios.Posicion;
import Superficies.Superficie;
import Superficies.SuperficieConTerrenoLlano;


public class Plano {

	private HashMap<String, Hectarea> hectareas;
	private HashMap<Hectarea, ArrayList<Hectarea>> caminos;
 
	public Plano(int dimensionN, int dimensionM) {
		hectareas = new HashMap<String, Hectarea>();
		caminos = new HashMap<Hectarea, ArrayList<Hectarea>>();
		
		construirPlano(dimensionN, dimensionM);
	}

	private void construirPlano(int dimensionN, int dimensionM) {
		construirHectareas(dimensionN, dimensionM);
		construirCaminos(dimensionN, dimensionM);	
	}

	private void construirCaminos(int dimensionN, int dimensionM) {
		
		for (int i = 1; i <= dimensionN; i++) {
			
			for (int j = 1; j <= dimensionM; j++) {	
				Posicion posicion = new Posicion(i, j);				
				ArrayList<Hectarea> hectareasAlrededor = obtenerHectareasDelEntorno(posicion);
				Hectarea hectarea = hectareas.get(posicion.enString());
				caminos.put(hectarea, hectareasAlrededor);			
			}
		}
		
	}

	private ArrayList<Hectarea> obtenerHectareasDelEntorno(Posicion posicion) {
		
		int x = posicion.devolverCoordenadaX();
		int y = posicion.devolverCoordenadaY();
		ArrayList<Hectarea> hectareasDelEntorno = new ArrayList<Hectarea>();
		
		String posicionDelEntornoString = (new Posicion(x+1, y)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		posicionDelEntornoString = (new Posicion(x+1, y+1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);
		
		posicionDelEntornoString = (new Posicion(x, y+1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);
		
		posicionDelEntornoString = (new Posicion(x-1, y+1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		posicionDelEntornoString = (new Posicion(x-1, y)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		posicionDelEntornoString = (new Posicion(x-1, y-1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		posicionDelEntornoString = (new Posicion(x, y-1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		posicionDelEntornoString = (new Posicion(x+1, y-1)).enString();
		agregarHectareaAlEntorno(hectareasDelEntorno, posicionDelEntornoString);

		return hectareasDelEntorno;
	}

	private void agregarHectareaAlEntorno(
			ArrayList<Hectarea> hectareasDelEntorno, String posicion) {
		
		if (hectareas.containsKey(posicion)) {	
			Hectarea hectarea = hectareas.get(posicion);
			hectareasDelEntorno.add(hectarea);
		}
		else {
			hectareasDelEntorno.add(null);
		}
	}

	private void construirHectareas(int dimensionN, int dimensionM) {
		
		Superficie unaSuperficieConTierra = new SuperficieConTerrenoLlano();
		
		for (int i = 1; i <= dimensionN; i++) {
			for (int j = 1; j <= dimensionM; j++) {
				
				String posicionEnString = (new Posicion(i, j)).enString();
				Hectarea hectarea = new Hectarea(unaSuperficieConTierra);
				hectareas.put(posicionEnString, hectarea);	
			}
		}
	}

	public Recorrido recorrerEntorno(Posicion posicion, int radioHectarea) {
		
		Hectarea hectarea = hectareas.get(posicion.enString());
		ArrayList<Hectarea> entornoARecorrer = new ArrayList<Hectarea>();
		ArrayList<Hectarea> entornoDelEntorno = new ArrayList<Hectarea>();
		entornoDelEntorno.add(hectarea);
		entornoARecorrer.add(hectarea);
		
		for (int i = 0; i < radioHectarea; i++) {
			entornoDelEntorno = obtenerEntornoGeneral(entornoDelEntorno, entornoARecorrer);
			entornoARecorrer.addAll(entornoDelEntorno);
		}
		
		entornoARecorrer.remove(hectarea);
		Recorrido recorrido = new Recorrido(entornoARecorrer);
 		
		return recorrido;
	}

	private ArrayList<Hectarea> obtenerEntornoGeneral(
			ArrayList<Hectarea> entornoDelEntorno,
			ArrayList<Hectarea> entornoARecorrer) {
		
		ArrayList<Hectarea> entornoBuscado = new ArrayList<Hectarea>();
		Iterator<Hectarea> it = entornoDelEntorno.iterator();
		
		while (it.hasNext()) {
			Hectarea hectarea = (Hectarea) it.next();
			ArrayList<Hectarea> entornoParcial = new ArrayList<Hectarea>();
			
			if (hectarea != null) {
				entornoParcial = obtenerEntornoParcial(hectarea, entornoARecorrer, entornoBuscado);
			}
			entornoBuscado.addAll(entornoParcial);
		}
		return entornoBuscado;
	}

	private ArrayList<Hectarea> obtenerEntornoParcial(Hectarea hectarea,
			ArrayList<Hectarea> entornoARecorrer, ArrayList<Hectarea> entornoBuscado) {
		
		ArrayList<Hectarea> entorno = caminos.get(hectarea);
		ArrayList<Hectarea> entornoParcial = new ArrayList<Hectarea>();
		Iterator<Hectarea> it = entorno.iterator();
		
		while (it.hasNext()) {
			Hectarea hectareaEnEntorno = (Hectarea) it.next();
			boolean hectareaNoEsta = !(entornoARecorrer.contains(hectareaEnEntorno)) && !(entornoBuscado.contains(hectareaEnEntorno));
			if ((hectareaEnEntorno != null) && hectareaNoEsta){
				entornoParcial.add(hectareaEnEntorno);
			}
		}
		
		return entornoParcial;
	}
}