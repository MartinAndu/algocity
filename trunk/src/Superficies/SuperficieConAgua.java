package Superficies;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SuperficieConAgua extends Superficie {
	
	public boolean sePuedeConstruirUnPozoDeAgua(){
		return true;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return false;
	}

	public Node serializar(Document doc) {
		Element elementoSuperficie = doc.createElement("Superficie");
		elementoSuperficie.setAttribute("tipo", "agua");
		return elementoSuperficie;
	}
}
