/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author MSI
 */
public class PruebaApp {

    public static void main(String[] args) throws JAXBException, IOException {
        ArrayList<App> listaApps = new ArrayList<>();
        //Crea 50 aplicaciones usando el constructor por defecto,
        for (int i = 0; i < 50; i++) {
            //guárdalas en una lista 
            listaApps.add(new App());
        }
        //muéstralas por pantalla. 
        listaApps.forEach(System.out::println);
        Utilidades.Servicios.crearDirectorio("./appstxt");
        escrituraAppsTxt("./appstxt/aplicacionestxt.txt", listaApps);
        Utilidades.Servicios.crearDirectorio("./appsxml");
        escrituraAppsTxt("./appsxml/aplicacionesxml.xml", listaApps);
        Utilidades.Servicios.crearDirectorio("./appsjson");
        escrituraAppsJson("./appsjson/aplicacionesjson.json", listaApps);
        Utilidades.Servicios.crearDirectorio("./copias");

        copiarFichero("./appstxt/aplicacionestxt.txt", "./copias");
        copiarFichero("./appsxml/aplicacionesxml.xml", "./copias");
        copiarFichero("./appsjson/aplicacionesjson.json", "./copias");
        Utilidades.Servicios.crearDirectorio("./aplicaciones");
        for (App listaApp : listaApps) {
            escrituraAppsTxtAplicaciones("./aplicaciones/"+listaApp.getNombre(), listaApp);

        }
    }

    public static void copiarFichero(String ficheroACopiar, String ruta) {
        Path origen = Paths.get(ficheroACopiar);
        Path destino = Paths.get(ruta);
        try {

            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiando con exito");
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");

        }

    }

    public static void escrituraAppsTxt(String idFichero, ArrayList lista) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        //idfichero

        ArrayList<App> listaAEscribir = lista;

// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //Cabecero

            for (App ap : listaAEscribir) {
                // Usamos metodo write() para escribir en el buffer

                flujo.write(ap.toString());

                // Metodo newLine() añade línea en blanco
                flujo.newLine();

            }

            // Usamos metodo write() para escribir en el buffer
            // Metodo newLine() añade línea en blanco
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
 public static void escrituraAppsTxtAplicaciones(String idFichero, App ap) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        //idfichero


// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //Cabecero

                // Usamos metodo write() para escribir en el buffer

                flujo.write(ap.toString());

                // Metodo newLine() añade línea en blanco
                flujo.newLine();


            // Usamos metodo write() para escribir en el buffer
            // Metodo newLine() añade línea en blanco
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void escrituraAppsXml(String idFichero, ArrayList lista) throws JAXBException {

        // Se preparan los objetos a utilizar, en esta caso un catálogo
        ArrayList<App> listaM = lista;
        CatalogoApps catalogo = new CatalogoApps();
        catalogo.setLista(listaM);
        catalogo.setDescripcion("Mi catalogo");

        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);

        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();

        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File("catalogo.xml"));

    }

    public static void escrituraAppsJson(String idFichero, ArrayList lista) throws JAXBException, IOException {
        ObjectMapper mapeador = new ObjectMapper();

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idFichero), lista);
    }

}
