package com.example.examen_ud1_aaron_palmer_peiro;

import java.io.Serializable;

public class Factura implements Serializable {
    int extras,numero_unidades,incremento;
    Pizza pizza;
    String envio;
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Factura(int extras, int numero_unidades, int incremento, Pizza pizza){
        this.extras=extras;
        this.incremento=incremento;
        this.numero_unidades=numero_unidades;
        this.pizza=pizza;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getNumero_unidades() {
        return numero_unidades;
    }

    public void setNumero_unidades(int numero_unidades) {
        this.numero_unidades = numero_unidades;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
}
