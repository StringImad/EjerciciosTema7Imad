/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class LecturaEjer3LetrasAleatorias {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "ej3_archivos/teclado.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        System.out.println("Leyendo el fichero: " + idFichero);

        // El mismo ejemplo pero separando cada elemento
        // leído usando el método split() de la clase String */
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            System.out.println("Separando cada elemento del fichero: ");
            String palabraWeb = "web", palabraEncontrada = "";
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(";");
                for (int i = 0; i < tokens.length; i++) {
                    System.out.print(tokens[i]);
                        if (tokens[i].equalsIgnoreCase("w")) {
                            palabraEncontrada += tokens[i];
                            System.out.println("\nposicion de w: " + i);
                        } else if (tokens[i].equalsIgnoreCase("e")) {
                            System.out.println("\nposicion de e: " + i);
                            palabraEncontrada += tokens[i];

                        } else if (tokens[i].equalsIgnoreCase("b")) {
                            System.out.println("\nposicion de b: " + i);
                            palabraEncontrada += tokens[i];

                        }
                        if(palabraEncontrada.equalsIgnoreCase("web")){
                            
                        }
                }
//                for (String string : tokens) {
//
//                    System.out.print(string);
//                    if (string.equalsIgnoreCase("w")) {
//                        System.out.println("\nposicion de w: " + i);
//                    }
//                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
