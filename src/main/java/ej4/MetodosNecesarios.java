/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author MSI
 */
public class MetodosNecesarios {

    public static String crearMarca() {
        String[] nombres = "Seat,Audi,Mercedes,Bmw,LandRover,Opel,Ford".split("\\,");
        String marcaAleatoria = nombres[generadorNumeroAleatorioEntreDosRangos(0, 6)];

        return marcaAleatoria;
    }

    public static String crearModelo() {
        String[] nombres = "Leon,rs7,amg gtr,m3,sqv,opc,mondeo".split("\\,");
        String modeloAleatoria = nombres[generadorNumeroAleatorioEntreDosRangos(0, 6)];

        return modeloAleatoria;
    }

    public static String crearColor() {
        String[] nombres = "Amarillo,Rojo,Verde,negro,blanco,rojo,morado".split("\\,");
        String colorAleatoria = nombres[generadorNumeroAleatorioEntreDosRangos(0, 6)];

        return colorAleatoria;
    }

    public static double crearTarifa() {
        String[] nombres = "120,300,4000,60,90,50,805".split("\\,");
        String tarifaAleatoria = nombres[generadorNumeroAleatorioEntreDosRangos(0, 6)];

        return Double.parseDouble(tarifaAleatoria);
    }

    public static Long crearBastidor() {
        String bastidorS = RandomStringUtils.randomNumeric(15);

        return Long.parseLong(bastidorS);

    }

    public static String crearMatricula() {
        Random aleatorio = new Random();
        String matricula = "";

        for (int i = 0; i < 7; i++) {

            if (i > 3) {
                String letras = "bcdfghjklmnñpqrstvwxyz";
                String toUpperCase = letras.toUpperCase();
                int posicion = aleatorio.nextInt(toUpperCase.length());
                char letra = toUpperCase.charAt(posicion);
                matricula += Character.toString(letra);
            } else {
                int enteroAleatorio = aleatorio.nextInt(9 - 0 + 1) + 0;
                matricula += Integer.toString(enteroAleatorio);
            }

        }
        return matricula;

    }

    public static boolean booleanoAleatorio() {
        Random aleatorio = new Random();

        return aleatorio.nextBoolean();
    }

    public static int generadorNumeroAleatorioEntreDosRangos(int RANGO_MIN, int RANGO_MAX) {
        Random aleatorio = new Random();
        return aleatorio.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
    }

    public static void escrituraVehiculos(String idFichero, ArrayList lista) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        //idfichero

        ArrayList<Vehiculo> listaAEscribir = lista;

// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //Cabecero
            flujo.write("TipoVehiculo:Matricula:Marca:Modelo:Color:Precio:Bastidor:Disponible");
            flujo.newLine();
            for (Vehiculo vehiculo : listaAEscribir) {
                if (vehiculo instanceof Furgoneta) {
                    // Usamos metodo write() para escribir en el buffer

                    flujo.write("0 - :" + ((Furgoneta) vehiculo).getAtributos());

                } else if (vehiculo instanceof Deportivo) {
                    flujo.write("1 - :" + ((Deportivo) vehiculo).getAtributos());

                } else {
                    flujo.write("2 - :" + ((Turismo) vehiculo).getAtributos());

                }
                // Metodo newLine() añade línea en blanco

                flujo.newLine();

            }

            // Usamos metodo write() para escribir en el buffer
            // Metodo newLine() añade línea en blanco
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
