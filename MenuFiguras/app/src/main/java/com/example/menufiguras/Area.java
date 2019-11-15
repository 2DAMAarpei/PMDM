package com.example.menufiguras;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Area extends AppCompatActivity {
    public static void calcularArea(int option,TextView resultado_Operacion,EditText[] datos){
        switch (option) {
            case  R.id.MnuOpc1Calcula:
                Button button=findViewById(R.id.edB1R);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.console().printf("FDFFFFF");
                        TextView tV=findViewById(R.id.etV1R_result);
                        EditText lado1=findViewById(R.id.edT1R);
                        EditText lado2=findViewById(R.id.edT2R);
                        tV.setText(String.valueOf(Float.parseFloat(datos[0].getText().toString())*Float.parseFloat(lado2.getText().toString())));
                    }
                });
                break;
/*            case  R.id.MnuOpc2Calcula:
                viewGroup=findViewById(R.id.viewGroup);
                getLayoutInflater().inflate(R.layout.objects_area_circle,viewGroup);
                break;
            case  R.id.MnuOpc3Calcula:
                viewGroup=findViewById(R.id.viewGroup);
                getLayoutInflater().inflate(R.layout.objects_area_triangle,viewGroup);
                break;
            case  R.id.MnuOpc4Calcula:
                viewGroup=findViewById(R.id.viewGroup);
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                break;*/
            default:
                break;

        }
    }
}
