package com.example.miprimerdia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    MediaPlayer musica;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton play=findViewById(R.id.play);
        logo=findViewById(R.id.logo);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(play.isChecked()){
                    musica.start();
                    logo.setVisibility(View.VISIBLE);
                }else{
                    musica.stop();
                    logo.setVisibility(View.INVISIBLE);

                }
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        musica= MediaPlayer.create(getApplicationContext(),R.raw.desigual);

    }

}
