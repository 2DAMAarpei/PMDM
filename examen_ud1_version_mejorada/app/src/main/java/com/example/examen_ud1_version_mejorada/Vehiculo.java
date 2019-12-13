package com.example.examen_ud1_version_mejorada;

import android.media.Image;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Vehiculo implements Serializable {
    private String modelo;
    private String precio;
    private String tipo;
    private int imagen;
    public Vehiculo(String tipo,String modelo,String precio,int imagen){
        this.modelo=modelo;
        this.imagen=imagen;
        this.precio=precio;
        this.tipo=tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
