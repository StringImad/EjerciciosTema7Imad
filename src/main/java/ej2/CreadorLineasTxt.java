/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

import Utilidades.Servicios;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class CreadorLineasTxt {

    public static void main(String[] args) throws IOException {
        Servicios.crearDirectorio("ej2_archivos");
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "ej2_archivos/teclado.txt";

        // texto a escribir
        String textoUsuario;
        //Declaracion de objeto scanner
        Scanner teclado = new Scanner(System.in);
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

            // Usamos metodo write() para escribir en el buffer
            do {
                textoUsuario = teclado.nextLine();
                if(textoUsuario.equalsIgnoreCase("EOF")){
                    flujo.close();
                }
                flujo.write(textoUsuario+"\n");
            } while (!textoUsuario.equals("EOF"));
            // Metodo newLine() añade línea en blanco
            flujo.newLine();
            //}
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
