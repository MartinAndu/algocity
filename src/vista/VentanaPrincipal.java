package vista;



import java.awt.Color;
import java.awt.Container;






import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class VentanaPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMenu;
	private Menu panelImagen;
	

	
	public VentanaPrincipal() {
		super("AlgoCity");
		inicializarVentana();
		
	}

	private void inicializarVentana() {
		
    	this.setBounds(0,0,500,500);
    	
    	Container c= getContentPane();
    
    	
    	inicializarPanelMenu();
    	inicializarPanelImagen();
    	
    	c.add(panelMenu);
    	c.add(panelImagen);
    	
    	
    	this.setContentPane(c);

	}
	
	private void inicializarPanelImagen(){
		panelImagen = new Menu();
		panelImagen.setBounds(0,0,500,500);
		new Imagen();
		panelImagen.setBackground(Imagen.loadImg("Images/Walls/Park.jpg"));
	}
	
	private void inicializarPanelMenu(){
		panelMenu = new JPanel();
		//panelMenu.setBounds(x, y, width, height);
		panelMenu.setBounds(150,150,110,150);
		panelMenu.setLayout(new FlowLayout());
		panelMenu.add(new JButton("Iniciar Partida"));
		panelMenu.add(new JButton("Continuar Partida"));
		panelMenu.add(new JButton("Ver Puntajes"));
		panelMenu.add(new JButton("Salir"));
		panelMenu.setBackground(Color.WHITE);
	}
	


	public void mostrarVentana(){
		this.setVisible(true);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	




}
