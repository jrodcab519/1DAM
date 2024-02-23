import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ut6_05_04_02 {

    public static void main(String[] args) {
        File fichero = new File("peliculas.xml");

        Map<String, Integer> apartado2 = new LinkedHashMap<>();

        // apartado 2
        try {
            // Crear DocumentBuilder
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Procesar fichero XML
            Document doc = documentBuilder.parse(fichero);

            // Buscar los nodos que tengan como nombre "pelicula"
            NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

            // Recorrer las películas
            for (int i = 0; i < listaPeliculas.getLength(); i++) {
                Node nodoPelicula = listaPeliculas.item(i);
                // Si es un elemento... procesarlo
                if (nodoPelicula.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPelicula = (Element) nodoPelicula;
                    NodeList reparto = elementoPelicula.getElementsByTagName("reparto");

                    String titulo = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();
                    apartado2.put(titulo, reparto.getLength());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(apartado2);
    }
}
