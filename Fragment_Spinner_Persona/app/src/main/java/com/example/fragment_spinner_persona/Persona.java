package com.example.fragment_spinner_persona;

import java.io.Serializable;

/**
 * Created by angel on 22/09/2016.
 */
public class Persona implements Serializable {
    private String nombre,apellido,trabajos,estudios;
    private int edad;

    public String getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(String trabajos) {
        this.trabajos = trabajos;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    private int foto;

    Persona(String nombre, String apellido, int edad, int foto, String trabajos, String estudios){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.foto=foto;
        this.trabajos=trabajos;
        this.estudios=estudios;
    }

    public String getNombre (){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }

    public void setNombre(String nuevoNom){
        nombre=nuevoNom;
    }
    public void setApellido(String nuevoApe){
        apellido= nuevoApe;
    }
    public void setEdad (int num){
        edad=num;
    }
    public String toString(){
        String cad="";
        cad+="NOMBRE:"+ nombre+ " APELLIDO:" + apellido + " EDAD:" + edad;
        return cad;
    }

}
