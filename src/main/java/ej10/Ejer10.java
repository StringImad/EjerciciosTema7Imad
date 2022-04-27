/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej10;

import ej4.MetodosNecesarios;
import ej7_ej9.Ej7LecturaEjer4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author imad
 */
public class Ejer10 {

    public static void main(String[] args) {
        System.out.println("-----------------Creando directorio copias--------------------");
        Utilidades.Servicios.crearDirectorio("Copias");
        System.out.println("-----------------Copiando ficheros a carpeta copias-----------------------");
        copiarFichero("./furgonetas.csv", "./Copias/furgonetas.csv");
        copiarFichero("./deportivos.csv", "./Copias/deportivos.csv");
        copiarFichero("./turismos.csv", "./Copias/turismos.csv");
        System.out.println("--------------------------listando ficheros en la carpeta copias----------------------------");
        mostrarFicherosCarpeta("./Copias");
    }

    public static void copiarFichero(String ficheroACopiar, String ruta) {
        Path origen = Paths.get(ficheroACopiar);
        Path destino = Paths.get(ruta);
        try {

            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");

        }

    }

    public static void mostrarFicherosCarpeta(String ruta) {
        File f = new File(ruta);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

    }
}
