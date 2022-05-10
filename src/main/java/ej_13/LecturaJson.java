/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ej_11.App;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class LecturaJson {
       public static void main(String[] args) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<App> catalogo = mapeador.readValue(new File("./appsjson/aplicacionesjson.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));
        System.out.println("---- Catálogo----");
        for (App ap : catalogo) {
            System.out.println(ap);
        }
       
    }
}
