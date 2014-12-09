package aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Ambientes.Ambiente;
import Jugador.Jugador;
import Jugador.JugadorMedio;
import Jugador.Turno;

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
	private Jugador jugador;
	private Turno turno;
	
	FramePlano(){
		super("Mapa General");
		this.setBounds(0,0,500,500);
		this.setLayout(new BorderLayout());
		
		
		//Inicializa clase jugador que va a ser el modelo y el turno
		this.jugador = new JugadorMedio();
		Ambiente ambiente = jugador.generarAmbiente();
		this.turno = new Turno(jugador,ambiente);
		
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
		bar = new JPanel();
		bar.setBounds(0, 0, 500, 100);
		bar.setBackground(Color.GRAY);
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
		panelDeConstruccion = new PanelDeConstruccion(jugador,panelPlano);
	}
	
	private void inicializarPanelPlano(){
		panelPlano = new PanelPlano(this.jugador);
	}
	public void mostrarVentana(){
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
