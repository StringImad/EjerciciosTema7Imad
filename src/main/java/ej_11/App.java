/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_11;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 *
 * @author MSI
 */
public class App {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double kB;
    private int numDescargas;
    private static int contadorDeInstancias;

    public App() {
        this.codigo = contadorDeInstancias++;
        this.nombre = "app" + this.codigo + (char) Utilidades.Servicios.generadorNumeroAleatorioEntreDosRangos(97, 122);
        this.descripcion = crearDescripcion();
        this.kB = generarKb(1, 100, 1024);
        this.numDescargas = generarDesc(1, 0, 50000);
    }

    public App(int codigo, String nombre, String descripcion, double kB, int numDescargas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.kB = kB;
        this.numDescargas = numDescargas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getkB() {
        return kB;
    }

    public void setkB(double kB) {
        this.kB = kB;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public static int getContadorDeInstancias() {
        return contadorDeInstancias;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");

        return codigo + ";" + nombre + ";" + descripcion + ";" + df.format(kB) + ";" + numDescargas;
    }

    public static int generarDesc(int tamañoStream, int valorInicial, int valorFinal) {
        Random aleatorio = new Random();
        return aleatorio.ints(tamañoStream, valorInicial, valorFinal).sum();
    }

    public static String crearDescripcion() {
        String[] nombres = "Fifa 12,Clash of Clan,Clash Royale,Snapchat,Instagram,Whatsapp,Twitter,Chrome".split("\\,");
        String descripAle = nombres[Utilidades.Servicios.generadorNumeroAleatorioEntreDosRangos(0, 7)];

        return descripAle;
    }

    public static double generarKb(int tamañoStream, double valorInicial, double valorFinal) {

        Random aleatorio = new Random();
        return aleatorio.doubles(tamañoStream, valorInicial, valorFinal).sum();
    }

}
