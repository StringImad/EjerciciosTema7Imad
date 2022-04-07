/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author imad
 */
public class GeneradorMatrizTxt_Imad {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "matriz.txt";
        int numDefilas = 4;
        int numDeColumnas = 4;

        // Array a escribir
        int numeros[][] = new int[numDefilas][numDeColumnas];
        int sumaDeNumeros = 100;
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

            for (int[] is : numeros) {
                int num1 = 0;

                for (int i : is) {
                    i += num1 + sumaDeNumeros;
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write(i + "\t");
                    ++num1;
                }
                sumaDeNumeros += 100;
                // Metodo newLine() añade línea en blanco
                flujo.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
