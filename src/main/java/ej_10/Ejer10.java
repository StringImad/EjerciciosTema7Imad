/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej_10;

import ej4.Vehiculo;
import ej7_ej9.Ej7LecturaEjer4;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        leerFicherosCarpeta("./Copias");

        ArrayList<Vehiculo> listaVehiculos = leerFicherosCarpeta("./Copias");

        for (Vehiculo listaVehiculo : listaVehiculos) {

            System.out.println(listaVehiculo.getAtributos());

        }
        System.out.println("-------------------Ordenando por bastidor-----------------");
        List<Vehiculo> lista = listaVehiculos;
        lista.stream()
                .sorted((v1, v2) -> v1.getBastidor().compareTo(v2.getBastidor()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //Borrar los ficheros *.csv originales.
        //borrarFichero("\\*.csv");???
        borrarFichero("deportivos.csv");
        mostrarFicherosCarpeta("./");
        System.out.println("-------------------------vehiculos blancos---------------------------");
//        List<Vehiculo> listaBlancos = listaVehiculos;
//        //   Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.
//
//        listaBlancos.stream()
//                .filter(v -> v.getColor().equalsIgnoreCase("blanco"))
//                .sorted((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula())).distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        imprimeCochesBlancos(listaVehiculos);
        System.out.println("----------------------------Marcas distintas--------------------------------------------");
//        List<Vehiculo> listaMarcas = listaVehiculos;
//        listaMarcas.stream()
//                //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.    
//                .filter(v -> v.isDisponible())
//                .map(p -> p.getMarca()).distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        imprimeMarcasDistintas(listaVehiculos);
        System.out.println("--------------------------------------------------------------------");
//        List<Vehiculo> saberCantidad = listaVehiculos;
//        long count = saberCantidad.stream()
//                .filter(v -> v.getMarca().equalsIgnoreCase("citroen"))
//                //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
//                .map(p -> p.getMarca()).count();
        System.out.println("Cantidad de Citroen: " + saberCantidadVehiculos(listaVehiculos));

        List<Vehiculo> hayNegroDispo = listaVehiculos;
        List<Boolean> map = hayNegroDispo.stream()
                .filter(v -> v.isDisponible() && v.getColor().equalsIgnoreCase("negro") && v.getMarca().equalsIgnoreCase("peugeot"))
                .map(p -> p.isDisponible())
                .collect(Collectors.toList());

        //Solo muestra si es true
        map.forEach(System.out::println);
    }

    public static long saberCantidadVehiculos(ArrayList listaVehiculos) {
        List<Vehiculo> saberCantidad = listaVehiculos;
        long count = saberCantidad.stream()
                .filter(v -> v.getMarca().equalsIgnoreCase("citroen"))
                //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
                .map(p -> p.getMarca()).count();
        return count;
    }

    public static void imprimeCochesBlancos(ArrayList listaVehiculos) {
        List<Vehiculo> listaBlancos = listaVehiculos;
        //   Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.
        listaBlancos.stream()
                .filter(v -> v.getColor().equalsIgnoreCase("blanco"))
                .sorted((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula())).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void imprimeMarcasDistintas(ArrayList listaVehiculos) {
        List<Vehiculo> listaMarcas = listaVehiculos;
        listaMarcas.stream()
                //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.    
                .filter(v -> v.isDisponible())
                .map(p -> p.getMarca()).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
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

    public static void borrarFichero(String ruta) {
        Path element = Paths.get(ruta);
        try {
            Files.delete(element);
        } catch (IOException e) {
            System.out.println("Problema borrando el archivo.");
            System.out.println(e.toString());
        }

    }

    public static ArrayList<Vehiculo> leerFicherosCarpeta(String ruta) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        File f = new File(ruta);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                listaVehiculos.addAll(Ej7LecturaEjer4.leerFicheroScanner(file2.getName()));
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
        return listaVehiculos;
    }

}
