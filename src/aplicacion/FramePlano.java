package aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;












import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Juego.AlgoCity;

public class FramePlano extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel bar;	
	private JPanel panelLeft;
	private PanelDeConstruccion panelDeConstruccion;
	private JPanel panelDeInteraccion;
	private PanelPlano panelPlano;
	private JButton guardar,salir;
	private AlgoCity algoCity;
	
	FramePlano(AlgoCity algoCity){
		super("Mapa General");
		this.setBounds(0,0,1300,700);
		this.setLayout(new BorderLayout());
		this.algoCity = algoCity;
		
		
		
		//Inicializa clase jugador que va a ser el modelo y el turno
		
		Container c = this.getContentPane();
		
		
		inicializarPanelArriba();
		

		inicializarPanelIzquierda();
		inicializarPanelPlano();
		inicializarPanelConstruccion();
		inicializarBotones();
		
		panelLeft.add(panelDeConstruccion);
		panelLeft.add(panelDeInteraccion);
		c.add(panelLeft,BorderLayout.WEST);
		c.add(panelPlano,BorderLayout.CENTER);
		c.add(bar,BorderLayout.NORTH);

		
		this.setContentPane(c);
	}
	
	private void inicializarPanelArriba(){
		bar = new BarJugador(algoCity.obtenerJugadorActual());
		
	}
	
	private void inicializarPanelIzquierda(){
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(2,1));
	}
	
	private void inicializarBotones(){

		panelDeInteraccion = new JPanel();
		guardar = new JButton("Guardar");
		salir = new JButton("Salir");
		

		panelDeInteraccion.add(guardar);
		panelDeInteraccion.add(salir);
		
	}
	
	private void inicializarPanelConstruccion(){
		panelDeConstruccion = new PanelDeConstruccion(algoCity.obtenerJugadorActual(),panelPlano);
	}
	
	private void inicializarPanelPlano(){
		panelPlano = new PanelPlano(algoCity.obtenerJugadorActual());
	}
	public void mostrarVentana(){
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guardar)
			algoCity.guardarPartida();
		if (e.getSource() == salir){
			try {
				algoCity.finalizar(algoCity.obtenerJugadorActual());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
