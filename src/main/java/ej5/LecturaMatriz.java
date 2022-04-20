/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class LecturaMatriz {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "ej1_archivos/matriz.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int sumaTotal = 0;
        System.out.println("Leyendo el fichero: " + idFichero);

        // El mismo ejemplo pero separando cada elemento
        // leído usando el método split() de la clase String */
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            System.out.println("Separando cada elemento del fichero: ");

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split("\t");

                for (String string : tokens) {
                    sumaTotal += Integer.valueOf(string);
                    System.out.print(string + "\t");
                }
                System.out.println();
            }
            System.out.println("Suma total: "+sumaTotal);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
