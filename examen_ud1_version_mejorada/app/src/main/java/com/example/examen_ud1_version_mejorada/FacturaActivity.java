package com.example.examen_ud1_version_mejorada;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FacturaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        Factura factura= (Factura) getIntent().getExtras().getSerializable("factura");

        ImageView fotoVehiculo=findViewById(R.id.imageViewModeloFactura);
        fotoVehiculo.setImageResource(factura.getIdImagen());

        TextView modelo=findViewById(R.id.textViewModelo);
        modelo.setText(factura.getModelo());

        TextView precio=findViewById(R.id.textViewPrecioPorHoras);
        precio.setText(factura.getPrecio());

        TextView extras=findViewById(R.id.textViewExtras);
        extras.setText(factura.getExtras());

        TextView tiempo=findViewById(R.id.textViewTiempo);
        tiempo.setText(factura.getTiempo());

        TextView seguro = findViewById(R.id.textViewSeguro);
        seguro.setText(factura.getSeguro());

        TextView precioTotal=findViewById(R.id.textViewCosteTotal);
        precioTotal.setText(factura.getCosteTotal());
    }

}
