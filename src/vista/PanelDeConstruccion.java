package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelDeConstruccion extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelDeConstruccion(){
		this.setLayout(new GridLayout(6,1));
		this.add(new JButton("Residencia"));
		this.add(new JButton("Industria"));
		this.add(new JButton("Comercio"));
		this.add(new JButton("Pozo De Agua"));
		this.add(new JButton("Tuberia"));
		this.add(new JButton("Central"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
