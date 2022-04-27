/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

/**
 *
 * @author imad
 */
public class Deportivo extends Vehiculo {

    private int cilindrada; // Atributo específico para Deportivo

    public Deportivo() {
        super();
        cilindrada = MetodosNecesarios.generadorNumeroAleatorioEntreDosRangos(1000, 6000);
    }

    public Deportivo(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, int cilindrada) {
        super(bastidor, matricula, marca, modelo, color, tarifa); // Constructor padre
        this.cilindrada = cilindrada;
    }
// métodos ‘get’ de la subclase Deportivo. Se omiten setters 

    public int getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + ":" + this.cilindrada;
    }

}
