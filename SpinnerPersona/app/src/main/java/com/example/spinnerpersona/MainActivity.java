package com.example.spinnerpersona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner miSpinner;
    private Persona[] personas=new Persona[]{
      new Persona("Angeles","Campos",21),new Persona("Consuelo","Martin",20),new Persona("Fernando","Molina",26)

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miSpinner=findViewById(R.id.spPersona);
        AdaptadorPersona miAdaptador = new AdaptadorPersona(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje="";
                mensaje="Item clicked =>"+personas[position];
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }
    class AdaptadorPersona extends ArrayAdapter<Persona> {
        public Activity miActividad;

        public AdaptadorPersona(Activity laActividad){
            super(laActividad,R.layout.desmilista,personas);
            this.miActividad=laActividad;

        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int position,View convertView, ViewGroup Parent){
            LayoutInflater inflater=miActividad.getLayoutInflater();
            View item = inflater.inflate(R.layout.desmilista,null);

            TextView lblNombre= item.findViewById(R.id.campoNombre);
            TextView lblApellido= item.findViewById(R.id.campoApellido);
            TextView lblEdad= item.findViewById(R.id.campoEdad);

            lblNombre.setText(personas[position].getNombre());
            lblApellido.setText(personas[position].getApellido());
            lblEdad.setText(String.valueOf(personas[position].getEdad()));

            return item;
        }

    }
}
