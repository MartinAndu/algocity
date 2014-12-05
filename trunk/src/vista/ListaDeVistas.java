package vista;

import java.util.LinkedList;

public class ListaDeVistas {
	private LinkedList<VistaModeloDato> lista;

	public ListaDeVistas(){
		this.lista = new LinkedList<VistaModeloDato>();
	}

	public void agregar(VistaModeloDato vista) {
		this.lista.add(vista);
		
	}

}