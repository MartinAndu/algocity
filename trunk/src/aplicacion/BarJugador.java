package aplicacion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Jugador.Jugador;

public class BarJugador extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3859833278746555327L;
	
	private JTextField poblacion,dinero,dia,nombreJugador;
	private Jugador jugador;
	
	public BarJugador(Jugador jugador){

		this.setBounds(0, 0, 500, 100);
		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout());
		poblacion = new JTextField("Poblacion:" + jugador.obtenerCantidadPoblacion());
		dinero = new JTextField("Dinero:$" + jugador.darCantDineroEnPresupuesto());
		dia = new JTextField("Dia:" + jugador.obtenerNumeroDeDia());
		nombreJugador = new JTextField(jugador.obtenerNombre());
		
		
		this.add(poblacion);
		this.add(dinero);
		this.add(dia);
		this.add(nombreJugador);
		
		this.jugador = jugador;
		jugador.addObserver(this);
		
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		dinero.setText("Dinero:$" + jugador.darCantDineroEnPresupuesto());
		poblacion.setText("Poblacion:" + jugador.obtenerCantidadPoblacion());
		dia.setText("Dia:" + jugador.obtenerNumeroDeDia());
		
	}
	
	
	

}
