package com.example.menufiguras;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Window_Area extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Bundle recogerDatos=getIntent().getExtras();
        setContentView(R.layout.objects_area_rectangle);

        /*switch(recogerDatos.getInt("option")){
            case 1:
                break;

            case 2:
                setContentView(R.layout.objects_area_circle);
                break;

            case 3:
                setContentView(R.layout.objects_area_triangle);
                break;

            case 4:
                setContentView(R.layout.objects_area_square);
                break;

            default:
                break;
        }*/




    }
}
