package com.example.examen_ud1_version_mejorada;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.ViewDragHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeleccionActivity extends AppCompatActivity {
    private List<Vehiculo> vehiculos;
    private Spinner spinnerVehiculos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        spinnerVehiculos=findViewById(R.id.spinnerVehiculos);
        AdaptadorVehiculo miAdaptador = new AdaptadorVehiculo(this);
        spinnerVehiculos.setAdapter(miAdaptador);


        String tipoVehiculo=savedInstanceState.getString("vehiculo");
        String[] precios=new String[]{"15","20","25"};
        String[] tipos= new String[]{"Montaña","Paseo","Ciudad"};
        Map<String, String[]> valores_Vehiculos=new HashMap<String, String[]>() {{
            put("coche", new String[]{"Todoterreno","Sport","Ciudad"});
            put("bicicleta", new String[]{"BMX","Carretera","Ciudad"});
            put("patinete", new String[]{"Sport","Carretera","Urban"});
        }};
        Vehiculo vehiculo;
        for(int i=0;i<tipos.length;i++){
            String pictureName=tipoVehiculo+i;
            int imagen=getResources().getIdentifier(pictureName, "drawable", getPackageName());
            vehiculo=new Vehiculo(tipos[i],valores_Vehiculos.get(tipoVehiculo)[i],precios[i],imagen);
            vehiculos.add(vehiculo);
        }



/*        Button buttonContinuar=findViewById(R.id.btnContinuar);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vehiculo!=null){
                    Intent seleccionIntent=new Intent(MainActivity.this,SeleccionActivity.class);
                    Bundle datos= new Bundle();
                    datos.putString("vehiculo",vehiculo);
                    seleccionIntent.putExtras(datos);
                    startActivity(seleccionIntent);
                }

            }
        });*/
    }
    class AdaptadorVehiculo extends ArrayAdapter<Vehiculo> {
        public Activity miActividad;

        public AdaptadorVehiculo(Activity laActividad){
            super(laActividad,R.layout.spinner_content,vehiculos);
            this.miActividad=laActividad;

        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int position,View convertView, ViewGroup Parent){
            LayoutInflater inflater=miActividad.getLayoutInflater();
            View item = inflater.inflate(R.layout.spinner_content,null);

            TextView lblPrecio= item.findViewById(R.id.tVPrecio);
            TextView lblTipo= item.findViewById(R.id.tVTipo);
            TextView lblModelo= item.findViewById(R.id.tVModelo);
            ImageView imgVVehiculo=item.findViewById(R.id.imageViewModelo);

            lblPrecio.setText(vehiculos.get(position).getPrecio());
            lblTipo.setText(vehiculos.get(position).getTipo());
            lblModelo.setText(vehiculos.get(position).getModelo());
            imgVVehiculo.setImageResource(vehiculos.get(position).getImagen());

            return item;
        }

    }
}
