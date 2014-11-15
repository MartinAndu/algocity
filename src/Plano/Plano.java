import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plano {

	private HashMap<String, Hectarea> hectareas;
	private HashMap<Hectarea, ArrayList<Hectarea>> conexiones;
 
	public Plano(int dimensionN, int dimensionM) {
		hectareas = new HashMap<String, Hectarea>();
		conexiones = new HashMap<Hectarea, ArrayList<Hectarea>>();
	}


}