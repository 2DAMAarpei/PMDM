package com.example.videojuegobici;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Juego extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        VistaJuego vistaJuego=new VistaJuego(getApplicationContext());
        LinearLayout linearLayout=findViewById(R.id.linearLayoutJuego);
        linearLayout.addView(vistaJuego);

    }
}
