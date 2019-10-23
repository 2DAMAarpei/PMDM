package com.example.listaelementosobjeto;
import android.widget.ImageView;

import java.io.Serializable;

public class Titular implements Serializable {
    private String titulo;
    private String subtitulo;
    private int foto;

    Titular (String titulo,String subtitulo,int foto){
        this.titulo=titulo;
        this.subtitulo=subtitulo;
        this.foto=foto;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
