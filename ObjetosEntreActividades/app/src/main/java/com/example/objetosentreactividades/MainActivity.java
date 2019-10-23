package com.example.objetosentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//Hay puesto un image picker

public class MainActivity extends AppCompatActivity {
    EditText inNombre;
    EditText inApellidos;
    EditText inEdad;
    String pathFoto;
    private final static int imagenUsuario = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button botonIncial=(Button)findViewById(R.id.botonInicial);
            botonIncial.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       inNombre=findViewById(R.id.nombre);
                       inApellidos=findViewById(R.id.apellidos);
                       inEdad=findViewById(R.id.edad);

                       Intent intentIncial = new Intent(MainActivity.this,Pantalla2.class);
                       Persona persona = new Persona(inNombre.getText().toString(),inApellidos.getText().toString(),Integer.parseInt(inEdad.getText().toString()),pathFoto);
                       Bundle datos= new Bundle();
                       datos.putSerializable("persona",persona);
                       intentIncial.putExtras(datos);
                       startActivity(intentIncial);
                   }
               }
            );
    }
//Código ImagePicker
    public void pickImage(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,imagenUsuario);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == imagenUsuario && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            Uri uriFoto = data.getData();
            pathFoto=uriFoto.toString();
        }
    }

}

