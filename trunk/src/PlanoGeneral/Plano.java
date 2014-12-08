package PlanoGeneral;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ConstruccionGeneral.Posicion;
import PlanoDireccion.Direccion;
import PlanoDireccion.Norte;
import PlanoGeneradores.GeneradorDireccion;
import PlanoGeneradores.GeneradorPosicion;
import PlanoGeneradores.GeneradorRecorrido;
import SuperficiesGeneradores.GeneradorSuperficie;
import org.w3c.dom.Element;


public class Plano {

	protected HashMap<String, Hectarea> hectareas;
	protected HashMap<Hectarea, ArrayList<Hectarea>> caminos;
	protected GeneradorPosicion generadorPosicion;
	protected GeneradorDireccion generadorDireccion;
	protected GeneradorRecorrido generadorRecorrido;
	protected GeneradorSuperficie generadorSuperficies;
	protected int dimensionM;
	protected int dimensionN;
	
	public Plano() {
		dimensionN = 25;
		dimensionM = 25;
		hectareas = new HashMap<String, Hectarea>();
		caminos = new HashMap<Hectarea, ArrayList<Hectarea>>();
	}

	protected void construirPlano(int dimensionN, int dimensionM) {
		construirHectareas(dimensionN, dimensionM);
		construirCaminos(dimensionN, dimensionM);	
	}

	protected void construirCaminos(int dimensionN, int dimensionM) {
		
		for (int i = 1; i <= dimensionN; i++) {
			
			for (int j = 1; j <= dimensionM; j++) {	
				Posicion posicion = new Posicion(i, j);				
				ArrayList<Hectarea> hectareasAlrededor = obtenerHectareasDelEntorno(posicion);
				Hectarea hectarea = hectareas.get(posicion.enString());
				caminos.put(hectarea, hectareasAlrededor);			
			}
		}
		
	}

