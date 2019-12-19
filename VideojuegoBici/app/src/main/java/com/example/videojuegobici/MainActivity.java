package com.example.videojuegobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button bJuego;
    private Button bSalir;
    private Button bHome;
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
        bSalir=findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.exit(0);
            }
        });
        bHome=findViewById(R.id.btn_home);
        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverAlHome(getApplicationContext());
            }
        });

    }
    public void lanzaJuego(Context context){
            Intent activityIntent=new Intent(context,Juego.class);
            finish();
            startActivity(activityIntent);
    }
    public void volverAlHome(Context context){
        Intent activityIntent=new Intent(context,MainActivity.class);
        finish();
        startActivity(activityIntent);
    }

}
