package vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controlador.ControladorMouse;
import ConstruccionGeneral.Posicion;
import modelo.ModeloObservable;


public class VistaModeloDato extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Posicion posicion;
	private ModeloObservable modelo;
	

	
   public VistaModeloDato(Posicion posicion, ModeloObservable modelo) {

        this.setPosicion(posicion);
        this.modelo = modelo;
        this.modelo.addObserver(this);
        addMouseListener(new ControladorMouse(modelo, this));

    }
	@Override
	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

		

}