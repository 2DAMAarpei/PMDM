package com.example.listasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lview;
    final static String semana[]={"lunes","martes","miercoles","jueves","viernes","sabado"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String mensaje;
        lview=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> miAdpatador=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,semana);
        lview.setAdapter(miAdpatador);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje="";
                mensaje="Item clicked =>"+semana[position];
                showToast(mensaje);
            }

        });
    }
    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
