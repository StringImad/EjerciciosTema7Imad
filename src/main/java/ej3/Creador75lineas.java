/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;

import Utilidades.Servicios;
import static Utilidades.Servicios.generadorNumeroAleatorioEntreDosRangos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class Creador75lineas {

    public static void main(String[] args) throws IOException {
        Servicios.crearDirectorio("ej3_archivos");
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "ej3_archivos/teclado.txt";

        // texto a escribir
        String textoUsuario;
        //Declaracion de objeto scanner
        Scanner teclado = new Scanner(System.in);
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

            // Usamos metodo write() para escribir en el buffer
            for (int i = 0; i < 75; i++) {
                flujo.write(letrasGeneradas() + "\n");
            }
            // Metodo newLine() añade línea en blanco
            //}
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String letrasGeneradas() {
        String letras = "";
        int letra;
        do {
           
            letra = letrasGeneradasAleatorias();
            letras += (char) letra + ";";
        } while (letra != 71 &&letra != 103);
        return letras;
    }

    public static int letrasGeneradasAleatorias() {
        Random aleatorio = new Random();
        if (aleatorio.nextBoolean()) {
            return generadorNumeroAleatorioEntreDosRangos(65, 90);
        } else {
            return generadorNumeroAleatorioEntreDosRangos(97, 122);

        }
    }

}
