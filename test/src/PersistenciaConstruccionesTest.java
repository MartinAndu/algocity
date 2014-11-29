package src;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import Edificios.Construccion;
import Edificios.EdificioResidencial;
import Edificios.Posicion;

public class PersistenciaConstruccionesTest {

	private String nombreArchivo;

	@Before
	public void before() {
		this.nombreArchivo = java.util.UUID.randomUUID().toString() + ".xml"; // Genera un nombre de archivo aleatorio para el archivo XML.
	}
	
	@After
	public void after() { // Elimina el archivo XML generado al correr la prueba una vez verificados los valores correspondientes.
		// (para ver el archivo XML generado borrar este bloque de codigo, el xml se genera en la carpeta donde esta el astah con los diagramas).
		File archivo = new File(this.nombreArchivo);
		if (archivo.exists()) {
			archivo.delete();
		}
	}

	
	@Test
	public void guardarYRecuperar() throws ParserConfigurationException, TransformerException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Posicion posicion1 = new Posicion(5,5);
		EdificioResidencial construccion1ConPosicion1 = new EdificioResidencial(posicion1);

		Element construccionSerializada = construccion1ConPosicion1.serializar(doc);
		Assert.assertNotNull(construccionSerializada);
		
		// Hasta aca se serializo la construccion con todo su contenido, ahora la bajo al disco:

		doc.appendChild(construccionSerializada);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivoDestino = new File(this.nombreArchivo);
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source, result);
		
		File archivo = new File(this.nombreArchivo);
		Assert.assertTrue(archivo.exists());
		
		// Ahora se levanta el archivo antes bajado al disco y verifico que los objetos se "hidratan" correctamente.

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Construccion construccionCargada = Construccion.hidratar(doc);
		Assert.assertNotNull(construccionCargada);
		Assert.assertEquals(construccion1ConPosicion1.devolverPosicionEnString(), construccionCargada.devolverPosicionEnString());
	}

}