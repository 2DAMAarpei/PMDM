package com.example.videojuegobici;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Juego extends AppCompatActivity {
    private Button bHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        VistaJuego vistaJuego=new VistaJuego(getApplicationContext());
        LinearLayout linearLayout=findViewById(R.id.linearLayoutJuego);
        linearLayout.addView(vistaJuego);
        bHome=findViewById(R.id.btn_home);
        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverAlHome(getApplicationContext());
            }
        });
    }
    public void volverAlHome(Context context){
        Intent activityIntent=new Intent(context,MainActivity.class);
        finish();
        startActivity(activityIntent);
    }
}
