package com.example.examen_ud1_aaron_palmer_peiro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class PantallaFactura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imagenPizza;
        TextView nombrePizza;
        TextView extra;
        TextView precio;
        TextView unidades;
        TextView envio;
        TextView coste;
        TextView operacion;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        Intent returnIntent = new Intent();
        setResult(this.RESULT_OK, returnIntent);
        AnalogClock reloj = findViewById(R.id.reloj);

        /* No da la hora*/
        String hora = reloj.toString();
        returnIntent.putExtra("hora", hora);


        Bundle recogerDatos = getIntent().getExtras();
        Factura factura = (Factura) recogerDatos.getSerializable("factura");

        imagenPizza = (ImageView) findViewById(R.id.imageView6);
        nombrePizza = (TextView) findViewById(R.id.nombrePizza);
        extra = (TextView) findViewById(R.id.extra);
        precio = (TextView) findViewById(R.id.precio);
        unidades = (TextView) findViewById(R.id.unidades);
        envio = (TextView) findViewById(R.id.envio);
        coste = (TextView) findViewById(R.id.coste);
        operacion = (TextView) findViewById(R.id.operacion);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox4);

        imagenPizza.setImageResource(factura.getPizza().getImagen());
        nombrePizza.setText(factura.getPizza().getNombre());
        extra.setText(String.valueOf(factura.getExtras()));
        precio.setText(String.valueOf(factura.getPizza().getPrecio()));
        unidades.setText(String.valueOf(factura.getNumero_unidades()));
        if (factura.getIncremento() > 0) {
            envio.setText("Envio Domicilio");
            coste.setText(String.valueOf((factura.getPizza().getPrecio() + factura.getExtras()) * factura.getNumero_unidades() * 1.1));
            operacion.setText("( (" + factura.getPizza().getPrecio() + "+" + factura.getExtras() + ")*" + factura.getNumero_unidades() + "*1.1)");
        } else {
            envio.setText("En Local");
            coste.setText(String.valueOf((factura.getPizza().getPrecio() + factura.getExtras()) * factura.getNumero_unidades() * 1.0));
            operacion.setText("( (" + factura.getPizza().getPrecio() + "+" + factura.getExtras() + ")*" + factura.getNumero_unidades() + "*1.0)");
        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( ((CheckBox)v).isChecked() ) {
                    finish();
                }
            }
        });

    }
}

