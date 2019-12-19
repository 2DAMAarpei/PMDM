package com.example.examen_ud1_version_mejorada;

import java.io.Serializable;

public class Factura implements Serializable {
    private int idImagen;
    private String modelo, precio, extras, tiempo, seguro,costeTotal;

    public Factura(int idImagen,String modelo, String precio,String extras,String tiempo,String costeTotal, String seguro ){
        this.idImagen=idImagen;
        this.modelo=modelo;
        this.precio=precio;
        this.extras=extras;
        this.tiempo=tiempo;
        this.costeTotal=costeTotal;
        this.seguro=seguro;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
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

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(String costeTotal) {
        this.costeTotal = costeTotal;
    }
}
