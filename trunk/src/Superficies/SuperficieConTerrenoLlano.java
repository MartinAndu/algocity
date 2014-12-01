package Superficies;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SuperficieConTerrenoLlano extends Superficie{

	public boolean sePuedeConstruirUnPozoDeAgua(){
		return false;
	}

	public boolean sePuedeConstruirUnEdificioOCentral() {
		return true;
	}

	public Node serializar(Document doc) {
		Element elementoSuperficie = doc.createElement("Superficie");
		elementoSuperficie.setAttribute("tipo", "tierra");
		return elementoSuperficie;
	}
}
