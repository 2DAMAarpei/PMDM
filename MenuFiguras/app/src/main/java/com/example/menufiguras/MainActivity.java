package com.example.menufiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.helpButton));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        ViewGroup viewGroup = findViewById(R.id.viewGroup);
        viewGroup.removeAllViews();
        switch (item.getItemId()) {
            case  R.id.MnuOpc1Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_rectangle,viewGroup);
                Button area_rectangle_calculate=findViewById(R.id.edB1R);
                area_rectangle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1R);
                        EditText edT2=findViewById(R.id.edT2R);
                        TextView resultado=findViewById(R.id.etV1R_result);
                        resultado.setText(String.valueOf(Float.parseFloat(edT1.getText().toString())*Float.parseFloat(edT2.getText().toString())));
                    }
                });
                break;
            case  R.id.MnuOpc2Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_circle,viewGroup);
                Button area_circle_calculate=findViewById(R.id.edB1C);

                area_circle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1C);
                        TextView resultado=findViewById(R.id.etV1C_result);
                        resultado.setText(String.valueOf(Math.PI*Math.pow(Float.parseFloat(edT1.getText().toString()),2 )));
                    }
                });
                break;
            case  R.id.MnuOpc3Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_triangle,viewGroup);
                Button area_triangle_calculate=findViewById(R.id.edB1T);
                area_triangle_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1T);
                        EditText edT2=findViewById(R.id.edT2T);
                        TextView resultado=findViewById(R.id.etV1T_result);
                        resultado.setText(String.valueOf((Float.parseFloat(edT1.getText().toString())*Float.parseFloat(edT2.getText().toString()))/2));
                    }
                });
                break;
            case  R.id.MnuOpc4Calcula:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                Button area_square_calculate=findViewById(R.id.edB1T);
                area_square_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1S);
                        TextView resultado=findViewById(R.id.etV1S_result);
                        resultado.setText(String.valueOf(Math.pow(Float.parseFloat(edT1.getText().toString()),2)));
                    }
                });
                break;
            case  R.id.MnuOpc1Dibuja:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                Button area_rect_calculate=findViewById(R.id.edB1T);
                area_square_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1S);
                        TextView resultado=findViewById(R.id.etV1S_result);
                        resultado.setText(String.valueOf(Math.pow(Float.parseFloat(edT1.getText().toString()),2)));
                    }
                });
                break;
            case  R.id.MnuOpc2Dibuja:
                getLayoutInflater().inflate(R.layout.draw_bitmap,viewGroup);
                BitmapDrawable draw;
                draw.
                logo=(BitmapDrawable)res.getDrawable(R.drawable.pizzadepepperoni2);
                logo.setBounds(new Rect(30,50,200,200));
                break;
            case  R.id.MnuOpc3Dibuja:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                Button area_square_calculate=findViewById(R.id.edB1T);
                area_square_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1S);
                        TextView resultado=findViewById(R.id.etV1S_result);
                        resultado.setText(String.valueOf(Math.pow(Float.parseFloat(edT1.getText().toString()),2)));
                    }
                });
                break;
            case  R.id.MnuOpc4Dibuja:
                getLayoutInflater().inflate(R.layout.objects_area_square,viewGroup);
                Button area_square_calculate=findViewById(R.id.edB1T);
                area_square_calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText edT1=findViewById(R.id.edT1S);
                        TextView resultado=findViewById(R.id.etV1S_result);
                        resultado.setText(String.valueOf(Math.pow(Float.parseFloat(edT1.getText().toString()),2)));
                    }
                });
                break;
            default:
                break;

        }
        return true;
    }
   @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CtxLblOpc1:
                Toast.makeText(this, "Calcula el  area de la figura pasandole los datos necesarios", Toast.LENGTH_LONG).show();
                return true;
            case R.id.CtxLblOpc2:
                Toast.makeText(this, "Dibuja la figura", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

}

