/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7_ej9;

import ej4.Deportivo;
import ej4.Furgoneta;
import ej4.MetodosNecesarios;
import ej4.Turismo;
import ej4.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class Ej7LecturaEjer4 {

    public static void ordenarAlquilerMatricula(ArrayList<Vehiculo> lista) {
        //Ponemos el cast de int porque solo nos interesa saber si es número positivo, negativo o 0
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
        Collections.sort(lista, criterio);
    }

    public static void main(String[] args) {
        ArrayList<Vehiculo> listaLeida = leerFicheroScanner("vehiculos.TXT");
        ArrayList<Deportivo> listaDeportivos = new ArrayList<>();
        ArrayList<Furgoneta> listaFurgoneta = new ArrayList<>();
        ArrayList<Turismo> listaTurismos = new ArrayList<>();
        for (Vehiculo vehiculo : listaLeida) {
            System.out.println(vehiculo.getAtributos());
        }
        System.out.println("-------------------Ordenando por marca--------------------");
        ordenarAlquilerMatricula(listaLeida);
        for (Vehiculo vehiculo : listaLeida) {
            System.out.println(vehiculo.getAtributos());
        }

        for (Vehiculo vehiculo : listaLeida) {
            if (vehiculo instanceof Furgoneta) {
                // Usamos metodo write() para escribir en el buffer

                listaFurgoneta.add((Furgoneta) vehiculo);

            } else if (vehiculo instanceof Deportivo) {
                listaDeportivos.add((Deportivo) vehiculo);

            } else {
                listaTurismos.add((Turismo) vehiculo);

            }
        }
        MetodosNecesarios.escrituraVehiculos("furgonetas.csv", listaFurgoneta);
        MetodosNecesarios.escrituraVehiculos("deportivos.csv", listaDeportivos);
        MetodosNecesarios.escrituraVehiculos("turismos.csv", listaTurismos);

    }

    public static ArrayList<Vehiculo> leerFicheroScanner(String fichero) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + fichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(fichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                //remplazamos todas las comillas que haya en las lineas que se lean
                linea = linea.replace("\"", "");
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                for (String string : tokens) {
                    if (tokens[0].contains("0")) {
                        Furgoneta furgo = new Furgoneta();
                        furgo.setBastidor(Long.parseLong(tokens[1]));
                        furgo.setMatricula(tokens[2]);
                        furgo.setMarca(tokens[3]);
                        furgo.setModelo(tokens[4]);
                        furgo.setColor(tokens[5]);
                        furgo.setTarifa(Double.parseDouble(tokens[6]));
                        furgo.setDisponible(Boolean.parseBoolean(tokens[7]));
                        furgo.setCarga(Integer.parseInt(tokens[8]));
                        furgo.setVolumen(Integer.parseInt(tokens[9]));
                        listaVehiculos.add(furgo);

                        break;

                    } else if (tokens[0].contains("1")) {
                        Deportivo depor = new Deportivo();
                        depor.setBastidor(Long.parseLong(tokens[1]));
                        depor.setMatricula(tokens[2]);
                        depor.setMarca(tokens[3]);
                        depor.setModelo(tokens[4]);
                        depor.setColor(tokens[5]);
                        depor.setTarifa(Double.parseDouble(tokens[6]));
                        depor.setDisponible(Boolean.parseBoolean(tokens[7]));
                        depor.setCilindrada(Integer.parseInt(tokens[8]));
                        listaVehiculos.add(depor);

                        break;
                    } else {
                        Turismo turis = new Turismo();
                        turis.setBastidor(Long.parseLong(tokens[1]));
                        turis.setMatricula(tokens[2]);
                        turis.setMarca(tokens[3]);
                        turis.setModelo(tokens[4]);
                        turis.setColor(tokens[5]);
                        turis.setTarifa(Double.parseDouble(tokens[6]));
                        turis.setDisponible(Boolean.parseBoolean(tokens[7]));
                        turis.setPuertas(Integer.parseInt(tokens[8]));
                        turis.setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));
                        listaVehiculos.add(turis);
                        break;

                    }

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaVehiculos;
    }
}
