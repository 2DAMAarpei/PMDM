package com.example.objetosentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView foto;
        TextView edad;
        TextView nombre;
        TextView apellidos;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Bundle recogerDatos=getIntent().getExtras();
        Persona persona=(Persona)recogerDatos.getSerializable("persona");

        edad=(TextView) findViewById(R.id.textViewEdad);
        edad.setText(String.valueOf(persona.getEdad()));

        nombre=(TextView)findViewById(R.id.textViewNombre);
        nombre.setText(String.valueOf(persona.getNombre()));

        apellidos=(TextView)findViewById(R.id.textViewApellidos);
        apellidos.setText(String.valueOf(persona.getApellido()));

        foto=(ImageView)findViewById(R.id.inputFoto);
        foto.setImageURI(Uri.parse(persona.getFoto()));

    }
}
