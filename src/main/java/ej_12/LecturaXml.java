/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_12;

import ej_11.App;
import ej_11.CatalogoApps;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author MSI
 */
public class LecturaXml {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoApps catalogo = (CatalogoApps) um.unmarshal(new File("./appsxml/aplicacionesxml.xml"));

        ArrayList<App> listaApps = catalogo.getListaApps();

        listaApps.forEach(System.out::println);

//        leerXML("./appsxml/aplicacionesxml.xml");
    }

    private static void leerXML(String idFichero) {

        try {
            // Crea el contexto JAXB
            JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
            // Crea el objeto Unmarshaller
            Unmarshaller um = contexto.createUnmarshaller();

            // Llama al método de unmarshalling
            CatalogoApps catalogo = (CatalogoApps) um.unmarshal(new File(idFichero));

            ArrayList<App> listaApps = catalogo.getListaApps();

            listaApps.forEach(System.out::println);
        } catch (JAXBException ex) {
            Logger.getLogger(LecturaXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
