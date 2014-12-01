package Superficies;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


public abstract class Superficie{
	public abstract boolean sePuedeConstruirUnPozoDeAgua();
	
	public abstract boolean sePuedeConstruirUnEdificioOCentral();

	public abstract Node serializar(Document doc);
}
