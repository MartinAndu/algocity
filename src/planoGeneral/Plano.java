package planoGeneral;
import java.util.ArrayList;
import java.util.HashMap;


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
		
		for (int i = 0; i < dimensionN; i++) {
			for (int j = 0; j < dimensionM; j++) {
				
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
	}

	private void construirHectareas(int dimensionN, int dimensionM) {
		
		for (int i = 0; i < dimensionN; i++) {
			for (int j = 0; j < dimensionM; j++) {
				
				String posicionEnString = (new Posicion(i, j)).enString();
				Hectarea hectarea = new Hectarea();
				hectareas.put(posicionEnString, hectarea);	
			}
		}
	}


}