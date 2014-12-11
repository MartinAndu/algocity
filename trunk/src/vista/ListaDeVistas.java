package vista;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaDeVistas {
	private LinkedList<VistaModeloDato> lista;

	public ListaDeVistas(){
		this.lista = new LinkedList<VistaModeloDato>();
	}

	public void agregar(VistaModeloDato vista) {
		this.lista.add(vista);	
	}
	

	public void verVistaNormal() {

		Iterator<VistaModeloDato> iterador = this.lista.iterator();
		
		while (iterador.hasNext()){
			iterador.next().verVistaNormal();
		}
		
	}

	public void verVistaSubterranea() {
		Iterator<VistaModeloDato> iterador = this.lista.iterator();
		
		while (iterador.hasNext()){
			iterador.next().verVistaSubterranea();
		}
	}

}