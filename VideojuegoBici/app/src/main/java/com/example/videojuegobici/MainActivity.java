package com.example.videojuegobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bJuego;
    private Button bPreferencias;
    private Button bAcercaDe;
    private Button bSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bJuego=(Button)findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaJuego(getApplicationContext());
            }
        });
        bAcercaDe=(Button)findViewById(R.id.Boton03);
/*        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAcercaDe();
            }

        });*/
        bSalir=findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.exit(0);
            }
        });

    }
    public void lanzaJuego(Context context){
            Intent activityIntent=new Intent(context,Juego.class);
            startActivity(activityIntent);
    }

}
