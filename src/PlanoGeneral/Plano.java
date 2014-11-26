package PlanoGeneral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Edificios.Posicion;
import PlanoDireccion.Direccion;
import PlanoDireccion.Norte;
import PlanoGeneradores.GeneradorDireccion;
import PlanoGeneradores.GeneradorDireccionDeterminista;
import PlanoGeneradores.GeneradorPosicion;
import PlanoGeneradores.GeneradorPosicionDeterminista;
import PlanoGeneradores.GeneradorRecorrido;
import PlanoGeneradores.GeneradorRecorridoDeterminista;


public class Plano {

	private HashMap<String, Hectarea> hectareas;
	private HashMap<Hectarea, ArrayList<Hectarea>> caminos;
	private GeneradorPosicion generadorPosicion;
	private GeneradorDireccion generadorDireccion;
	private GeneradorRecorrido generadorRecorrido;
	private int ancho;
	private int alto;
 
	public Plano(int dimensionN, int dimensionM) {
		alto = dimensionN;
		ancho = dimensionM;
		hectareas = new HashMap<String, Hectarea>();
		caminos = new HashMap<Hectarea, ArrayList<Hectarea>>();
		generadorPosicion = new GeneradorPosicionDeterminista(dimensionN, dimensionM);
		generadorDireccion = new GeneradorDireccionDeterminista();
		generadorRecorrido = new GeneradorRecorridoDeterminista();
		construirPlano(dimensionN, dimensionM);
	}

	public int obtenerAncho(){
		return ancho;
	}
	
	public int obtenerAlto(){
		return alto;
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

		for (int i = 1; i <= dimensionN; i++) {
			for (int j = 1; j <= dimensionM; j++) {
				
				String posicionEnString = (new Posicion(i, j)).enString();
				Hectarea hectarea = new Hectarea();
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

	private int calcularMayorDistanciaALosLimites(Posicion posicion) {
		
		int diferenciaPosicionAncho = this.ancho - posicion.devolverCoordenadaX();
		int diferenciaPosicionAlto = this.alto - posicion.devolverCoordenadaY();
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
	
	public Recorrido generarRecorridolAleatorio() {
		
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

}