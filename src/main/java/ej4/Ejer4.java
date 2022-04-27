/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

import java.util.ArrayList;

/**
 *
 * @author imad
 */
public class Ejer4 {

    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Turismo());
        }
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Deportivo());

        }
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Furgoneta());

        }
        
        MetodosNecesarios.escrituraVehiculos("vehiculos.TXT", listaVehiculos);
        

    }
}
