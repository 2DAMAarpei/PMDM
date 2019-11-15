package com.example.examen_ud1_aaron_palmer_peiro;

import java.io.Serializable;

public class Pizza implements Serializable {
    String nombre, descripcion;
    float precio;
    int imagen;
    public Pizza(String nombre,String descripcion,float precio, int imagen){
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.precio=precio;
        this.imagen=imagen;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio){
        this.precio=precio;
    }
    public int getImagen() {
        return imagen;
    }
    public void setImagen(int imagen){
        this.imagen=imagen;
    }

}
