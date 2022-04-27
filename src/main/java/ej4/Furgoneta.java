/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

/**
 *
 * @author imad
 */
public class Furgoneta extends Vehiculo {
    // Atributos específicos

    private int carga;
    private int volumen;

    public Furgoneta() {
        this.carga = MetodosNecesarios.generadorNumeroAleatorioEntreDosRangos(250, 3000);
        this.volumen = MetodosNecesarios.generadorNumeroAleatorioEntreDosRangos(1000, 5000);
    }

    public Furgoneta(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, int carga, int volumen) {
        super(bastidor, matricula, marca, modelo, color, tarifa); // Constructor padre
        this.carga = carga;
        this.volumen = volumen;
    }
// métodos ‘get’ de la subclase Furgoneta. Se omiten setters

    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
    return super.getAtributos() + ":" + this.carga
                + ":" + this.volumen;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + ":" + this.carga
                + ":" + this.volumen;
    }

}
