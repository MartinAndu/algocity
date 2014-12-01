package vista;



import java.awt.Container;






import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelMenu;
	private Menu panelImagen;
	private JButton inicioPartida,continuarPartida,verPuntaje,salir;
	

	
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
		panelImagen.setBackground(Imagen.loadImg("Images/Walls/Manhattan 1988.jpg"));
	}
	
	private void inicializarPanelMenu(){
		panelMenu = new JPanel();
		//panelMenu.setBounds(x, y, width, height);
		panelMenu.setBounds(150,150,200,265);
		panelMenu.setLayout(new FlowLayout());
		
		inicioPartida = new JButton(new ImageIcon(Imagen.loadImg("Images/Walls/Iniciar Partida.jpg")));
		inicioPartida.addActionListener(this);
		panelMenu.add(inicioPartida);
		continuarPartida = new JButton(new ImageIcon(Imagen.loadImg("Images/Walls/Continuar Partida.jpg")));
		continuarPartida.addActionListener(this);
		panelMenu.add(continuarPartida);
		verPuntaje = new JButton(new ImageIcon(Imagen.loadImg("Images/Walls/Ver Puntajes.jpg")));
		verPuntaje.addActionListener(this);
		panelMenu.add(verPuntaje);
		salir = new JButton(new ImageIcon(Imagen.loadImg("Images/Walls/Salir.jpg")));
		salir.addActionListener(this);
		panelMenu.add(salir);
		
	}
	


	public void mostrarVentana(){
		this.setVisible(true);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == inicioPartida)
			System.out.print("InicioPartida");
		if (e.getSource() == salir)
			System.exit(0);
		
	}
	




}
