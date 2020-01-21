package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public DataBaseHelper cliBDh=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliBDh=new DataBaseHelper(this);
        cliBDh.open();
        if(cliBDh!=null){
            for (int i =0;i<3;i++){
                int codigo=i;
                String nombre="cli"+i;
                String telefono=i+"XXXXXXXX";
                cliBDh.insertItem(codigo,nombre,telefono);
            }
        }
        cliBDh.close();
    }
}