	protected ArrayList<Hectarea> obtenerHectareasDelEntorno(Posicion posicion) {
		
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

	protected void agregarHectareaAlEntorno(
			ArrayList<Hectarea> hectareasDelEntorno, String posicion) {
		
		if (hectareas.containsKey(posicion)) {	
			Hectarea hectarea = hectareas.get(posicion);
			hectareasDelEntorno.add(hectarea);
		}
		else {
			hectareasDelEntorno.add(null);
		}
	}

	protected void construirHectareas(int dimensionN, int dimensionM) {

		for (int i = 1; i <= dimensionN; i++) {
			for (int j = 1; j <= dimensionM; j++) {
				
				String posicionEnString = (new Posicion(i, j)).enString();
				Hectarea hectarea = new Hectarea(generadorSuperficies.generarSuperficie());
				hectareas.put(posicionEnString, hectarea);	
			}
		}
	}

	public Recorrido recorrerZonaCircundante(Posicion posicion, int radioEnHectareas) {
		
		Hectarea hectarea = hectareas.get(posicion.enString());
		ArrayList<Hectarea> zonaARecorrer = new ArrayList<Hectarea>();
		ArrayList<Hectarea> contornoDeZona = new ArrayList<Hectarea>();
		Recorrido recorrido = new Recorrido();
		contornoDeZona.add(hectarea);
		zonaARecorrer.add(hectarea);
		
		for (int i = 0; i < radioEnHectareas; i++) {
			contornoDeZona = obtenerEntornoGeneral(contornoDeZona, zonaARecorrer);
			recorrido.agregar(contornoDeZona);
			zonaARecorrer.addAll(contornoDeZona);
		}
 		
		return recorrido;
	}
	
	public Recorrido recorrerTodoDesdeUnaPosicionAleatoria() {
		
		Posicion posicion = this.generarPosicionAleatoria();
		int radioDeCobertura = this.calcularMayorDistanciaALosLimites(posicion);
		
		return this.recorrerZonaCircundante(posicion, radioDeCobertura);
	}

	protected int calcularMayorDistanciaALosLimites(Posicion posicion) {
		
		int diferenciaPosicionAncho = this.dimensionM - posicion.devolverCoordenadaX();
		int diferenciaPosicionAlto = this.dimensionN - posicion.devolverCoordenadaY();
		int mayorDistanciaEnAncho = 0;
		int mayorDistanciaEnAlto = 0;
		
		if (posicion.devolverCoordenadaX() < diferenciaPosicionAncho) {
			mayorDistanciaEnAncho = diferenciaPosicionAncho;
		} else {
			mayorDistanciaEnAncho = posicion.devolverCoordenadaX();
		}
		
		if (posicion.devolverCoordenadaY() < diferenciaPosicionAlto) {
			mayorDistanciaEnAlto = diferenciaPosicionAlto;
		} else {
			mayorDistanciaEnAlto = posicion.devolverCoordenadaY();
		}
		
		if (mayorDistanciaEnAlto < mayorDistanciaEnAncho) {
			return mayorDistanciaEnAncho;
		} else {
			return mayorDistanciaEnAlto;
		}
	}

	protected ArrayList<Hectarea> obtenerEntornoGeneral(
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

	protected ArrayList<Hectarea> obtenerEntornoParcial(Hectarea hectarea,
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
	
	public Recorrido generarRecorridolAleatorioDesdeUnaPosicionBorde() {
		
		Posicion posicionBorde = new Posicion(0, 0);
		Direccion direccion = new Norte();
		Recorrido recorrido = new Recorrido();
		boolean recorridoMuyCorto = false;
		
		do {
			posicionBorde = this.generadorPosicion.generarPosicionEnBordePlano();
			direccion = this.generadorDireccion.generarDireccion();
			recorrido = this.generadorRecorrido.gerenerarRecorrido(this, posicionBorde, direccion);
			recorridoMuyCorto = (recorrido.longDelRecorridoEnHectareas() < 2);
		} while (recorridoMuyCorto);
		
		return recorrido;
	}
	
	public Posicion generarPosicionAleatoria() {
		
		return this.generadorPosicion.generarPosicion();	
	}
	
	public Recorrido recorrerLinealmente(Posicion posicion, Direccion direccion) {
		
		Hectarea hectarea = hectareas.get(posicion.enString());
		Recorrido recorrido = new Recorrido();
		ArrayList<Hectarea> entorno = this.caminos.get(hectarea);
		int direccionEnInt = direccion.enInt();
		
		while ((entorno.get(direccionEnInt)) != null) {
			hectarea = entorno.get(direccionEnInt);
			recorrido.agregar(hectarea);
			entorno = this.caminos.get(hectarea);		
		}
		
		return recorrido;
	}
	
	public Recorrido recorrerEnZigZag(Posicion posicion, Direccion direccion) {
		
		Hectarea hectarea = hectareas.get(posicion.enString());
		Recorrido recorrido = new Recorrido();
		ArrayList<Hectarea> entorno = this.caminos.get(hectarea);
		ZigZag zigZag = new ZigZag(direccion);
		int direccionEnInt = zigZag.zigZagear();
		
		while ((entorno.get(direccionEnInt)) != null) {
			hectarea = entorno.get(direccionEnInt);
			recorrido.agregar(hectarea);
			entorno = this.caminos.get(hectarea);
			direccionEnInt = zigZag.zigZagear();		
		}
		
		return recorrido;
	}

	public Hectarea devolverHectarea(Posicion posicion) {
		
		return this.hectareas.get(posicion.enString());
	}

	public Node serializar(Document doc) {
		Element elementoPlano = doc.createElement("Plano");
		elementoPlano.setAttribute("dimensionM", Integer.toString(this.dimensionM));
		elementoPlano.setAttribute("dimensionN", Integer.toString(this.dimensionN));
		
		for (int i = 1; i <= dimensionN; i++) {
			for (int j = 1; j <= dimensionM; j++) {
				Posicion posicionParcial = new Posicion(i,j);
				String posicionEnString = posicionParcial.enString();
				Hectarea hectarea = hectareas.get(posicionEnString);
				if (hectarea != null){
					elementoPlano.appendChild(hectarea.serializar(doc,posicionEnString));
				}
			}
		}
		
		return elementoPlano;
	}

	public static Plano hidratar(Node elementoPlano) {
		Plano nuevoPlano = new Plano();
		
		int dimM = Integer.parseInt(((Element) elementoPlano).getAttribute("dimensionM"));
		int dimN = Integer.parseInt(((Element) elementoPlano).getAttribute("dimensionN"));
		
		nuevoPlano.dimensionN = dimN;
		nuevoPlano.dimensionM = dimM;
		
		HashMap<String, Hectarea> hectareasNuevas = new HashMap<String, Hectarea>();

		boolean corte = true;
		int i = 0;
		
		while(corte){
			try {
				Element elementoHectarea = (Element) elementoPlano.getChildNodes().item(i);

				Hectarea hectareaNueva = Hectarea.hidratar(elementoHectarea);
				
				hectareasNuevas.put(elementoHectarea.getAttribute("posicion"), hectareaNueva);
				
				i += 1;
			}
			catch (NullPointerException e){
				corte = false;
			}
		}
		
		nuevoPlano.hectareas = hectareasNuevas;
		nuevoPlano.construirCaminos(dimN, dimM);
		
		return nuevoPlano;
	}
	
	public int obtenerAncho(){
		return this.dimensionM;
	}
	
	public int obtenerAlto(){
		return this.dimensionN;
	}

}