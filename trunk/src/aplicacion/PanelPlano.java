package aplicacion;

import java.awt.GridLayout;

import javax.swing.JPanel;

import ConstruccionGeneral.Posicion;
import Jugador.Jugador;
import vista.ListaDeVistas;
import vista.VistaModeloDato;



public class PanelPlano extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListaDeVistas listaDeVistas;
	
	public PanelPlano(Jugador jugador){
		
		listaDeVistas = new ListaDeVistas();
		
		int dimensionX = jugador.obtenerPlano().obtenerAncho();
		int dimensionY = jugador.obtenerPlano().obtenerAlto();
		setLayout(new GridLayout(dimensionX,dimensionY));
	
		for (int i = 1; i < dimensionX; i++) {
			for (int j = 1; j < dimensionY; j++) {
				VistaModeloDato vista = new VistaModeloDato(new Posicion(i,j),jugador);
				listaDeVistas.agregar(vista);
				add(vista);
			}
		}
		
		setOpaque(true);

	}
	
}
