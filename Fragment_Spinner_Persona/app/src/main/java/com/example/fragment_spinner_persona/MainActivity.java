package com.example.fragment_spinner_persona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner miSpinner;
    private Persona[] personas=new Persona[]{
            new Persona("Angeles","Campos",21, R.drawable.persona_1, "Camarera, Repartidora", "ESO, Bachillerato"),
            new Persona("Maria","Martinez",32, R.drawable.persona_2, "Vendedora, Química", "ESO, Bachillerato, Universidad"),
            new Persona("Angel","Peiró",20, R.drawable.persona_3, "Cocinero", "ESO, Bachillerato, FP Cocina"),
            new Persona("Juan","Alvarado",24, R.drawable.persona_4, "Informático", "ESO, Bachillerato, Universidad"),
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
                addFragment(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }
    void addFragment(int position) {
        // Instanciamos nuevo Fragment
        Fragment newFragment = Fragmento.newInstance(personas[position]);
        // Se aÃ±ade el Fragment a la actividad
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.commit();
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
            ImageView imgFoto = item.findViewById(R.id.imgVSpinner);
            TextView lblNombre= item.findViewById(R.id.campoNombre);
            TextView lblApellido= item.findViewById(R.id.campoApellido);
            TextView lblEdad= item.findViewById(R.id.campoEdad);

            imgFoto.setImageResource(personas[position].getFoto());
            lblNombre.setText(personas[position].getNombre());
            lblApellido.setText(personas[position].getApellido());
            lblEdad.setText(String.valueOf(personas[position].getEdad()));

            return item;
        }

    }
}
