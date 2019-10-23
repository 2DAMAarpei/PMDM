package com.example.diferentesformasdeinvocareventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn=(Button)findViewById(R.id.button3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Pulsado boton Tres",Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void CmdDos_click(View v){
        Toast.makeText(getApplicationContext(),"Pulsado boton Dos",Toast.LENGTH_SHORT).show();
    }
}
